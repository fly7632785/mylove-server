package com.demo.controller;

import com.demo.dao.entity.PhotoEntity;
import com.demo.model.PhotoModel;
import com.demo.service.PhotoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jafir on 2017/4/21.
 */
@Controller
@RequestMapping(value = "/photo")
public class PhotoController {
    @Resource
    PhotoService photoService;

    @ResponseBody
    @RequestMapping(value = "/getphotos", method = RequestMethod.GET)
    public PhotoModel<List<PhotoEntity>> getphotos() {

        PhotoModel model = new PhotoModel();
        model.setData(photoService.findAll());
        return model;

    }

    @ResponseBody
    @RequestMapping(value = "/createphoto", method = RequestMethod.GET)
    public PhotoModel<PhotoEntity> createphoto(PhotoEntity entity) {


        photoService.create(entity);

        PhotoModel model = new PhotoModel();
        model.setData(photoService.selectById(entity.getId()));
        return model;

    }
}
