package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.singleton;

import com.pioneers.rest.exampleforme.controllers.models.di.db.ConnectionPool;
import com.pioneers.rest.exampleforme.controllers.models.di.db.DbConnector;

public class ThreadSafeDbConnector {
    private static ThreadSafeDbConnector INSTANCE;

    private final DbConnector dbConnector =
            new DbConnector("","","","",new ConnectionPool(0,0,0));

    private ThreadSafeDbConnector() {
    }

    public  static synchronized ThreadSafeDbConnector getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ThreadSafeDbConnector();
        }
        return INSTANCE;
    }

    public DbConnector getDbConnector() {
        return dbConnector;
    }
}
