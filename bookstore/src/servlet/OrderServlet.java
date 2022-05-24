package servlet;

import bean.Cart;
import bean.User;
import service.OrderService;
import service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Charon
 * @date 2020/7/20
 **/
@WebServlet(name = "OrderServlet", urlPatterns = "/orderServlet")
public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    protected void creatOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("createOrder被调用");

        /*User user = (User) request.getSession().getAttribute("user");

        if (user != null){*/
            //1.获取购物车对象
            Cart cart = (Cart) request.getSession().getAttribute("cart");

            //2.获取userId
            User loginUser = (User) request.getSession().getAttribute("user");
            Integer id = loginUser.getId();

            //3.调用service方法，创建新订单
            String orderId = orderService.createOrder(cart, id);

            if (orderId != null) {
                //4.把orderId储存到request域中，方便结账成功后的显示页面调用  ---  改用重定向后无法再从request域中得到数据
                //request.setAttribute("orderId",orderId);

                //5.请求转发到成功页面  ----  建议用重定向，刷新页面会赵成重复提交
                //request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request,response);

                //6.1 将其orderId保存在session域中
                request.getSession().setAttribute("orderId", orderId);

                //6.2.改用重定向，消除影响
                response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
            }

      /*  }else {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }*/



    }

}
