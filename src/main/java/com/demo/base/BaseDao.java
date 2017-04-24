package com.demo.base;

import java.util.List;

/**
 * Created by jafir on 2017/4/21.
 */
public interface BaseDao<T> {
    Integer insert(T entity);

    Integer delete(Integer id);

    Integer update(T entity);

    T selectById(Integer id);

    List<T> findAll();


}
