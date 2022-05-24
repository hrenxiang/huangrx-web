package test;

import bean.Order;
import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import javafx.scene.input.DataFormat;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Charon
 * @date 2020/7/20
 **/
public class OrderDaoImplTest {

    @Test
    public void saveOrder() {

        OrderDao orderDao = new OrderDaoImpl();

        Date date = new Date();
        System.out.println(date);

        Order order = new Order("1234567",date,new BigDecimal(78),1);

        int i = orderDao.saveOrder(order);

        System.out.println(i);
    }
}