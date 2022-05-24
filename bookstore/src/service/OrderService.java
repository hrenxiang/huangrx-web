package service;

import bean.Cart;
import bean.Order;

/**
 * @author Charon
 * @date 2020/7/20
 **/
public interface OrderService {

    /**
     * 由购物车和用户id生成用户的订单项
     * @param cart
     * @param userId
     * @return
     */
    public String createOrder(Cart cart, Integer userId);
}
