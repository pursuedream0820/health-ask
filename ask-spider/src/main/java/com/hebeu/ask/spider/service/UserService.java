package com.hebeu.ask.spider.service;

import com.hebeu.ask.dao.UserDataMapper;
import com.hebeu.ask.dao.UserMapper;
import com.hebeu.ask.model.po.User;
import com.hebeu.ask.model.po.UserData;
import com.hebeu.ask.model.po.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/5/4 上午11:45
 * Desc   :
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDataMapper userDataMapper;


    /**
     * 通过姓名查询用户
     *
     * @param name 用户姓名
     * @return 返回满足条件的用户对象
     */
    public User queryByName(String name) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();


        criteria.andNameEqualTo(name);
        List<User> users = userMapper.selectByExample(userExample);

        return users.stream().findFirst().orElse(null);

    }


    /**
     * 保存用户
     *
     * @param username 用户名
     * @return 返回用户记录id
     */
    public Integer insertOrUpdateUser(String username) {

        User user = this.queryByName(username);
        if (user != null) {
            return user.getId();
        }

        User askUser = new User();
        askUser.setName(username);
        userMapper.insertSelective(askUser);

        UserData userData = new UserData();
        userData.setUserId(askUser.getId());
        userDataMapper.insertSelective(userData);

        return askUser.getId();
    }

}
