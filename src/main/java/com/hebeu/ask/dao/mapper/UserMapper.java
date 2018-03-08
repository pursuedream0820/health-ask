package com.hebeu.ask.dao.mapper;

import com.hebeu.ask.model.User;
import org.springframework.stereotype.Repository;

/**
 * @Author : chenDeHua
 * @Time : 2018/3/7 下午11:08
 * @Desc :
 **/
@Repository
public interface UserMapper {
    User get(Integer id);
}
