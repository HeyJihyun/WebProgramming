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

    private static String BOARD_INSERT = "insert into board(seq, title, writer, content) "
            + "values((select nvl(max(seq),0) +1 from board), ?, ?, ?)";

    private static String BOARD_LIST = "select * from board order by seq desc";
    private static String BOARD_GET = "select * from board where seq = ?";
    private static String BOARD_UPDATE = "update board set title=?, content = ?, hit = ? where seq = ?";
    private static String BOARD_DELETE = "delete from board where seq = ?";
//    private static String BOARD_SEARCH = "select * from board where instr(?, ?) > 0";

    public void insertBoard(BoardVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_INSERT);

            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getWriter());
            stmt.setString(3, vo.getContent());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public List<BoardVO> getBoardList() {
        List<BoardVO> boardList = new ArrayList<BoardVO>();

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_LIST);
            rs = stmt.executeQuery();

            while (rs.next()) {
                BoardVO board = new BoardVO();
                board.setSeq(rs.getInt(1));
                board.setTitle(rs.getString(2));
                board.setWriter(rs.getString(3));
                board.setContent(rs.getString(4));
                board.setRegdate(rs.getDate(5));
                board.setHit(rs.getInt(6));
                boardList.add(board);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return boardList;
    }

    public BoardVO getBoard(int seq) {
        BoardVO board = new BoardVO();

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_GET);
            stmt.setInt(1, seq);
            rs = stmt.executeQuery();

            if (rs.next()) {
                board.setSeq(rs.getInt(1));
                board.setTitle(rs.getString(2));
                board.setWriter(rs.getString(3));
                board.setContent(rs.getString(4));
                board.setRegdate(rs.getDate(5));
                board.setHit(rs.getInt(6) + 1);
                updateBoard(board);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return board;
    }

    public void updateBoard(BoardVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_UPDATE);
            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getContent());
            stmt.setInt(3, vo.getHit());
            stmt.setInt(4, vo.getSeq());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public void deleteBoard(BoardVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_DELETE);
            stmt.setInt(1, vo.getSeq());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public List<BoardVO> searchBoard(String search, String content) {
        List<BoardVO> boardList = new ArrayList<BoardVO>();
        String sql = "select * from board where instr(" + search + ", ?) > 0";
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, content);
            rs = stmt.executeQuery();

            while (rs.next()) {
                BoardVO board = new BoardVO();
                board.setSeq(rs.getInt(1));
                board.setTitle(rs.getString(2));
                board.setWriter(rs.getString(3));
                board.setContent(rs.getString(4));
                board.setRegdate(rs.getDate(5));
                boardList.add(board);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return boardList;
    }
}
