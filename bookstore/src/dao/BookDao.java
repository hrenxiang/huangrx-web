package dao;

import bean.Book;

import java.util.List;

/**
 * @author Charon
 * @date 2020/7/10
 **/
public interface BookDao {

    /**
     * 添加图书
     *
     * @param book 图书
     * @return 影响数量
     */
    public int addBook(Book book);

    /**
     * 修改图书
     *
     * @param book 图书
     * @return 影响数量
     */
    public int updateBook(Book book);

    /**
     * 删除图书
     *
     * @param id 图书ID
     * @return 影响数量
     */
    public int deleteBook(Integer id);

    /**
     * 通过ID查找图书
     *
     * @param id 图书ID
     * @return 图书
     */
    public Book queryById(Integer id);

    /**
     * 查询所有图书
     *
     * @return 图书集合
     */
    public List<Book> queryList();

    /**
     * 查询图书总数
     *
     * @return
     */
    public Integer queryCount();

    /**
     * 查询当前页的数据
     *
     * @param begin    开始索引
     * @param pagesize 页面数据条数
     * @return
     */
    public List<Book> queryCurrentPage(int begin, int pagesize);

    public Integer queryPriceCount(int min, int max);

    public List<Book> queryCurrentPricePage(int begin, int pageSize,int min, int max);
}
