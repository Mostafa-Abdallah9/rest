package com.pioneers.rest.exampleforme.controllers.models.di.db;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DbConnector {

    private String userName;
    private String password;
    private String database;
    private String url;
    private ConnectionPool connectionPool;

}
