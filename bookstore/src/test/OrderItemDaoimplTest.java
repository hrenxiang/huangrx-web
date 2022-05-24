package test;

import bean.OrderItem;
import com.alibaba.druid.sql.dialect.sqlserver.ast.SQLServerOutput;
import dao.OrderItemDao;
import dao.impl.OrderItemDaoimpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Charon
 * @date 2020/7/20
 **/
public class OrderItemDaoimplTest {

    @Test
    public void saveOrderItem() {

        OrderItemDao orderItemDao=new OrderItemDaoimpl();

        OrderItem orderItem = new OrderItem(1,"java从入门到放弃",1,new BigDecimal(80),new BigDecimal(80),"1234567");

        int i = orderItemDao.saveOrderItem(orderItem);
        System.out.println(i);

    }
}