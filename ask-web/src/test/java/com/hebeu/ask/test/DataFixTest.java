package com.hebeu.ask.test;

import com.hebeu.ask.dao.UserDataMapper;
import com.hebeu.ask.dao.UserMapper;
import com.hebeu.ask.model.po.User;
import com.hebeu.ask.model.po.UserData;
import com.hebeu.ask.model.po.UserExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/5/10 下午6:56
 * Desc   :
 **/
@Slf4j
public class DataFixTest extends BaseApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDataMapper userDataMapper;

    @Test
    public void fixUserData() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdIsNotNull();
        List<User> userList = userMapper.selectByExample(userExample);

        userList.iterator().forEachRemaining(user -> {
            UserData userData = new UserData();
            userData.setUserId(user.getId());
            try {
                log.info("插入用户id，userId:{}", user.getId());
                userDataMapper.insertSelective(userData);
            } catch (Exception e) {
                log.error("插入数据异常", e);
            }
        });
    }
}
