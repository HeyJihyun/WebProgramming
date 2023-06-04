package biz.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
