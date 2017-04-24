package com.demo.controller;

import com.demo.dao.entity.UserEntity;
import com.demo.model.LoginModel;
import com.demo.model.LogoutModel;
import com.demo.model.SignInModel;
import com.demo.model.UserinfoModel;
import com.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by wwwwei on 17/3/18.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;


    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public LoginModel login(@Param(value = "username") String username, @Param(value = "password") String password, HttpSession httpSession) {

        UserEntity userEntity;
        LoginModel loginModel = new LoginModel();

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            loginModel.setStatus(false);
            loginModel.setMsg("账号或者密码不能为空");
            return loginModel;
        }

        userEntity = userService.getUserByUP(username, password);
        if (userEntity == null) {
            loginModel.setStatus(false);
            loginModel.setMsg("用户名或者密码错误");
            return loginModel;
        }

        loginModel.setStatus(true);
        loginModel.setMsg("登录成功");
        /**
         * 保存session
         */
        httpSession.setAttribute("username", username);
        return loginModel;

    }


    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public LogoutModel logout(HttpSession httpSession) {
        httpSession.removeAttribute("username");
        LogoutModel logoutMode = new LogoutModel();
        logoutMode.setStatus(true);
        logoutMode.setMsg("退出登录 成功");
        return logoutMode;
    }

    /**
     * 测试暂定为get
     *
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public SignInModel signin(@Param(value = "username") String username, @Param(value = "password") String password) {
        UserEntity userEntity = new UserEntity();
        SignInModel signInModel = new SignInModel();

        /**
         * 如果账号或者密码为空则返回信息
         */
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            signInModel.setStatus(false);
            signInModel.setMsg("账号或者密码不能为空");
            return signInModel;
        }


        /**
         * 信息校验
         */
        if (password.length() < 6 || password.length() > 18) {
            signInModel.setStatus(false);
            signInModel.setMsg("密码只能6-18位");
            return signInModel;
        }
//        if (username.length() < 6) {
//            signInModel.setStatus(false);
//            signInModel.setMsg("账号必须大于6-18位");
//            return signInModel;
//        }


        userEntity.setPassword(password);
        userEntity.setUsername(username);

        /**
         * 判断用户名是否已经注册
         */
        UserEntity user = userService.getUserByUsername(username);
        if (user != null) {
            signInModel.setStatus(false);
            signInModel.setMsg("用户名重复");
            return signInModel;
        }


        userService.createUser(userEntity);
        int id = userEntity.getId();
        userEntity = userService.getUserById(id);
        /**
         * 返回user信息
         */
        signInModel.setStatus(true);
        signInModel.setData(userEntity);
        signInModel.setMsg("注册成功");
        return signInModel;
    }


    @ResponseBody
    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    public UserinfoModel userinfo(HttpSession session) {
        UserinfoModel userinfoModel = new UserinfoModel();

        String username = (String) session.getAttribute("username");
        /**
         * 如果session里面没有数据则表明没有登录
         */
        if (StringUtils.isEmpty(username)) {
            userinfoModel.setMsg("尚未登录");
            return userinfoModel;
        }


        List<UserEntity> users = userService.findAll();
//       直接返回json

        userinfoModel.setData(users);
        userinfoModel.setMsg("success");
        userinfoModel.setStatus(true);
        return userinfoModel;
    }


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        List<UserEntity> users = userService.findAll();
//       直接返回json
        model.addAttribute("userlist", users);
        return "index";
    }


}
