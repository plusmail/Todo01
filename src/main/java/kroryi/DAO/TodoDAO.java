package kroryi.DAO;

import kroryi.VO.TodoVO;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {

    String now = null;

    public String getTime() {
        try (
                Connection con = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement psmt = con.prepareStatement("select now()");
                ResultSet rs = psmt.executeQuery();
        ) {
            rs.next();
            now = rs.getString(1);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return now;
    }

    public String getTime2() throws Exception {

        @Cleanup Connection con = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = con.prepareStatement("select now()");
        @Cleanup ResultSet rs = psmt.executeQuery();
        rs.next();
        now = rs.getString(1);
        return now;
    }

    public void insert(TodoVO vo) throws Exception {
        String sql = "INSERT INTO tbl_todo(title,dueDate,finished) values (?,?,?)";
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = con.prepareStatement(sql);

        psmt.setString(1, vo.getTitle());
        psmt.setDate(2, Date.valueOf(vo.getDueDate()));
        psmt.setBoolean(3, vo.isFinished());
        psmt.executeUpdate();

    }

    public List<TodoVO> selectAll() throws Exception {

        String sql = "SELECT * FROM tbl_todo";
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = con.prepareStatement(sql);
        @Cleanup ResultSet rs = psmt.executeQuery();

        List<TodoVO> list = new ArrayList<>();
        while (rs.next()) {
            TodoVO vo = TodoVO.builder()
                    .tno(rs.getLong("tno"))
                    .title(rs.getString("title"))
                    .dueDate(rs.getDate("dueDate").toLocalDate())
                    .finished(rs.getBoolean("finished"))
                    .build();
            list.add(vo);
        }
        return list;
    }

    public TodoVO selectOne(Long tno) throws Exception {
        String sql = "SELECT * FROM tbl_todo where tno = ?";
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setLong(1, tno);

        @Cleanup ResultSet rs = psmt.executeQuery();
        rs.next();
        TodoVO vo = TodoVO.builder()
                .tno(rs.getLong("tno"))
                .title(rs.getString("title"))
                .dueDate(rs.getDate("dueDate").toLocalDate())
                .finished(rs.getBoolean("finished"))
                .build();

        return vo;
    }

    public void deleteOne(Long tno) throws Exception {
        String sql = "DELETE FROM tbl_todo where tno = ?";
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setLong(1, tno);
        psmt.executeUpdate();
    }

    public void updateOne(TodoVO todoVO) throws Exception {
        String sql = "UPDATE tbl_todo set title = ?, dueDate = ?, finished = ? " +
                "where tno = ?";

        System.out.println(sql);

        @Cleanup Connection con = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = con.prepareStatement(sql);

        psmt.setString(1, todoVO.getTitle());
        psmt.setDate(2, Date.valueOf(todoVO.getDueDate()));
        psmt.setBoolean(3, todoVO.isFinished());
        psmt.setLong(4, todoVO.getTno());

        psmt.executeUpdate();
    }

}
