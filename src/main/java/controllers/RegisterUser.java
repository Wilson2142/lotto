package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterUser {

    @Controller
    @RequestMapping("/register")

    private Dao dao;

    public RegisterUser(Dao dao) {
        this.dao = dao;
    }

    @GetMapping
    public String registerPage() {
        return "register";
    }

    @PostMapping
    public String registerUser(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        if (dao.findUserByEmail(email) == null) {
            User user = new User(
                    req.getParameter("name"),
                    req.getParameter("email"),
                    req.getParameter("password"),
                    req.getParameter("repassword"),
            userJpaDao.save(user);

            session.setAttribute("user", user);
            session.setAttribute("errorMsg", "");

    }
}
