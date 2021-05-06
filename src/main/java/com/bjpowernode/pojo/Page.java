package com.bjpowernode.pojo;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
    //当前页码
    private Integer pageNO;
    //总页码
    private Integer pageTotal;
    //当前页显示数量
    private Integer pageSize = 4;
    //总记录数
    private Long pageTotalCount;
    //当前页数据
    private List<T> items;

    private String url;

    private String action;

    private String pagesurl = "";

    public String getPagesurl() {
        return pagesurl;
    }

    public void setPagesurl(String pagesurl) {
        this.pagesurl = pagesurl;
    }

    private int[] pageValues = new int[0];

    public Integer getPageNO() {
        return pageNO;
    }

    public void setPageNO(Integer pageNO) {
        this.pageNO = pageNO;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Long getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Long pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUrl() {
        return url;
    }

    public Page(List<T> items) {
        this.items = items;
    }

    public Page() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int[] getPageValues() {
        if (pageNO > pageTotal || pageNO < 1) {
            return new int[0];
        }
        int size = (pageTotal < 3) ? pageTotal : 3;
        int begin = pageNO - 1;
        if (pageNO == pageTotal && pageNO > 2) {
            begin = pageNO - 2;
        }
        if (pageNO == 1) {
            begin = pageNO;
        }
        int[] res = new int[size];
        for (int i = 0; i < res.length; i++) {
            res[i] = begin++;
        }
        return res;
    }


    @Override
    public String toString() {
        return "Page{" +
                "pageNO=" + pageNO +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                '}';
    }

    public static Integer parseint(String string, Integer defaultValue) {
        if (string == null || "".equals(string)) {
            return defaultValue;
        } else return Integer.valueOf(string);
    }
}
