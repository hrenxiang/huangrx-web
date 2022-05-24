package test;

import bean.Cart;
import bean.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Charon
 * @date 2020/7/16
 **/
public class CartTest {

    private final Cart cart = new Cart();

    @Test
    public void addItem() {

        cart.addItem(new CartItem(1,"HH",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"HH",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"ww",1,new BigDecimal(100),new BigDecimal(100)));

        System.out.println(cart);

    }

    @Test
    public void deleteItem() {

        cart.addItem(new CartItem(1,"HH",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"HH",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"ww",1,new BigDecimal(100),new BigDecimal(100)));

        cart.deleteItem(2);
        System.out.println(cart);
    }

    @Test
    public void updateCount() {

        cart.addItem(new CartItem(1,"HH",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"HH",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"ww",1,new BigDecimal(100),new BigDecimal(100)));

        cart.updateCount(2,3);
        System.out.println(cart);
    }

    @Test
    public void clear() {

        cart.addItem(new CartItem(1,"HH",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"HH",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"ww",1,new BigDecimal(100),new BigDecimal(100)));

        cart.clear();
        System.out.println(cart);

    }
}