package com.pioneers.rest.exampleforme.controllers.models.di.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class PostgresCondition implements Condition {
    private static final Logger log = LoggerFactory.getLogger(PostgresCondition.class);
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
     final Environment environment = context.getEnvironment();
     final String[] activeProfiles = environment.getActiveProfiles();

     log.info("NO OF ACTIVE PROFILE =[{}] " , activeProfiles.length);

     final boolean isPostgresEnable = Boolean.parseBoolean(environment.getProperty("db.postgres.enable"));
        final boolean isliquibaseEnable = Boolean.parseBoolean(environment.getProperty("db.liquibase.enabled"));
        return isliquibaseEnable&&isPostgresEnable;
    }
}
