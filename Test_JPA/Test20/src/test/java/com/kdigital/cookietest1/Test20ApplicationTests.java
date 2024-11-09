package com.kdigital.cookietest1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class Test20ApplicationTests {

    @PersistenceContext
    private EntityManager entityManager; // EntityManager 주입

    @Test
    @Transactional
    void contextLoads() {
        
    }

}

