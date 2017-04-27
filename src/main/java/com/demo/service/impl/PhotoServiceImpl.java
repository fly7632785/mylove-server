package com.demo.service.impl;

import com.demo.base.BaseServiceImpl;
import com.demo.dao.PhotoDao;
import com.demo.dao.entity.PhotoEntity;
import com.demo.service.PhotoService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务实现类
 *
 */
@Service
public class PhotoServiceImpl extends BaseServiceImpl<PhotoDao, PhotoEntity> implements PhotoService {

    @Resource
    private PhotoDao dao;

    @PostConstruct
    public void dao()
    {
        super.setDao(dao);
    }

    public List<PhotoEntity> getPage(int pageSize,int curPage) {
        return dao.getPage((curPage-1)*pageSize,pageSize);
    }

    public int getTotal() {
        return dao.getTotal();
    }


}
