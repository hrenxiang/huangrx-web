package jsp_01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Charon
 * @date 2020/7/3
 **/
public class PrintJspServlet_01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //org.apache.jasper.runtime.HttpJspBase a;

        response.setContentType("text/html;Charset=utf-8");

        PrintWriter writer = response.getWriter();
        writer.write("<!DOCTYPE html>\r\n" +
                        "<html lang=\"en\">\r\n" +
                        "<head>\r\n" +
                        "    <meta charset=\"UTF-8\">\r\n" +
                        "    <title>a</title>\r\n" +
                        "</head>\r\n" +
                        "<body>\r\n" +
                        "    这是一个HTML页面\r\n" +
                        "    123\r\n"+
                        "    12.12\r\n"+
                        "</body>\r\n" +
                        "</html>");
    }
}
