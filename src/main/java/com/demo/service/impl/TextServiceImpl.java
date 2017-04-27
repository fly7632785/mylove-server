package com.demo.service.impl;

import com.demo.base.BaseServiceImpl;
import com.demo.dao.TextDao;
import com.demo.dao.entity.TextEntity;
import com.demo.service.TextService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务实现类
 *
 * @author Wwwwei
 */
@Service
public class TextServiceImpl extends BaseServiceImpl<TextDao, TextEntity> implements TextService {
    @Resource
    private TextDao dao;

    @PostConstruct
    public void dao() {
        super.setDao(dao);
    }

    public List<TextEntity> getPage(int pageSize, int curPage) {
        return dao.getPage((curPage - 1) * pageSize, pageSize);
    }

    public int getTotal() {
        return dao.getTotal();
    }
}
