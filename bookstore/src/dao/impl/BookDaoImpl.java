package dao.impl;

import bean.Book;
import dao.BookDao;

import java.util.List;

/**
 * @author Charon
 * @date 2020/7/10
 **/
public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book( name , author ,price ,sales ,stock,img_path) values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path());
    }

    @Override
    public int updateBook(Book book) {
        String sql="update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    @Override
    public int deleteBook(Integer id) {
        String sql ="delete from t_book where id=?";
        return update(sql,id);
    }

    @Override
    public Book queryById(Integer id) {
        String sql = "select * from t_book where id=?";
        return queryOne(sql,Book.class,id);
    }

    @Override
    public List<Book> queryList() {
        String sql = " select * from t_book ";
        return queryList(sql,Book.class);
    }

    @Override
    public Integer queryCount() {
        String sql="select count(*) from t_book";
        //Number 这个类很少用，他是个抽象bai类，继du承了Object类，实现了Serializable<>接口。
        //Number的子类是提供数据类型转换方法的，如dao：Byte、Short、Integer,Long、Float 和 Double 等
        Number count = (Number) queryFunction(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryCurrentPage(int begin, int pagesize) {
        String sql ="select * from t_book limit ?,?";
        return queryList(sql,Book.class,begin,pagesize);
    }

    @Override
    public Integer queryPriceCount(int min, int max) {
        String sql="select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryFunction(sql,min ,max);
        return count.intValue();
    }

    @Override
    public List<Book> queryCurrentPricePage(int begin, int pageSize, int min, int max) {
        String sql="select * from t_book where price between ? and ? order by price limit ?,?";
        return queryList(sql,Book.class,min,max,begin,pageSize);
    }
}
