package com.demo.service;

import com.demo.base.BaseService;
import com.demo.dao.entity.PhotoEntity;

import java.util.List;

/**
 *
 */
public interface PhotoService  extends BaseService<PhotoEntity> {

    List<PhotoEntity> getPage(int pageSize, int curPage);
    int getTotal();

}
