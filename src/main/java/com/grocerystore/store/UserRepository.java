package com.grocerystore.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo,Long>{
    UserInfo findByUsername(String username);
    void deleteByUsernameAndBusinessName(String userName, String businessname);

}
