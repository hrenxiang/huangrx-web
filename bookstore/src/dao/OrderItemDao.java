package dao;

import bean.OrderItem;

/**
 * @author Charon
 * @date 2020/7/20
 **/
public interface OrderItemDao {

    /**
     * 保存订单项（生成订单项）
     *
     * @param orderItem 订单项
     */
    public int saveOrderItem(OrderItem orderItem);

}
