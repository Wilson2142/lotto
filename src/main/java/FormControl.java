import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class FormControl {

    @PostMapping("/formController")
    public void processFormData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        int[] numbers = null;

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
//        out.println("<html>" + "<body>" + "<p>számaid: "
    }
    }
