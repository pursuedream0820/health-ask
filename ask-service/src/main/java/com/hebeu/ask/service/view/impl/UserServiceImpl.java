package com.hebeu.ask.service.view.impl;

import com.github.pagehelper.PageHelper;
import com.hebeu.ask.dao.UserDataMapper;
import com.hebeu.ask.dao.UserMapper;
import com.hebeu.ask.model.po.User;
import com.hebeu.ask.model.po.UserData;
import com.hebeu.ask.model.po.UserDataExample;
import com.hebeu.ask.model.vo.UserTop;
import com.hebeu.ask.service.view.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/5/10 下午6:29
 * Desc   :
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDataMapper userDataMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户排行榜
     * @param queryNum 查询数量
     * @return 返回用户排行榜
     */
    @Override
    public List<UserTop> queryUserTop(Integer queryNum, String topType) {
        if ("coins".equals(topType)){
            PageHelper.startPage(1, queryNum, "coins desc");
        }else if ("credits".equals(topType)){
            PageHelper.startPage(1, queryNum, "credits desc");
        }
        UserDataExample userDataExample = new UserDataExample();
        UserDataExample.Criteria criteria = userDataExample.createCriteria();
        criteria.andUserIdIsNotNull();
        List<UserData> userDataList = userDataMapper.selectByExample(userDataExample);

        List<UserTop> userTops = new ArrayList<>();
        userDataList.iterator().forEachRemaining(userData -> {
            User user = userMapper.selectByPrimaryKey(userData.getUserId());
            UserTop coinTop = new UserTop();
            coinTop.setUserData(userData);
            coinTop.setUser(user);
            userTops.add(coinTop);
        });

        return userTops;
    }
}
