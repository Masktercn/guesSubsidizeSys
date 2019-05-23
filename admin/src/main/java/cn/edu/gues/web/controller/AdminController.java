package cn.edu.gues.web.controller;

import cn.edu.gues.mapper.SubsidizeInfoMapper;
import cn.edu.gues.pojo.AdminUser;
import cn.edu.gues.pojo.Class;
import cn.edu.gues.pojo.User;
import cn.edu.gues.service.SubsidizeInfoService;
import cn.edu.gues.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import cn.edu.gues.pojo.Member;
import cn.edu.gues.pojo.User;
import cn.edu.gues.util.AjaxResult;
import cn.edu.gues.util.CommonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


/**
 * AdminController
 *
 * @author lulu
 * @date 2019-05-16
 **/
@Controller
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private SubsidizeInfoService subsidizeInfoService;

    @Autowired
    private UserService userService;

    @RequestMapping("/indexTeacher.do")
    public ModelAndView indexTeacher(){
        return new ModelAndView("indexTeacher");
    }

    @RequestMapping("/teaCheck.do")
    public ModelAndView teaCheck(Integer checkStatus, String name, Date year, HttpServletRequest request){

        AdminUser adminUser = (AdminUser) request.getSession().getAttribute("adminUser");
        List<Class> classList = (List<Class>) request.getSession().getAttribute("classList");


        return new ModelAndView("teacher/teaCheck");
    }

    /**
     * 教师对下一级权限者的管理
     * @return
     */
    @RequestMapping(value = "/nextLevelcontrol.do", method = RequestMethod.GET)
    public ModelAndView nextLevelcontrol(){
        return new ModelAndView("teacher/nextLevelcontrol");
    }

    // 没写好，不知道七七八八的services是什么 作者:WSW
    @RequestMapping(value = "/nextLeveladd.do", method = RequestMethod.POST)
    public ModelAndView nextLeveladd(){
        return new ModelAndView("teacher/nextLeveladd");
    }

    /**
     * 学院班级管理-学院管理
     * @return
     */
    @RequestMapping(value = "/academyAdd.do", method = RequestMethod.GET)
    public ModelAndView academyAdd(){
        return new ModelAndView("teacher/academyAdd");
    }

    /**
     * 学院班级管理-班级管理
     * @return
     */
    @RequestMapping(value = "/classAdd.do", method = RequestMethod.GET)
    public ModelAndView classAdd(){
        return new ModelAndView("teacher/classAdd");
    }

    /**
     * 权限管理-用户权限管理
     * @return
     */
    @RequestMapping(value = "/adminList.do", method = RequestMethod.GET)
    public ModelAndView adminList(){
        return new ModelAndView("teacher/adminList");
    }

    /**
     * 权限管理-角色管理
     * @return
     */
    @RequestMapping(value = "/roleList.do", method = RequestMethod.GET)
    public ModelAndView roleList(){
        return new ModelAndView("teacher/roleList");
    }

    /**
     * 学生信息
     * @return
     */
    @RequestMapping(value = "/studentInformation.do", method = RequestMethod.GET)
    public ModelAndView studentInformation(){
        return new ModelAndView("teacher/studentInformation");
    }

}
