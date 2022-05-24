package servlet;

import bean.Book;
import bean.Page;
import com.sun.media.sound.ModelChannelMixer;
import dao.impl.BaseDao;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.beanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author Charon
 * @date 2020/7/13
 **/
@WebServlet(name = "ClientBookServlet",urlPatterns = "/client/bookServlet")
public class ClientBookServlet extends BaseServlet {

    private final BookService bookService=new BookServiceImpl();

    /**
     * 分页
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageNum = beanUtil.ParseInt(request.getParameter("pageNum"), 1);
        String pageSize1 = request.getParameter("pageSize");

        int pageSize = beanUtil.ParseInt(request.getParameter("pageSize"), 4);

        Page<Book> page = bookService.paging(pageNum, pageSize);

        page.setUrl("client/bookServlet?action=page");

        request.setAttribute("page",page);

        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);

    }

    protected void pricePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf8");

        int pageNum = beanUtil.ParseInt(request.getParameter("pageNum"), 1);
        String pageSize1 = request.getParameter("pageSize");

        int pageSize = beanUtil.ParseInt(request.getParameter("pageSize"), 4);

        int min = beanUtil.ParseInt(request.getParameter("min"), 0);

        int max = beanUtil.ParseInt(request.getParameter("max"), 100000000);

        Page<Book> page = bookService.pricePage(pageNum, pageSize,min,max);

        page.setUrl("client/bookServlet?action=pricePage&min="+ min+"&max="+max);

        request.setAttribute("page",page);

        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);

    }

}
