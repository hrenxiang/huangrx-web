package servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @author Charon
 * @date 2020/7/7
 **/
public class DownloadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取要下载的文件名
        String downloadfilename="按钮.jpg";

        //2.读取要下载的文件内容(通过servletContext对象获取)
        //ServletContext servletContext = getServletContext();
        ServletContext servletContext = getServletConfig().getServletContext();
        //以流的方式获取文件内容
        InputStream resourceAsStream = servletContext.getResourceAsStream("/img/" + downloadfilename);

        //3.再回传前，通过响应头告诉客户端返回的数据类型
        String mimeType = servletContext.getMimeType("/img/" + downloadfilename);
        //System.out.println(mimeType);
        response.setContentType(mimeType);

        //4.还要告诉客户端收到的数据是用于下载使用（通过响应头设置）
        response.setHeader("Content-Disposition", "attachment; fileName="+ URLEncoder.encode("按钮.jpg","utf8"));

        //5.把要下载的文件回传给客户端(通过输出流进行输出)
        ServletOutputStream outputStream = response.getOutputStream();
        //用commons-io-1.4.jar包中封装好的工具类进行复制输出
        IOUtils.copy(resourceAsStream, outputStream);
    }

}
