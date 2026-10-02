package com.pioneers.rest.exampleforme.controllers.models.di.db;

public record ConnectionPool(int maxOpenConnections,int maxIdleConnections,int timeOut) {


}
