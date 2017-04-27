package com.demo.service;

import com.demo.base.BaseService;
import com.demo.dao.entity.TextEntity;

import java.util.List;

/**
 * Created by jafir on 2017/4/21.
 */
public interface TextService extends BaseService<TextEntity> {


    List<TextEntity> getPage(int pageSize, int curPage);
    int getTotal();

}
