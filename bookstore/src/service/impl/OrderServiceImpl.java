package service.impl;

import bean.*;
import dao.BookDao;
import dao.OrderDao;
import dao.OrderItemDao;
import dao.impl.BookDaoImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderItemDaoimpl;
import service.OrderService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @author Charon
 * @date 2020/7/20
 **/
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao = new OrderDaoImpl();
    private final OrderItemDao orderItemDao = new OrderItemDaoimpl();
    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {

        String orderId = System.currentTimeMillis() + "" + userId;

        Order order = new Order(orderId, new Date(), new BigDecimal(String.valueOf(cart.getTotalPrice())), userId);

        orderDao.saveOrder(order);

        Map<Integer, CartItem> items = cart.getItems();
        Set<Map.Entry<Integer, CartItem>> itemEntry = items.entrySet();
        for (Map.Entry<Integer, CartItem> item : itemEntry) {
            CartItem cartItem = item.getValue();

            Book book = bookDao.queryById(cartItem.getId());
            if (book.getStock() >= cartItem.getCount()) {
                OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), order.getOrderId());
                orderItemDao.saveOrderItem(orderItem);
                book.setSales(book.getSales() + cartItem.getCount());
                book.setStock(book.getStock() - cartItem.getCount());
                bookDao.updateBook(book);
                return orderId;
            }else {
                throw new RuntimeException(new Exception());
            }

        }
        return null;
    }
}
