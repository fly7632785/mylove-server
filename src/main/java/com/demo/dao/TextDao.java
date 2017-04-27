package com.demo.dao;

import com.demo.base.BaseDao;
import com.demo.dao.entity.TextEntity;

import java.util.List;

/**
 * Created by jafir on 2017/4/21.
 */
public interface TextDao extends BaseDao<TextEntity> {

    int getTotal();

    List<TextEntity> getPage(int start, int pageSize);
}
