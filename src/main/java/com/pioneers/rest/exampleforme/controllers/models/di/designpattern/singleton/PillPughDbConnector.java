package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.singleton;

import com.pioneers.rest.exampleforme.controllers.models.di.db.ConnectionPool;
import com.pioneers.rest.exampleforme.controllers.models.di.db.DbConnector;

public class PillPughDbConnector {
    private final DbConnector dbConnector;

    private PillPughDbConnector() {
        dbConnector = new DbConnector("","","","",new ConnectionPool(0,0,0));
    }

    public static class DbConnectorHolder {
        private static PillPughDbConnector INSTANCE = new PillPughDbConnector();
    }
    public PillPughDbConnector getINSTANCE() {
        return DbConnectorHolder.INSTANCE;
    }

    public DbConnector getDbConnector() {
        return dbConnector;
    }
}
