package com.demo.service.impl;

import com.demo.base.BaseServiceImpl;
import com.demo.dao.PhotoDao;
import com.demo.dao.entity.PhotoEntity;
import com.demo.service.PhotoService;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 *
 * @author Wwwwei
 */
@Service
public class PhotoServiceImpl extends BaseServiceImpl<PhotoDao, PhotoEntity> implements PhotoService {

}
