package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * @author Charon
 * @date 2020/7/6
 **/
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1 先判断上传的数据是否多段数据（只有是多段的数据，才是文件上传的）
        if (ServletFileUpload.isMultipartContent(request)){

            // 创建 FileItemFactory 工厂实现类
            FileItemFactory fileitemFactory = new DiskFileItemFactory();

            // 创建用于解析上传数据的工具类 ServletFileUpload 类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileitemFactory);
            try {
                // 解析上传的数据，得到每一个表单项 FileItem
                List<FileItem> list = servletFileUpload.parseRequest(request);

                // 循环判断，每一个表单项，是普通类型，还是上传的文件
                for (FileItem item : list) {
                    if (item.isFormField()){
                        System.out.println("表单name属性的值:"+item.getFieldName());
                        System.out.println("表单value属性的值:"+item.getString("utf8"));
                    }else{
                        System.out.println("文件的name属性值:"+ item.getFieldName());
                        System.out.println("文件名:"+item.getName());
                        //System.out.println("表单value属性的值:"+item.getString());

                        item.write(new File("e:\\" + item.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        System.out.println(response.getCharacterEncoding());
        PrintWriter writer = response.getWriter();
        writer.write("黄任翔真尼玛帅!");
    }
}
