package com.hebeu.ask.service.view.impl;

import com.hebeu.ask.dao.UserMapper;
import com.hebeu.ask.model.po.User;
import com.hebeu.ask.model.po.UserExample;
import com.hebeu.ask.service.view.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/5/9 下午3:39
 * Desc   :
 **/
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 保存用户信息
     *
     * @param user 用户对象
     * @return 返回操作结果
     */
    @Override
    public boolean saveUser(User user) {
        return userMapper.insertSelective(user) > 0;
    }


    /**
     * 判断是否存在用户名
     *
     * @param username 用户名
     * @return 返回true表示存在 ，false表示不存在
     */
    @Override
    public boolean isExistUsername(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo(username);

        List<User> users = userMapper.selectByExampleWithBLOBs(userExample);
        User user = users.stream().findFirst().orElse(null);

        return user != null;
    }
}
