package com.pioneers.rest.exampleforme.controllers.models.di.designpattern.singleton;

import com.pioneers.rest.exampleforme.controllers.models.di.db.DbConnector;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("singleton5")
public class BeanInjection2ControllerDouble {
    private DoubleCheckedLockingDbConnector doubleCheckedLockingDbConnector;

    @GetMapping("dbConnector")
    public DbConnector getDbConnectorApi() {
        return DoubleCheckedLockingDbConnector.getINSTANCE().getDbConnector();
    }

    @PutMapping("update")
    public void updateDbConnectorApi(@RequestBody DbConnector dbConnector) {
        DoubleCheckedLockingDbConnector.getINSTANCE().getDbConnector().setUserName(dbConnector.getUserName());
        DoubleCheckedLockingDbConnector.getINSTANCE().getDbConnector().setPassword(dbConnector.getPassword());
        DoubleCheckedLockingDbConnector.getINSTANCE().getDbConnector().setDatabase(dbConnector.getDatabase());
        DoubleCheckedLockingDbConnector.getINSTANCE().getDbConnector().setUrl(dbConnector.getUrl());
        DoubleCheckedLockingDbConnector.getINSTANCE().getDbConnector().setConnectionPool(dbConnector.getConnectionPool());
    }
}
