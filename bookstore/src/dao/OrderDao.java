package dao;

import bean.Order;

/**
 * @author Charon
 * @date 2020/7/20
 **/
public interface OrderDao {

    /**
     * 保存订单（生成订单）
     *
     * @param order 订单
     */
    public int saveOrder(Order order);

}
