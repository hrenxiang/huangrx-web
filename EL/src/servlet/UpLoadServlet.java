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
import java.util.List;

/**
 * @author Charon
 * @date 2020/7/6
 **/
public class UpLoadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        //System.out.println(request.getCharacterEncoding());
        //1.判断是否是多段数据
        if (ServletFileUpload.isMultipartContent(request)) {
            //2.创建用于解析上传数据的工具类 ServletFileUpload 类
            // 创建 FileItemFactory 工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            //4.解析上传的数据，得到每一个表单项 FileItem
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                for (FileItem fileItem : list) {
                    //5.判断是否为普通表单项
                    if (fileItem.isFormField()) {
                        //是普通表单项
                        System.out.println("name属性值：" + fileItem.getFieldName());
                        System.out.println("传入的数据：" + fileItem.getString("utf-8"));
                    } else {
                        //是文件fileName = URLDecoder.decode(fileDetail.getFileName(), "UTF-8");
                        System.out.println("文件上传项name属性值：" + fileItem.getFieldName());
                        System.out.println("上传的文件名：" + fileItem.getName());

                        //6.把文件保存到要保存的位置StandardCharsets.UTF_8 can be used instead
                        fileItem.write(new File("e://" + fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
