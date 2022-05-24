package servlet;

import bean.Book;
import bean.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.beanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author Charon
 * @date 2020/7/11
 **/
@WebServlet(name = "BookServlet", urlPatterns = "/manager/bookServlet")
public class BookServlet extends BaseServlet {

    private final BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Book book = beanUtil.copyParaToBean(request.getParameterMap(), new Book());
        //System.out.println(book);
        bookService.addBook(book);

        int num = beanUtil.ParseInt(request.getParameter("pageNum") + 1, 1);

        //不可以使用请求转发，因为此功能，添加图书后跳转到了图书列表页面，如果用一次请求来做，在图书列表刷新浏览器，添加操作会重复进行
        //但若用重定向，添加图书试一次请求，跳转到图书列表页面又是一次请求，这样就避免了添加图书是request域中的数据调用
        //request.getRequestDispatcher("manager/bookServlet?action=queryList").forward(request,response);
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNum=" + num);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.点击删除，获取相应数据id (在beanUtil工具类中，写入数值类型转换方法，方便代码书写（一个项目中，可能要做很多次同类型的转换，所以直接写在工具类中调用）)
        int id = beanUtil.ParseInt(request.getParameter("id"), 0);

        //2.执行删除函数
        bookService.deleteBook(id);

        //3.删除完成进行重定向，返回图书列表
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNum=" + request.getParameter("pageNum"));

    }

    protected void getUpdateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取id
        int id = beanUtil.ParseInt(request.getParameter("id"), 0);

        //查询相关图书信息
        Book book = bookService.queryBook(id);

        //保存到request域中
        request.setAttribute("book", book);

        //回显到图书修改页面
        request.getRequestDispatcher("/pages/manager/book_edit.jsp?&pageNum=" + request.getParameter("pageNum")).forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.把请求参数封装为javaBean对象
        Book book = beanUtil.copyParaToBean(request.getParameterMap(), new Book());

        //2.调用方法执行修改
        bookService.updateBook(book);

        //3.修改完成，重定向返回图书列表
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNum=" + request.getParameter("pageNum"));
    }

    protected void queryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Book> books = bookService.queryBooks();

        request.setAttribute("books", books);

        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);

    }

    /**
     * 分页
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageNum = beanUtil.ParseInt(request.getParameter("pageNum"), 1);

        int pageSize = beanUtil.ParseInt(request.getParameter("pageSize"), 4);

        Page<Book> page = bookService.paging(pageNum, pageSize);

        page.setUrl("manager/bookServlet?action=page");

        request.setAttribute("page", page);

        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);

    }
}
