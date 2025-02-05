package kroryi.DAO;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public enum ConnectionUtil {

    INSTANCE;
    // 인스턴스 객체 생성을 1개만 생성 하도록 제약
    // private static final ConnectionUtil INSTANCE = new ConnectionUtil();

    private HikariDataSource ds;

    ConnectionUtil() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/webdb");
        config.setUsername("root");
        config.setPassword("1333");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250"); // select * from ABC where name=? and age = ?;
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.setMaximumPoolSize(10); // 최대 컨넥션 수
        config.setMinimumIdle(5); // 최소 유효 컨넥션 수
        config.setIdleTimeout(30000); // 유효 켠넥션 유지 시간
        config.setMaxLifetime(1800000); // 컨넥션 최대 수명
        config.setConnectionTimeout(30000); // 연결 대기 시간

        this.ds = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
