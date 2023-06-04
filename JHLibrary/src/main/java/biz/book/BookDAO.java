package biz.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import biz.common.JDBCUtil;

public class BookDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public void insertBook(BookVO book) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO T_BOOK (");
        sql.append("       B_NO,");
        sql.append("       ISBN,");
        sql.append("       TITLE,");
        sql.append("       AUTHOR,");
        sql.append("       PUBDATE,");
        sql.append("       COVER,");
        sql.append("       CATEGORY_NAME,");
        sql.append("       PUBLISHER,");
        sql.append("       ITEMPAGE,");
        sql.append("       DESCRIPTION");
        sql.append(") VALUES (SEQ_T_BOOK_NO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, book.getIsbn13());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setString(4, book.getPubDate());
            stmt.setString(5, book.getCover());
            stmt.setString(6, book.getCategoryName());
            stmt.setString(7, book.getPublisher());
            stmt.setInt(8, book.getItemPage());
            stmt.setString(9, book.getDescription());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
    }

    public List<BookVO> getBookList() {

        List<BookVO> bookList = new ArrayList<BookVO>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM T_BOOK ORDER BY B_NO DESC");

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            rs = stmt.executeQuery();

            while (rs.next()) {
                BookVO book = new BookVO();
                book.setB_no(rs.getInt("B_NO"));
                book.setIsbn13(rs.getString("ISBN"));
                book.setTitle(rs.getString("TITLE"));
                book.setAuthor(rs.getString("AUTHOR"));
                book.setPubDate(rs.getString("PUBDATE"));
                book.setRegDate(rs.getString("REGDATE"));
                book.setCover(rs.getString("COVER"));
                book.setCategoryName(rs.getString("CATEGORY_NAME"));
                book.setPublisher(rs.getString("PUBLISHER"));
                book.setItemPage(rs.getInt("ITEMPAGE"));
                book.setDescription(rs.getString("DESCRIPTION"));
                book.setB_status(rs.getString("B_STATUS"));
                book.setR_count(rs.getInt("R_COUNT"));

                bookList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return bookList;
    }
}
