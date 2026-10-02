package com.pioneers.rest.exampleforme.controllers.models.di.db;

import jakarta.validation.Valid;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;
@ConfigurationProperties(prefix = "db")
@Validated
public class DbProperties {
//@NotBlank(message = "string trim empty")
//    @NotNull(message = "not null")
    private final String userName;
    private final String password;
    private final String database;
    private final String url;
    @Valid
    private final ConnectionPoolProperties connectionPool;

    public static class ConnectionPoolProperties {
        private final int maxOpenConnections;
        private final int maxIdleConnections;
//        @Max(value = 2000,message = "maximum number is 2000")
//        @Min(value = 1000,message = "minmum number is 10000")
//        @NotBlank()
//        @NotNull(message = "not null")
//        @Positive(message = "+")
//        @Negative(message = "+")
        private final int timeOut;

        public ConnectionPoolProperties(int maxOpenConnections, int maxIdleConnections,int timeOut) {
            this.maxOpenConnections = maxOpenConnections;
            this.maxIdleConnections = maxIdleConnections;
            this.timeOut = timeOut;
        }

        public int getMaxOpenConnections() {
            return maxOpenConnections;
        }

        public int getMaxIdleConnections() {
            return maxIdleConnections;
        }

        public int getTimeOut() {
            return timeOut;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            ConnectionPoolProperties that = (ConnectionPoolProperties) o;
            return maxOpenConnections == that.maxOpenConnections
                    && maxIdleConnections == that.maxIdleConnections
                    && timeOut == that.timeOut;
        }

        @Override
        public int hashCode() {
            return Objects.hash(maxOpenConnections, maxIdleConnections, timeOut);
        }

        @Override
        public String toString() {
            return "ConnectionPoolProperties{" +
                    "maxOpenConnections=" + maxOpenConnections +
                    ", maxIdleConnections=" + maxIdleConnections +
                    ", timeOut=" + timeOut +
                    '}';
        }
    }

    public DbProperties(String userName,
                        String password,
                        String database,
                        String url,
                        ConnectionPoolProperties connectionPool
    ) {
        this.userName = userName;
        this.password = password;
        this.database = database;
        this.url = url;
        this.connectionPool = connectionPool;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabase() {
        return database;
    }

    public String getUrl() {
        return url;
    }

    public ConnectionPoolProperties getConnectionPoolProperties() {
        return connectionPool;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DbProperties that = (DbProperties) o;
        return Objects.equals(userName, that.userName)
                && Objects.equals(password, that.password)
                && Objects.equals(database, that.database)
                && Objects.equals(url, that.url)
                && Objects.equals(connectionPool, that.connectionPool
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, database, url, connectionPool);
    }

    @Override
    public String toString() {
        return "DbProperties{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", database='" + database + '\'' +
                ", url='" + url + '\'' +
                ", connectionPoolProperties=" + connectionPool +
                '}';
    }
}
