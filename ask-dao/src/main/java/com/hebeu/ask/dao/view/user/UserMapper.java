package com.hebeu.ask.dao.view.user;

import com.hebeu.ask.model.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author : chenDeHua
 * @Time : 2018/3/7 下午11:08
 * @Desc :
 **/
@Repository
@Mapper
public interface UserMapper {
    User get(@Param("id") Integer id);
}
