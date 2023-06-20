package biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import biz.common.JDBCUtil;

public class BoardDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    // 도서등록
    public int insertBook(BoardVO board) {
        int result = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO BANK_BOARD (");
        sql.append("       TITLE,");
        sql.append("       CONTENT,");
        sql.append("       GROUP_ID,");
        sql.append("       THREAD");
        sql.append(") VALUES (?, ?,(SELECT NVL(MAX(GROUP_ID), 0) + 1 FROM BANK_BOARD), 'a')");

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());

            result = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return result;
    }

    // 전체 문의 게시글 갯수 구하기
    public int getBoardTotal() {
        int result = 0;
        String sql = "select count(*) from bank_board";
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());

            rs = stmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 문의글 전체 보기
    public List<BoardVO> getBoardList(int start) {
        List<BoardVO> boardList = new ArrayList<BoardVO>();
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT *");
        sql.append("  FROM (");
        sql.append("  SELECT m.*, rownum AS rn");
        sql.append("  FROM (");
        sql.append("       SELECT B_NO, TITLE, USER_ID, NAME, HITS, GROUP_ID,");
        sql.append("              TO_CHAR(REG_DATE, 'YYYY-MM-DD') AS REG_DATE, THREAD ");
        sql.append("         FROM BANK_BOARD ORDER BY GROUP_ID DESC, THREAD ASC");
        sql.append("  ) m)");
        sql.append(" WHERE rn BETWEEN ? AND ?");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setInt(1, start);
            stmt.setInt(2, start + 9);

            rs = stmt.executeQuery();

            while (rs.next()) {
                BoardVO board = new BoardVO();
                board.setB_no(rs.getInt("B_NO"));
                board.setTitle(rs.getString("TITLE"));
                board.setUser_id(rs.getString("USER_ID"));
                board.setName(rs.getString("NAME"));
                board.setHits(rs.getInt("HITS"));
                board.setReg_date(rs.getString("REG_DATE"));
                board.setGroup_id(rs.getInt("GROUP_ID"));
                board.setThred(rs.getString("THREAD"));
                boardList.add(board);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return boardList;
    }

    // 문의글 하나보기
    public BoardVO getBoard(int b_no) {
        BoardVO board = null;
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT * FROM BANK_BOARD WHERE B_NO = ?");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setInt(1, b_no);

            rs = stmt.executeQuery();

            if (rs.next()) {
                board = new BoardVO();
                board.setB_no(rs.getInt("B_NO"));
                board.setTitle(rs.getString("TITLE"));
                board.setUser_id(rs.getString("USER_ID"));
                board.setName(rs.getString("NAME"));
                board.setContent(rs.getString("CONTENT"));
                board.setHits(rs.getInt("HITS"));
                board.setReg_date(rs.getString("REG_DATE"));
                board.setGroup_id(rs.getInt("GROUP_ID"));
                board.setThred(rs.getString("THREAD"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return board;
    }

}
