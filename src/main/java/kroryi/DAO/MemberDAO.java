package kroryi.DAO;

import kroryi.VO.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {


    public void insert(MemberVO vo) throws Exception {
        String sql = "INSERT INTO tbl_member(mid, mpw, mname, memail) values (?,?,?,?)";
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

}
