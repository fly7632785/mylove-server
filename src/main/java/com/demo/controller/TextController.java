package com.demo.controller;

import com.demo.dao.entity.TextEntity;
import com.demo.model.PageModel;
import com.demo.model.TextModel;
import com.demo.service.TextService;
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
@RequestMapping(value = "/text")
public class TextController {
    @Resource
    TextService textService;

    @ResponseBody
    @RequestMapping(value = "/getTexts", method = RequestMethod.GET)
    public TextModel<PageModel<TextEntity>> getTexts(HttpServletRequest request) {

        TextModel<PageModel<TextEntity>> model = new TextModel<PageModel<TextEntity>>();
        PageModel pageModel = new PageModel();
        String pageSize = request.getParameter("pageSize");
        String curPage = request.getParameter("curPage");

        if (!StringUtils.isEmpty(pageSize) || !StringUtils.isEmpty(curPage)) {
            pageModel.setPage(Integer.valueOf(curPage));
            pageModel.setSize(Integer.valueOf(pageSize));
        }
        pageModel.setTotal(textService.getTotal());
        pageModel.setData(textService.getPage(pageModel.getSize(), pageModel.getPage()));
        model.setData(pageModel);
        return model;

    }

    @ResponseBody
    @RequestMapping(value = "/createText", method = RequestMethod.GET)
    public TextModel<TextEntity> createText(HttpServletRequest request) {
        String content = request.getParameter("content");
        TextEntity entity = new TextEntity();
        entity.setContent(content);
        textService.create(entity);

        TextModel model = new TextModel();
        model.setData(textService.selectById(entity.getId()));
        return model;

    }

    @ResponseBody
    @RequestMapping(value = "/deleteText", method = RequestMethod.GET)
    public TextModel<TextEntity> deleteText(HttpServletRequest request) {

        String id = request.getParameter("id");
        int i = textService.delete(Integer.valueOf(id));

        TextModel model = new TextModel();
        if (i > 0) {
            model.setMsg("删除成功");
            model.setStatus(true);
        } else {
            model.setMsg("删除失败");
            model.setStatus(false);
        }
        return model;

    }

}

