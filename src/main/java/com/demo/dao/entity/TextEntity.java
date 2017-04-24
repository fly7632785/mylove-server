package com.demo.dao.entity;

/**
 * Created by jafir on 2017/4/21.
 */
public class TextEntity {

    private Integer id;
    private String content;
    private String createTime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
