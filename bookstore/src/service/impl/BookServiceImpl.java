package service.impl;

import bean.Book;
import bean.Page;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import service.BookService;

import java.util.List;

/**
 * @author Charon
 * @date 2020/7/10
 **/
public class BookServiceImpl implements BookService {

    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBook(Integer id) {
        return bookDao.queryById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryList();
    }

    @Override
    public Page<Book> paging(int pageNum, int pageSize) {

        Page<Book> page =new Page<Book>();

        //页面数据条数
        page.setPageSize(pageSize);

        //总记录数
        Integer count = bookDao.queryCount();
        page.setRecodeTotal(count);

        //总页数
        int pageNumTotal = count / pageSize;
        if (count % pageSize > 0 ){
            pageNumTotal += 1;
        }
        page.setPageNumTotal(pageNumTotal);

        //当前页码,判断是为了防止页码越界，最小为1，最大为总页码
        if (pageNum<1){
            pageNum=1;
        }else if (pageNum>pageNumTotal){
            pageNum=pageNumTotal;
        }
        page.setPageNum(pageNum);

        //当前页数据
        int begin = (pageNum-1)*pageSize;
        List<Book> books = bookDao.queryCurrentPage(begin, pageSize);
        page.setCurrentData(books);
        return page;
    }

    @Override
    public Page<Book> pricePage(int pageNum, int pageSize, int min, int max) {

        Page<Book> page =new Page<Book>();

        //页面数据条数
        page.setPageSize(pageSize);

        //总记录数
        Integer count = bookDao.queryPriceCount(min , max);
        page.setRecodeTotal(count);

        //总页数
        int pageNumTotal = count / pageSize;
        if (count % pageSize > 0 ){
            pageNumTotal += 1;
        }
        page.setPageNumTotal(pageNumTotal);

        //当前页码,判断是为了防止页码越界，最小为1，最大为总页码
        if (pageNum<1){
            pageNum=1;
        }else if (pageNum>pageNumTotal){
            pageNum=pageNumTotal;
        }
        page.setPageNum(pageNum);

        //当前页数据
        int begin = (pageNum-1)*pageSize;
        List<Book> books = bookDao.queryCurrentPricePage(begin,pageSize,min, max);
        page.setCurrentData(books);
        return page;
    }

}
