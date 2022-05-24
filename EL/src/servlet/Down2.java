package servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
public class Down2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取文件名
        String downloadfilename = "hun.jpg";
        //2.获取文件内容（serveltcontext对象调用方法以流的方式获取内容）
        ServletContext servletContext = getServletContext();
        InputStream resourceAsStream = servletContext.getResourceAsStream("/img/" + downloadfilename);
        //3.告诉客户端返回的数据类型，还要告诉客户端这是用于下载的
        String mimeType = servletContext.getMimeType("/img/" + downloadfilename);
        response.setContentType(mimeType);
        response.setHeader("content-Disposition","attachment;fileName="+ URLEncoder.encode("中国.jpg","utf8"));
        //4.以jar包工具类中的方法进行输出
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(resourceAsStream,outputStream);


    }
}
