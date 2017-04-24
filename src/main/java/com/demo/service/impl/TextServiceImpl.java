package com.demo.service.impl;

import com.demo.base.BaseServiceImpl;
import com.demo.dao.TextDao;
import com.demo.dao.entity.TextEntity;
import com.demo.service.TextService;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 *
 * @author Wwwwei
 */
@Service
public class TextServiceImpl extends BaseServiceImpl<TextDao, TextEntity> implements TextService {

}
