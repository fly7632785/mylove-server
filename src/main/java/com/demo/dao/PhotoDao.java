package com.demo.dao;

import com.demo.base.BaseDao;
import com.demo.dao.entity.PhotoEntity;

import java.util.List;

/**
 * Created by jafir on 2017/4/21.
 */
public interface PhotoDao extends BaseDao<PhotoEntity> {

    int getTotal();

    List<PhotoEntity> getPage(Integer start,Integer pageSize);

}
