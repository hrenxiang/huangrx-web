package jsp_01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Charon
 * @date 2020/7/4
 **/
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf8");
        response.setContentType("utf8");

        List<Student> students =new ArrayList<Student>();

        for (int i = 1; i < 10; i++) {

            students.add(new Student(i,"翔翔"+i,20+i,"1523485698"+i));
        }

        request.setAttribute("students",students);
        request.getRequestDispatcher("/example_2.jsp").forward(request,response);
    }
}
