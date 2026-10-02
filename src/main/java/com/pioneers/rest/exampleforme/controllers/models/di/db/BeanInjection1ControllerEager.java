package com.pioneers.rest.exampleforme.controllers.models.di.db;

import com.pioneers.rest.exampleforme.controllers.models.di.singleton.EagerDbConnector;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("controller1")
public class BeanInjection1ControllerEager {
    private final EagerDbConnector dbConnector = EagerDbConnector.getINSTANCE();

    @GetMapping("dbConnector")
    public DbConnector getDbConnectorApi() {
        return dbConnector.getDbConnector();
    }

    @PutMapping("update")
    public void updateDbConnectorApi(@RequestBody DbConnector dbConnector) {
        this.dbConnector.getDbConnector().setUserName(dbConnector.getUserName());
        this.dbConnector.getDbConnector().setPassword(dbConnector.getPassword());
        this.dbConnector.getDbConnector().setDatabase(dbConnector.getDatabase());
        this.dbConnector.getDbConnector().setUrl(dbConnector.getUrl());
        this.dbConnector.getDbConnector().setConnectionPool(dbConnector.getConnectionPool());
    }

}
