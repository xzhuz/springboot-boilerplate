package fun.baozi.core.domain.page;

/**
 * Paging
 * @author baozi
 * 2020-07-14
 */
public class PageInfo {

    /**
     * Current number of page.
     * Default number is 0.
     */
    private Integer pageNum = 0 ;
    /**
     * Size of data per page.
     * Default size is 20.
     */
    private Integer pageSize = 20;

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
