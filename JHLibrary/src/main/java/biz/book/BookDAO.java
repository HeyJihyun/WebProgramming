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

    // 도서검색
    public List<BookVO> getBookList(String search_item, String search_txt) {

        List<BookVO> bookList = new ArrayList<BookVO>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ISBN, TITLE, AUTHOR, PUBDATE, ");
        sql.append("       REGDATE, COVER, CATEGORY_NAME, ");
        sql.append("       PUBLISHER, ITEMPAGE, DESCRIPTION, ");
        sql.append("       SUM(R_COUNT) AS R_TOTAL, ");
        sql.append("       COUNT(ISBN)  AS COUNT, ");
        sql.append("       SUM(CASE WHEN B_STATUS = '가능' THEN 1 ELSE 0 END) AS ABLE_COUNT ");
        sql.append("  FROM T_BOOK ");
        sql.append(" WHERE INSTR(UPPER(" + search_item + "), UPPER(?)) > 0");
        sql.append(" GROUP BY ISBN, TITLE, AUTHOR, PUBDATE, ");
        sql.append("          REGDATE, COVER, CATEGORY_NAME, ");
        sql.append("          PUBLISHER, ITEMPAGE, DESCRIPTION");
        sql.append(" ORDER BY TITLE");

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, search_txt);
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
        sql.append(" ORDER BY TITLE");
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

    public List<BookVO> getBook(String isbn) {
        List<BookVO> bookList = new ArrayList<BookVO>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM T_BOOK WHERE ISBN = ? ORDER BY B_NO");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, isbn);
            rs = stmt.executeQuery();

            while (rs.next()) {
                BookVO book = new BookVO();
                book.setB_no(rs.getInt("b_no"));
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
                book.setR_count(rs.getInt("R_COUNT"));
                book.setB_status(rs.getString("B_STATUS"));

                bookList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return bookList;
    }

    // 도서삭제
    public int deleteBook(int b_no) {
        int result = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM T_BOOK WHERE B_NO = ?");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setInt(1, b_no);
            result = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return result;
    }

    // 도서상태 수정
    public int updateBook(int b_no, String b_status) {
        int result = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE T_BOOK SET B_STATUS = ? WHERE B_NO = ?");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, b_status);
            stmt.setInt(2, b_no);
            result = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return result;
    }

}
