package com.demo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jafir on 2017/4/26.
 */
public class PageModel<T> {
    private int page = 1; // 页码 从1开始

    private int size = 20; // 分页大小 默认10

    private List<T> data = new ArrayList(); // 分页数据

    private int total;// 符合查询条件的总条目数


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
