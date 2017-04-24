package com.demo.dao.entity;

/**
 * Created by jafir on 2017/4/21.
 */
public class PhotoEntity {
    private Integer id;
    private String desciption;
    private String url;
    private String createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desciption;
    }

    public void setDesc(String desc) {
        this.desciption = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
