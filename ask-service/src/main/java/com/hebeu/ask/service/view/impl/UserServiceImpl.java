package com.hebeu.ask.service.view.impl;

import com.github.pagehelper.PageHelper;
import com.hebeu.ask.dao.UserDataMapper;
import com.hebeu.ask.dao.UserMapper;
import com.hebeu.ask.model.po.User;
import com.hebeu.ask.model.po.UserData;
import com.hebeu.ask.model.po.UserDataExample;
import com.hebeu.ask.model.vo.CoinTop;
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
     * 查询财富榜
     *
     * @param queryNum 查询数量
     * @return 返回财富榜用户
     */
    @Override
    public List<CoinTop> queryCoinsTop(Integer queryNum) {
        PageHelper.startPage(1, queryNum, "coins desc");
        UserDataExample userDataExample = new UserDataExample();
        UserDataExample.Criteria criteria = userDataExample.createCriteria();
        criteria.andUserIdIsNotNull();
        List<UserData> userDataList = userDataMapper.selectByExample(userDataExample);

        List<CoinTop> coinTops = new ArrayList<>();
        userDataList.iterator().forEachRemaining(userData -> {
            User user = userMapper.selectByPrimaryKey(userData.getUserId());
            CoinTop coinTop = new CoinTop();
            coinTop.setUserData(userData);
            coinTop.setUser(user);
            coinTops.add(coinTop);
        });

        return coinTops;
    }
}
