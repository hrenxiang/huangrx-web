package test;

import bean.Book;
import bean.Page;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import org.junit.Test;
import service.BookService;
import service.impl.BookServiceImpl;

import static org.junit.Assert.*;

/**
 * @author Charon
 * @date 2020/7/13
 **/
public class BookServiceImplTest2 {

    @Test
    public void pricePage() {

        BookService bookService = new BookServiceImpl();

        Page<Book> page = bookService.pricePage(1, 4, 300, 20000);
        System.out.println(page);

    }
}