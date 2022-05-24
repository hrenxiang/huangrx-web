package test;

import bean.Book;
import bean.Page;
import org.junit.Test;
import service.BookService;
import service.impl.BookServiceImpl;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Charon
 * @date 2020/7/10
 **/
public class BookServiceImplTest {

    BookService bookService=new BookServiceImpl();

    @Test
    public void addBook() {
        Book book = new Book(null,"小王子","黄某人",new BigDecimal("34.5"),360,56,null);
        bookService.addBook(book);
    }

    @Test
    public void deleteBook() {
        Integer id = 20;
        bookService.deleteBook(id);
    }

    @Test
    public void updateBook() {
        Book book = new Book(20,"乾坤无极","黄某人",new BigDecimal("9999"),360,56,null);

        bookService.updateBook(book);
    }

    @Test
    public void queryBook() {
        Integer id = 18;
        Book book = bookService.queryBook(id);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void paging(){

        Page<Book> page = bookService.paging(1, 4);

        System.out.println(page);
    }
}