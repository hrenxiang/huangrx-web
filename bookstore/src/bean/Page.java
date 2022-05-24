package bean;

import java.util.List;

/**
 * @author Charon
 * @date 2020/7/12
 **/
public class Page<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer pageNumTotal;
    private Integer recodeTotal;
    private List<T> currentData;

    private String url;

    public Page() {
    }

    public Page(Integer pageNum, Integer pageSize, Integer pageNumTotal, Integer recodeTotal, List<T> currentData) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pageNumTotal = pageNumTotal;
        this.recodeTotal = recodeTotal;
        this.currentData = currentData;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumTotal() {
        return pageNumTotal;
    }

    public void setPageNumTotal(Integer pageNumTotal) {
        this.pageNumTotal = pageNumTotal;
    }

    public Integer getRecodeTotal() {
        return recodeTotal;
    }

    public void setRecodeTotal(Integer recodeTotal) {
        this.recodeTotal = recodeTotal;
    }

    public List<T> getCurrentData() {
        return currentData;
    }

    public void setCurrentData(List<T> currentData) {
        this.currentData = currentData;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", pageNumTotal=" + pageNumTotal +
                ", recodeTotal=" + recodeTotal +
                ", currentData=" + currentData +
                '}';
    }
}
