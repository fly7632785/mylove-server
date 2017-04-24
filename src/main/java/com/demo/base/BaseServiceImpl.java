package com.demo.base;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jafir on 2017/4/21.
 */
public class BaseServiceImpl<T extends BaseDao<E>,E> implements BaseService<E>{
    @Resource
    private T dao;


    public Integer create(E entity) {
        return dao.insert(entity);
    }

    public Integer update(E e) {
        return dao.update(e);
    }

    public Integer delete(Integer id) {
        return dao.delete(id);
    }

    public E selectById(Integer id) {
        return dao.selectById(id);
    }

    public List<E> findAll() {
        return dao.findAll();
    }
}
