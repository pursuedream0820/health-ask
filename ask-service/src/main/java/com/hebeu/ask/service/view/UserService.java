package com.hebeu.ask.service.view;

import com.hebeu.ask.dao.view.user.UserMapper;
import com.hebeu.ask.model.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : chenDeHua
 * Time   : 2018/3/10 下午2:03
 * Desc   :
 **/

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUser(Integer id){
        return userMapper.get(id);
    }
}
