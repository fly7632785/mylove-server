package com.demo.controller;

import com.demo.dao.entity.PhotoEntity;
import com.demo.model.PageModel;
import com.demo.model.PhotoModel;
import com.demo.service.PhotoService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by jafir on 2017/4/21.
 */
@Controller
@RequestMapping(value = "/photo")
public class PhotoController {
    @Resource
    PhotoService photoService;

    @ResponseBody
    @RequestMapping(value = "/getPhotos", method = RequestMethod.GET)
    public PhotoModel<PageModel<PhotoEntity>> getphotos(HttpServletRequest request) {

        PhotoModel<PageModel<PhotoEntity>> model = new PhotoModel<PageModel<PhotoEntity>>();
        PageModel pageModel = new PageModel();
        String pageSize = request.getParameter("pageSize");
        String curPage = request.getParameter("curPage");
        if (!StringUtils.isEmpty(pageSize) ) {
            pageModel.setPage(Integer.valueOf(curPage));
        }
        if( !StringUtils.isEmpty(curPage)){
            pageModel.setSize(Integer.valueOf(pageSize));
        }
        pageModel.setTotal(photoService.getTotal());
        pageModel.setData(photoService.getPage(pageModel.getSize(), pageModel.getPage()));
        model.setData(pageModel);
        return model;

    }

    @ResponseBody
    @RequestMapping(value = "/createPhoto", method = RequestMethod.GET)
    public PhotoModel<PhotoEntity> createphoto(HttpServletRequest request) {

        String url = request.getParameter("url");
        String description = request.getParameter("description");
        PhotoEntity entity = new PhotoEntity();
        entity.setDescription(description);
        entity.setUrl(url);

        photoService.create(entity);

        PhotoModel model = new PhotoModel();
        model.setData(photoService.selectById(entity.getId()));
        return model;

    }

    @ResponseBody
    @RequestMapping(value = "/deletePhoto", method = RequestMethod.GET)
    public PhotoModel<PhotoEntity> deletePhoto(HttpServletRequest request) {

        String id = request.getParameter("id");
        int i = photoService.delete(Integer.valueOf(id));

        PhotoModel model = new PhotoModel();
        if (i > 0) {
            model.setMsg("删除成功");
        } else {
            model.setMsg("删除失败");
        }
        return model;

    }
}
