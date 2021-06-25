package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Controller
public class RegisterUser {

    private UserDao dao;
    @Autowired
    public RegisterUser(UserDao dao) {
        this.dao = dao;
    }

    @PostMapping("/register")
    public String registerUser(HttpServletRequest req, HttpServletResponse resp) {

        HttpSession session = req.getSession();
        String email = req.getParameter("emailReg");
        if (dao.findUserByEmail(email) == null) {
            User user = new User(
                    req.getParameter("email"),
                    req.getParameter("name"),
                    req.getParameter("password"));
            dao.save(user);
        } else {
            session.setAttribute("errorMsg", "There is a user with the same e-mail address!");
        }
        return "redirect:/index.html";
    }
}
