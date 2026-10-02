package com.pioneers.rest.exampleforme.controllers.models.di.singleton;

import com.pioneers.rest.exampleforme.controllers.models.di.db.DbConnector;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("singleton1")
public class BeanInjection1ControllerLazy {
    private  LazyDbConnector lazyDbConnector;

//    public BeanInjection1ControllerLazy(LazyDbConnector lazyDbConnector) {
//        this.lazyDbConnector = lazyDbConnector;
//    }


    @GetMapping("dbConnector")
    public DbConnector getDbConnectorApi() {
        return LazyDbConnector.getINSTANCE().getDbConnector();
    }

    @PutMapping("update")
    public void updateDbConnectorApi(@RequestBody DbConnector dbConnector) {
        LazyDbConnector.getINSTANCE().getDbConnector().setUserName(dbConnector.getUserName());
        LazyDbConnector.getINSTANCE().getDbConnector().setPassword(dbConnector.getPassword());
        LazyDbConnector.getINSTANCE().getDbConnector().setDatabase(dbConnector.getDatabase());
        LazyDbConnector.getINSTANCE().getDbConnector().setUrl(dbConnector.getUrl());
        LazyDbConnector.getINSTANCE().getDbConnector().setConnectionPool(dbConnector.getConnectionPool());
    }

}
