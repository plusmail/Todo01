package kroryi.DTO;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TDD(Test Driven Development)
public class ConnectTests {
//
//    @Test
//    public void testConnect() {
//        int v1 = 10;
//
//        int v2 = 20;
//        Assertions.assertEquals(v1,v2);
//    }
//
//    @Test
//    public void testConnect2() {
//        int v1 = 10;
//
//        int v2 = 10;
//        Assertions.assertEquals(v1,v2);
//    }
//
//    @Test
//    public void testConnectMysql() throws Exception {
//        // Class.forName 패키지경로를 문자열로 지정을 해주면 지정된 클래스를 로딩
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/webdb",
//                "root",
//                "1333"
//        );
//
//        Assertions.assertNotNull(con);
//        con.close();
//
//    }
//
//    @Test
//    public void testHikariCP() throws Exception {
//        HikariConfig config = new HikariConfig();
//        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/webdb");
//        config.setUsername("root");
//        config.setPassword("1333");
//        config.addDataSourceProperty("cachePrepStmts", "true");
//        config.addDataSourceProperty("prepStmtCacheSize", "250"); // select * from ABC where name=? and age = ?;
//        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//        config.setMaximumPoolSize(10); // 최대 컨넥션 수
//        config.setMinimumIdle(5); // 최소 유효 컨넥션 수
//        config.setIdleTimeout(30000); // 유효 켠넥션 유지 시간
//        config.setMaxLifetime(1800000); // 컨넥션 최대 수명
//        config.setConnectionTimeout(30000); // 연결 대기 시간
//        config.setConnectionTestQuery("SELECT 1");
//
//        HikariDataSource ds = new HikariDataSource(config);
//        Connection con = ds.getConnection();
//        System.out.println(con);
//        con.close();
//
//    }
//


}
