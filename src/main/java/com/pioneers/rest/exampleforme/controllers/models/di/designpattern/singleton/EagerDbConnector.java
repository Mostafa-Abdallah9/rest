package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.singleton;

import com.pioneers.rest.exampleforme.controllers.models.di.db.ConnectionPool;
import com.pioneers.rest.exampleforme.controllers.models.di.db.DbConnector;

public class EagerDbConnector {

    private static final EagerDbConnector INSTANCE = new EagerDbConnector();

    private final DbConnector dbConnector;

    private EagerDbConnector(){
        dbConnector = new DbConnector("","","","",new ConnectionPool(0,0,0));
    }

    public static EagerDbConnector getINSTANCE() {
        return INSTANCE;
    }

    public void insert() {
        System.out.println("Inserting object to Db.....");
    }

    public void delete() {
        System.out.println("Deleting Object from table.....");
    }

    public DbConnector getDbConnector() {
        return dbConnector;
    }
}
