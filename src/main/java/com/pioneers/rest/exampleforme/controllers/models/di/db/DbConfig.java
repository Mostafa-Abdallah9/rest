package com.pioneers.rest.exampleforme.controllers.models.di.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DbProperties.class)
public class DbConfig {
private DbProperties dbProperties;
//    @Value("${db.userName}")
//    private String userName;
//    @Value("${db.password}")
//    private String password;
//    @Value("${db.database}")
//    private String database;
//    @Value("${db.url}")
//    private String url;
//    @Value("${db.connectionPool.maxOpenConnections}")
//    private int maxOpenConnections;
//    @Value("${db.connectionPool.maxIdleConnections}")
//    private int maxIdleConnections;
//    @Autowired
//    private ConnectionPool connectionPool;
//    @Value("${db.connectionPool.timeOut}")
//    private int timeOut;

@Autowired
    public DbConfig(DbProperties dbProperties) {
        this.dbProperties = dbProperties;
    }

//    @Bean
//    public ConnectionPool connectionPool(){
//        System.out.println("mmm");
//        return new ConnectionPool(
//                dbProperties.getConnectionPoolProperties().getMaxOpenConnections(),
//                dbProperties.getConnectionPoolProperties().getMaxIdleConnections()
//        );
//    }

//    @Bean
//    @Profile({"dev","local"})
//    @Profile("dev")
//@ConditionalOnProperty(name = "dp.connectionPool.flow",havingValue = "false")
//    @ConditionalOnProperties( @ConditionalOnProperty(name = "dp.connectionPool.flow",havingValue = "true"))
//    @Conditional(PostgresCondition.class)
//    @ConditionalOnClass(name = "com.pioneers.rest.models.di.db.Exper")
//    @ConditionalOnClass(Exper.class)
//@ConditionalOnMissingBean(DbConfig.class)
//    @ConditionalOnClass(DbConfig.class)
    public DbConnector dbConnector(final ApplicationContext applicationContext) {
//            final DbProperties.ConnectionPoolProperties dbProperties1 = dbProperties.getConnectionPoolProperties();
//            final ConnectionPool connectionPool = new ConnectionPool(
//                  dbProperties1.getMaxIdleConnections()
//                  ,dbProperties1.getMaxOpenConnections());
        System.out.println("saaaaaaaaaaaaaaaaaasaaaaaaaaaaaaaaaaa");
        final ConnectionPool connectionPool = DbConfig.toConnectionPool(dbProperties);
        System.out.println(dbProperties.getUserName() + " " + dbProperties.getPassword()
                + " " +dbProperties.getDatabase()+ " " + dbProperties.getUrl() + " " +
               dbProperties.getConnectionPoolProperties().getMaxIdleConnections()+" " +
                dbProperties.getConnectionPoolProperties().getMaxIdleConnections() +" "
                +dbProperties.getConnectionPoolProperties().getTimeOut());
        return new DbConnector(dbProperties.getUserName(),
                dbProperties.getPassword(),
                dbProperties.getDatabase(),
                dbProperties.getUrl(),
//                applicationContext.getBean(ConnectionPool.class));
                connectionPool);
//                connectionPool());

    }

    private static ConnectionPool toConnectionPool(final DbProperties dbProperties) {
        final ConnectionPool connectionPool= new ConnectionPool(
                dbProperties.getConnectionPoolProperties().getMaxIdleConnections(),
                dbProperties.getConnectionPoolProperties().getMaxIdleConnections(),
                dbProperties.getConnectionPoolProperties().getTimeOut()
        );
        return connectionPool;
    }


}
