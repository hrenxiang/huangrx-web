package dao.impl;

import bean.Order;
import dao.OrderDao;

/**
 * @author Charon
 * @date 2020/7/20
 **/
public class OrderDaoImpl extends BaseDao implements OrderDao {


    /**
     * 保存订单（生成订单的SQL语句）
     * @param order 订单
     * @return 影响记录的条数
     */
    @Override
    public int saveOrder(Order order) {

        String sql ="insert into t_order(order_id,create_time,price,status,user_id) values(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());

    }
}
