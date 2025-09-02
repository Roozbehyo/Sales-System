package com.mftplus.model.tools;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

public class JpaProvider {
    @Getter
    private static JpaProvider provider = new JpaProvider();

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("sales-system");

private JpaProvider() {}
    public EntityManager getEntityManager() {
    return factory.createEntityManager();
    }
}
