package service;

import bean.Book;
import bean.Page;

import java.util.List;

/**
 * @author Charon
 * @date 2020/7/10
 **/
public interface BookService {

    public void addBook(Book book);

    public void deleteBook(Integer id);

    public void updateBook(Book book);

    public Book queryBook(Integer id);

    public List<Book> queryBooks();

    public Page<Book> paging(int pageNum, int pageSize);

    public Page<Book> pricePage(int pageNum, int pageSize, int min, int max);
}
