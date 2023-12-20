package com.grocerystore.store;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.util.StreamUtils;

@Repository
public class UserSchemaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createUserSchema(String schemaName) {
        entityManager.createNativeQuery("CREATE SCHEMA IF NOT EXISTS " + schemaName).executeUpdate();
    }
    @Transactional
    public void activateUserSchema(String schemaName) {
        entityManager.createNativeQuery("SET search_path TO " + schemaName).executeUpdate();
    }

    @Transactional
    public void initializeSchema(String schemaName) {
        createUserSchema(schemaName);
        activateUserSchema(schemaName);
        executeSQLStatements("schemaData.sql");
    }
    private String readSQLFile(String filePath) {
    try {
        ClassPathResource resource = new ClassPathResource(filePath);
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
  }
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  private void executeSQLStatements(String filePath) {
    String sqlContent = readSQLFile(filePath);
    System.out.println(sqlContent);
    if (sqlContent != null) {
        String[] sqlStatements = sqlContent.split(";");
        System.out.println(sqlStatements);
        for (String sqlStatement : sqlStatements) {
                System.out.println(sqlStatement);
            entityManager.createNativeQuery(sqlStatement).executeUpdate();
        }
    }
  }
}
