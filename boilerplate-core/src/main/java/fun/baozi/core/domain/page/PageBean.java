package fun.baozi.core.domain.page;


import java.util.List;

/**
 * Paging query return bean.
 * @author baozi
 * 2020-07-14
 */
public class PageBean<T> {

    /**
     * Query data.
     */
    private List<T> data;

    /**
     * Number of query data
     */
    private Long count;

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
}
