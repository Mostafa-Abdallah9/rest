package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.singleton;

import com.pioneers.rest.exampleforme.controllers.models.di.db.ConnectionPool;
import com.pioneers.rest.exampleforme.controllers.models.di.db.DbConnector;

public enum EnumDbConnector {
    ISTANCE;

    private final DbConnector dbConnector
            = new DbConnector("","","","",
            new ConnectionPool(0,0,0));

    public DbConnector getDbConnector() {
        return dbConnector;
    }
}
