package webserver;


import request.HttpRequest;
import com.google.common.collect.Maps;
import controller.*;
import java.util.Map;

public class HandlerMapper {

    private static final Map<String, Controller> controllers = Maps.newHashMap();
    private static final HandlerMapper HANDLER_MAPPER = new HandlerMapper();
    private static final ForwardController forwardController = new ForwardController();

    private HandlerMapper() {
        init();
    }

    private static void init() {
        final String HOME = "/";
        final String SIGNUP = "/user/create";
        final String LOGIN = "/user/login";
        final String LIST = "/user/list";

        controllers.put(HOME, new HomeController());
        controllers.put(SIGNUP, new SignupController());
        controllers.put(LOGIN, new LoginController());
        controllers.put(LIST, new ListController());
    }

    public static HandlerMapper of() {
        return HANDLER_MAPPER;
    }

    public Controller getController(HttpRequest httpRequest) {
        Controller controller = controllers.get(httpRequest.getUrl());

        if(controller == null) {
            return forwardController;
        }
        return controller;
    }
}
