package kroryi.DAO;

import kroryi.VO.MemberVO;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MemberDAO {

    // 바인딩된 값으로 SQL 쿼리를 대체하는 메서드
    public String preparedStatementToString(String sql, Object... params) {
        for (Object param : params) {
            String value = (param instanceof String) ? "'" + param + "'" : param.toString();
            sql = sql.replaceFirst("\\?", value);
        }
        return sql;
    }

    public MemberVO getMemberWithPasswordCheck(String mid, String mpw) throws Exception {
        String sql = "SELECT mid, mname, memail, " +
                "CASE WHEN mpw = SHA2(?, 256) THEN 1 ELSE 0 END AS password_match " +
                "FROM tbl_member WHERE mid = ?";

        @Cleanup Connection con = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = con.prepareStatement(sql);

//        log.info("getMemberWithPasswordCheck {}", preparedStatementToString(sql, mpw, mid));

        psmt.setString(1, mpw);  // 비밀번호 입력값
        psmt.setString(2, mid);  // 사용자 ID

        @Cleanup ResultSet rs = psmt.executeQuery();

        if (rs.next()) {
            MemberVO vo = MemberVO.builder()
                    .mid(rs.getString("mid"))
                    .mname(rs.getString("mname"))
                    .memail(rs.getString("memail"))
                    .password_match(rs.getString("password_match"))
                    .build();
            log.info(vo.toString());
//            test01,홍길동,a@a.co.kr,1

            return vo;
        }
        return null;
    }


    public void insert(MemberVO vo) throws Exception {
        String sql = "INSERT INTO tbl_member(mid, mpw, mname, memail) values (?,SHA2(?,256),?,?)";
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = con.prepareStatement(sql);

        psmt.setString(1, vo.getMid());
        psmt.setString(2, vo.getMpw());
        psmt.setString(3, vo.getMname());
        psmt.setString(4, vo.getMemail());
        psmt.executeUpdate();

    }

    public List<MemberVO> selectAll() throws Exception {

        String sql = "SELECT * FROM tbl_member";
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = con.prepareStatement(sql);
        @Cleanup ResultSet rs = psmt.executeQuery();

        List<MemberVO> list = new ArrayList<>();
        while (rs.next()) {
            MemberVO vo = MemberVO.builder()
                    .mid(rs.getString("mid"))
                    .mpw(rs.getString("mpw"))
                    .mname(rs.getString("mname"))
                    .memail(rs.getString("memail"))
                    .build();
            list.add(vo);
        }
        return list;
    }

    public MemberVO selectOne(String mid) throws Exception {
        String sql = "SELECT * FROM tbl_member where mid = ?";
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, mid);

        @Cleanup ResultSet rs = psmt.executeQuery();
        rs.next();
        MemberVO vo = MemberVO.builder()
                .mid(rs.getString("mid"))
                .mpw(rs.getString("mpw"))
                .mname(rs.getString("mname"))
                .memail(rs.getString("memail"))
                .build();

        return vo;
    }

    public void deleteOne(String mid) throws Exception {
        String sql = "DELETE FROM tbl_member where mid = ?";
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, mid);
        psmt.executeUpdate();
    }

    public void updateOne(MemberVO vo) throws Exception {
        String sql = "UPDATE tbl_member set mpw = ?, mname = ?, memail = ? " +
                "where mid = ?";

        @Cleanup Connection con = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = con.prepareStatement(sql);

        psmt.setString(1, vo.getMpw());
        psmt.setString(2, vo.getMname());
        psmt.setString(3, vo.getMemail());
        psmt.setString(4, vo.getMid());

        psmt.executeUpdate();
    }

    public void updateUuid(String mid, String uuid) throws SQLException {

        String sql = "UPDATE tbl_member set uuid = ? where mid = ?";
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, uuid);
        psmt.setString(2, mid);
        psmt.executeUpdate();
    }

    public MemberVO selectUUID(String uuid) throws Exception {
        String sql = "SELECT mid,mpw,mname,uuid FROM tbl_member where uuid = ?";
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, uuid);
        @Cleanup ResultSet rs = psmt.executeQuery();
        rs.next();
        MemberVO vo = MemberVO.builder()
                .mid(rs.getString(1))
                .mpw(rs.getString(2))
                .mname(rs.getString(3))
                .uuid(rs.getString(4))
                .build();

        return vo;
    }


}
