package controller;

import request.HttpRequest;
import response.HttpResponse;
import response.HttpStatus;
import util.IOUtils;

public class HomeController implements Controller {

    @Override
    public void execute(HttpRequest httpRequest, HttpResponse httpResponse) {
        final String HOME = "/index.html";

        httpResponse.forward(HOME);
    }
}