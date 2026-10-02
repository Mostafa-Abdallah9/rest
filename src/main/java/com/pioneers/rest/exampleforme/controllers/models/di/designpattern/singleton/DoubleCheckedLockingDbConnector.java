package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.singleton;

import com.pioneers.rest.exampleforme.controllers.models.di.db.ConnectionPool;
import com.pioneers.rest.exampleforme.controllers.models.di.db.DbConnector;

public class DoubleCheckedLockingDbConnector {
    private static DoubleCheckedLockingDbConnector INSTANCE;

    private final DbConnector dbConnector =
            new DbConnector("","","","",new ConnectionPool(0,0,0));

    private DoubleCheckedLockingDbConnector() {
    }

    public  static DoubleCheckedLockingDbConnector getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckedLockingDbConnector.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckedLockingDbConnector();
                }
            }
        }
        return INSTANCE;

    }

    public DbConnector getDbConnector() {
        return dbConnector;
    }
}
