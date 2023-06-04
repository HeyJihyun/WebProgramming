package controller.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import biz.book.BookVO;
import biz.book.ResultBookVO;
import controller.Controller;

public class InputBookController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String isbn = request.getParameter("isbn");
//        String isbn = "9791168473690";
        System.out.println(isbn);
        String apiURL = "http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?ttbkey=ttbgihyun6580155001&itemIdType=ISBN13&ItemId="
                + isbn + "&output=js&Cover=Big"; // JSON
                                                 // 결과

        String responseBody = get(apiURL);

        responseBody = responseBody.replaceAll(",", ", \n");
        System.out.println(responseBody);

        Gson gson = new GsonBuilder().setLenient().create();
        JsonReader reader = new JsonReader(new StringReader(responseBody));
        reader.setLenient(true);
        ResultBookVO resultMap = gson.fromJson(reader, ResultBookVO.class);

        if (resultMap.getErrorCode() != 0) {
            request.setAttribute("error", resultMap.getErrorMessage());
        } else {
            BookVO[] items = resultMap.getItem();
            if (items[0].getBookinfo() != null) {
                items[0].setItemPage(items[0].getBookinfo().getItemPage());
            }
            request.setAttribute("bookInfo", items[0]);
        }

        return "/jsp/book/insertBook.jsp";
    }

    private static String get(String apiUrl) {
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 오류 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body);
        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();
            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line).append("\n");
            }
            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
        }
    }
}
