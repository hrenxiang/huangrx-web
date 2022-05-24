package test;

import bean.Book;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author Charon
 * @date 2020/7/10
 **/
public class BookDaoImplTest {

    BookDao bookDao=new BookDaoImpl();

    @Test
    public void addBook() {
        Book book=new Book(null,"小王子","黄某人",new BigDecimal("34.5"),360,56,null);
        bookDao.addBook(book);
    }

    @Test
    public void updateBook() {
        Book book = new Book(20,"乾坤无极","黄某人",new BigDecimal("9999"),360,56,null);
        bookDao.updateBook(book);
    }

    @Test
    public void deleteBook() {
        int id = 19;
        bookDao.deleteBook(id);
    }

    @Test
    public void queryById() {
        int id = 18;
        Book book = bookDao.queryById(id);
        System.out.println(book);
    }

    @Test
    public void queryList() {
        List<Book> books = bookDao.queryList();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}