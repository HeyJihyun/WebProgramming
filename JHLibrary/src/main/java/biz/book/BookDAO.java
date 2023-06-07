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

    // 도서등록
    public int insertBook(BookVO book) {
        int result = 0;
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

            result = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return result;
    }

    public List<BookVO> getBookList() {

        List<BookVO> bookList = new ArrayList<BookVO>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ISBN, TITLE, AUTHOR, PUBDATE, ");
        sql.append("       REGDATE, COVER, CATEGORY_NAME, ");
        sql.append("       PUBLISHER, ITEMPAGE, DESCRIPTION, ");
        sql.append("       SUM(R_COUNT) AS R_TOTAL, ");
        sql.append("       COUNT(ISBN)  AS COUNT, ");
        sql.append("       SUM(CASE WHEN B_STATUS = '가능' THEN 1 ELSE 0 END) AS ABLE_COUNT ");
        sql.append("  FROM T_BOOK ");
        sql.append(" GROUP BY ISBN, TITLE, AUTHOR, PUBDATE, ");
        sql.append("          REGDATE, COVER, CATEGORY_NAME, ");
        sql.append("          PUBLISHER, ITEMPAGE, DESCRIPTION");

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            rs = stmt.executeQuery();

            while (rs.next()) {
                BookManagemnetVO book = new BookManagemnetVO();
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
                book.setR_count(rs.getInt("R_TOTAL"));
                book.setCount(rs.getInt("COUNT"));
                book.setAbleRantalCnt(rs.getInt("ABLE_COUNT"));

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
