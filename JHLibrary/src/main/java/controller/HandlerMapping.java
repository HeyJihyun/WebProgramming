package controller;

import java.util.HashMap;
import java.util.Map;

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
    }

    public Controller getController(String path) {
        return mappings.get(path);
    }

}
