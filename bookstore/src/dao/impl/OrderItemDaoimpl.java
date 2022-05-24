package dao.impl;

import bean.OrderItem;
import dao.OrderItemDao;

/**
 * @author Charon
 * @date 2020/7/20
 **/
public class OrderItemDaoimpl extends BaseDao implements OrderItemDao {

    /**
     * 调用操作数据库的方法，生成订单项（保存订单项）
     * @param orderItem 订单项
     * @return
     */
    @Override
    public int saveOrderItem(OrderItem orderItem) {

        String sql = "insert into t_order_item values(?,?,?,?,?,?)";
        return update(sql,orderItem.getId(), orderItem.getName(),orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
