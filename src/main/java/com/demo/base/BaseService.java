package com.demo.base;

import java.util.List;

/**
 * Created by jafir on 2017/4/21.
 */
public interface BaseService <T>{

    Integer create(T t);

    Integer update(T t);

    Integer delete(Integer id);

    T selectById(Integer id);

    List<T> findAll();
}
