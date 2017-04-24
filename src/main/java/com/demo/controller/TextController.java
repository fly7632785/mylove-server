package com.demo.controller;

import com.demo.dao.entity.PhotoEntity;
import com.demo.dao.entity.TextEntity;
import com.demo.model.TextModel;
import com.demo.service.TextService;
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
@RequestMapping(value = "/text")
public class TextController {
    @Resource
    TextService textService;

    @ResponseBody
    @RequestMapping(value = "/gettexts", method = RequestMethod.GET)
    public TextModel<List<TextEntity>> getTexts() {

        TextModel model = new TextModel();
        model.setData(textService.findAll());
        return model;

    }

    @ResponseBody
    @RequestMapping(value = "/createtext", method = RequestMethod.GET)
    public TextModel<PhotoEntity> createText(TextEntity entity) {

        textService.create(entity);

        TextModel model = new TextModel();
        model.setData(textService.selectById(entity.getId()));
        return model;

    }
}
