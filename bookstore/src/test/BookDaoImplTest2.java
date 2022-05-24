package test;

import bean.Book;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Charon
 * @date 2020/7/13
 **/
public class BookDaoImplTest2 {

    @Test
    public void queryPriceCount() {
        BookDao bookDao = new BookDaoImpl();

        int min = 300;
        int max = 20000;

        Integer integer = bookDao.queryPriceCount(min, max);

        System.out.println(integer);
    }

    @Test
    public void queryCurrentPricePage() {
        BookDao bookDao = new BookDaoImpl();

        int min = 300;
        int max = 20000;
        int pageSize=4;
        int begin=0;

        List<Book> books = bookDao.queryCurrentPricePage(begin, pageSize, min, max);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}