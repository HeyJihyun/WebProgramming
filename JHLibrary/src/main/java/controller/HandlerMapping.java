package controller;

import java.util.HashMap;
import java.util.Map;

import controller.book.DeleteBookController;
import controller.book.GetBookListController;
import controller.book.InputBookController;
import controller.book.InsertBookController;
import controller.book.SearchBookController;
import controller.book.UpdateBookController;
import controller.book.UpdateBookPageController;
import controller.user.IdCheckController;
import controller.user.InsertUserController;
import controller.user.InsertUserPageController;
import controller.user.LoginController;
import controller.user.LoginOutController;
import controller.user.LoginProcessController;

public class HandlerMapping {

    private Map<String, Controller> mappings;

    public HandlerMapping() {
        mappings = new HashMap<String, Controller>();
        mappings.put("/main.do", new MainController());
        mappings.put("/login.do", new LoginController());
        mappings.put("/loginProcess.do", new LoginProcessController());
        mappings.put("/logout.do", new LoginOutController());
        mappings.put("/insertUserPage.do", new InsertUserPageController());
        mappings.put("/insertUser.do", new InsertUserController());
        mappings.put("/idCheck.do", new IdCheckController());
        mappings.put("/inputBook.do", new InputBookController());
        mappings.put("/insertBook.do", new InsertBookController());
        mappings.put("/getBookList.do", new GetBookListController());
        mappings.put("/searchBook.do", new SearchBookController());
        mappings.put("/updateBookPage.do", new UpdateBookPageController());
        mappings.put("/deleteBook.do", new DeleteBookController());
        mappings.put("/updateBook.do", new UpdateBookController());
    }

    public Controller getController(String path) {
        return mappings.get(path);
    }

}
