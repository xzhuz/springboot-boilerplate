package fun.baozi.core.domain.page;


import javax.annotation.Nonnull;
import java.util.List;

/**
 * Global page query response
 * @author baozi
 * 2020-07-14
 */
public class PageResult<T> {

    /**
     * Response data
     */
    private List<T> data;

    /**
     * Number of query data
     */
    private Long count;

    /**
     * Current page number
     */
    private Integer pageNum;

    /**
     * Size of data per page
     */
    private Integer pageSize;

    /**
     * Default constructor
     */
    public PageResult() {
    }

    public PageResult(List<T> data, Long count, Integer pageNum, Integer pageSize) {
        this.data = data;
        this.count = count;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public PageResult(List<T> data, Long count, @Nonnull PageInfo pageInfo) {
        this.data = data;
        this.count = count;
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
    }

    public PageResult(@Nonnull PageBean<T> pageBean, @Nonnull PageInfo pageInfo) {
        this.data = pageBean.getData();
        this.count = pageBean.getCount();
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
    }

    public static <T> PageResult<T> success(List<T> data, Long count, @Nonnull PageInfo pageInfo) {
        return new PageResult<>(data, count, pageInfo);
    }

    public static <T> PageResult<T> success(List<T> data, Long count, Integer pageNum, Integer pageSize) {
        return new PageResult<>(data, count, pageNum, pageSize);
    }


    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
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
}
