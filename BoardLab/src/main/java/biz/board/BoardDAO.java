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

    private static String BOARD_List = "select * from board order by seq desc";

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
            stmt = conn.prepareStatement(BOARD_List);
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
