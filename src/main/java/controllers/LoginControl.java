package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class LoginControl {
    private UserDao dao;

    @Autowired
    public LoginControl(UserDao dao) {
        this.dao = dao;
    }

    @PostMapping("/loginControl")
    public void processFormData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (dao.findUserByEmail(request.getParameter("email")) != null) {
        }

    }

}
