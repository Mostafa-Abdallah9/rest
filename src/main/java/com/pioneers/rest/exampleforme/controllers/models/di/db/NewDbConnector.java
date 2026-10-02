package com.pioneers.rest.exampleforme.controllers.models.di.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@AllArgsConstructor
public class NewDbConnector {
    private static final Logger log = LoggerFactory.getLogger(NewDbConnector.class);

    private final String username;
    private final String password;
    private final String database;
    private final String url;
    private final ConnectionPool connectionPool;

    private void connect(
            final String username,
            final String password,
            final String database,
            final String url,
            final ConnectionPool connectionPool
    ) {
       final String[] args = {database, username, url};

        log.info("New Connecting to database [{}] with username   [{}]  and [{}] " , (Object[])args);

        final String[] args2 = {database,url};

        log.info("New Successfully connected to database  [{}] with url  [{}]",(Object[])args2);
    }


}
