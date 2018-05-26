package com.hebeu.ask.web.controller;

import com.hebeu.ask.model.po.Doing;
import com.hebeu.ask.model.po.User;
import com.hebeu.ask.model.po.UserData;
import com.hebeu.ask.model.vo.AnswerVo;
import com.hebeu.ask.model.vo.DoingVo;
import com.hebeu.ask.model.vo.QuestionVo;
import com.hebeu.ask.model.vo.UserVo;
import com.hebeu.ask.service.view.AnswerService;
import com.hebeu.ask.service.view.QuestionService;
import com.hebeu.ask.service.view.UserService;
import com.hebeu.ask.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/5/23 下午4:24
 * Desc   : 用户信息控制器
 **/

@Controller
@Slf4j
@RequestMapping("/space")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;


    /**
     * 个人主页查看
     *
     * @return 返回个人主页
     */
    @RequestMapping(path = "index")
    public String userIndex(Model model, Integer userId) {
        UserVo userInfo = getUserInfo(userId);
        // 更新浏览次数
        UserData userData = userService.queryUserDataByUserId(userId);
        userService.updateUserData(userData);
        userInfo.setUserData(userData);
        List<Doing> doings = userService.queryDoingByUserId(userId);

        List<DoingVo> doingVoList = new ArrayList<>();
        doings.iterator().forEachRemaining(doing -> {
            DoingVo doingVo = new DoingVo();
            BeanUtils.copyProperties(doing, doingVo);
            doingVo.setCreateTime(DateUtil.dateToString(DateUtil.yyyy_MM_dd_HH_mm_ss, doing.getCreatedAt()));
            doingVoList.add(doingVo);
        });

        model.addAttribute("doings", doingVoList);
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("userId", userId);
        model.addAttribute("type", "index");
        model.addAttribute("size",doingVoList.size());

        return "view/space/index";
    }

    @RequestMapping(path = "answer")
    public String userAnswer(Model model, Integer userId) {
        UserVo userInfo = getUserInfo(userId);
        List<AnswerVo> answerVoList = answerService.queryAnswerByUserId(userId);
        model.addAttribute("type", "answer");
        model.addAttribute("userId", userId);
        model.addAttribute("answerVoList", answerVoList);
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("size", answerVoList.size());
        return "view/space/answers";
    }


    @RequestMapping(path = "question")
    public String userQuestion(Model model, Integer userId) {
        List<QuestionVo> questionVoList = questionService.queryByUserId(userId);
        UserVo userInfo = getUserInfo(userId);
        model.addAttribute("type", "question");
        model.addAttribute("userId", userId);
        model.addAttribute("questionVoList", questionVoList);
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("size",questionVoList.size());
        return "view/space/questions";
    }

    /**
     * 通过userId得到userInfo
     *
     * @param userId 用户id
     * @return 返回用户信息
     */
    public UserVo getUserInfo(Integer userId) {
        User user = userService.queryUserById(userId);
        UserData userData = userService.queryUserDataByUserId(userId);

        UserVo userInfo = new UserVo();
        userInfo.setRegisterTime(DateUtil.dateToString(DateUtil.yyyy_MM_dd_HH_mm_ss, user.getCreatedAt()));
        userInfo.setUserData(userData);
        userInfo.setUser(user);

        return userInfo;
    }

//    public String attentionUser(){
//
//    }
}
