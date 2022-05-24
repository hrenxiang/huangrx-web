package servlet;

import bean.*;
import com.google.gson.Gson;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.beanUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Charon
 * @date 2020/7/16
 **/
@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("addItem被调用");

        int id = beanUtil.ParseInt(request.getParameter("id"), 0);

        Book book = bookService.queryBook(id);

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());

        cart.addItem(cartItem);

        request.getSession().setAttribute("lastName", cartItem.getName());


        //response.sendRedirect(request.getHeader("Referer"));

        Map<String, Object> map = new HashMap<>();
        map.put("TotalCount", cart.getTotalCount());
        map.put("LastName", cartItem.getName());

        Gson gson = new Gson();
        String data = gson.toJson(map);
        //System.out.println(data);

        response.getWriter().write(data);

    }

    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = beanUtil.ParseInt(request.getParameter("id"), 0);

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart != null) {
            cart.deleteItem(id);
        }
        response.sendRedirect(request.getHeader("Referer"));

    }

    protected void updateItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = beanUtil.ParseInt(request.getParameter("id"), 0);

        Book book = bookService.queryBook(id);

        int stock = book.getStock();

        int count = beanUtil.ParseInt(request.getParameter("count"), 1);

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart != null) {
            cart.updateCount(id, count);
        }
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart != null) {
            cart.clear();
        }
        response.sendRedirect(request.getHeader("Referer"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
