package com.pioneers.rest.exampleforme.controllers.models.di.singleton;

import com.pioneers.rest.exampleforme.controllers.models.di.db.DbConnector;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("singleton3")
public class BeanInjection1ControllerThread {
    private ThreadSafeDbConnector threadSafeDbConnector;

    @GetMapping("dbConnector")
    public DbConnector getDbConnectorApi() {
        return ThreadSafeDbConnector.getINSTANCE().getDbConnector();
    }

    @PutMapping("update")
    public void updateDbConnectorApi(@RequestBody DbConnector dbConnector) {
        ThreadSafeDbConnector.getINSTANCE().getDbConnector().setUserName(dbConnector.getUserName());
        ThreadSafeDbConnector.getINSTANCE().getDbConnector().setPassword(dbConnector.getPassword());
        ThreadSafeDbConnector.getINSTANCE().getDbConnector().setDatabase(dbConnector.getDatabase());
        ThreadSafeDbConnector.getINSTANCE().getDbConnector().setUrl(dbConnector.getUrl());
        ThreadSafeDbConnector.getINSTANCE().getDbConnector().setConnectionPool(dbConnector.getConnectionPool());
    }
}
