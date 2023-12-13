package com.grocerystore.store;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<RedirectFilter> customFilter() {
        FilterRegistrationBean<RedirectFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RedirectFilter());
        registrationBean.addUrlPatterns("/login");
        registrationBean.setOrder(1); // Set the order (lower values execute first)
        return registrationBean;
    }
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:5173"); // Replace with the actual origin of your React app
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
