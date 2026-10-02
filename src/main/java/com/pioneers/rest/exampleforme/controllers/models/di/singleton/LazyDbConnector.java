package com.pioneers.rest.exampleforme.controllers.models.di.singleton;

import com.pioneers.rest.exampleforme.controllers.models.di.db.ConnectionPool;
import com.pioneers.rest.exampleforme.controllers.models.di.db.DbConnector;

public class LazyDbConnector {
    private static LazyDbConnector INSTANCE;

    private final DbConnector dbConnector =
            new DbConnector("","","","",new ConnectionPool(0,0,0));

    private LazyDbConnector() {
    }

    public static LazyDbConnector getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new LazyDbConnector();
        }
        return INSTANCE;
    }

    public DbConnector getDbConnector() {
        return dbConnector;
    }
}
