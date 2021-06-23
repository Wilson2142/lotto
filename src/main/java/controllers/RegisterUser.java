package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/register")
public class RegisterUser {

    private UserDao dao;
    @Autowired
    public RegisterUser(UserDao dao) {
        this.dao = dao;
    }

    @GetMapping
    public String registerPage() {
        return "register";
    }

    @PostMapping
    public String registerUser(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        String email = req.getParameter("emailReg");
        //Check if any user is already registered with the received email address
        if (dao.findUserByEmail(email) == null) {
            User user = new User(
                    req.getParameter("email"),
                    req.getParameter("name"),
                    req.getParameter("password"));
            dao.save(user);

            session.setAttribute("user", user);
            session.setAttribute("errorMsg", "");

            return "redirect:/index.html";
        } else {
            session.setAttribute("errorMsg", "There is a user with the same e-mail address!");
            return "redirect:/register";
        }
    }
}
