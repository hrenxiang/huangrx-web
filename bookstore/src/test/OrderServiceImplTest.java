package test;

import bean.Cart;
import bean.CartItem;
import org.junit.Test;
import service.OrderService;
import service.impl.OrderServiceImpl;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Charon
 * @date 2020/7/20
 **/
public class OrderServiceImplTest {

    @Test
    public void createOrder() {

        OrderService orderService= new OrderServiceImpl();

        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"HH",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"HH",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"ww",1,new BigDecimal(100),new BigDecimal(100)));


        String order = orderService.createOrder(cart, 1);

        System.out.println(order);

    }
}