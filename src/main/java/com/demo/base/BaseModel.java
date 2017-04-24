package com.demo.base;

/**
 * Created by jafir on 2017/3/30.
 */
public class BaseModel<T> {

    /**
     * 成功或者失败
     */
    private Boolean status = true;
    /**
     * 返回信息
     */
    private String msg = "success";

    /**
     * data
     */
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
