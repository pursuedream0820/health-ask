package com.hebeu.ask.service.view;

import com.hebeu.ask.model.po.UserData;
import com.hebeu.ask.model.vo.UserTop;

import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/5/10 下午6:26
 * Desc   :
 **/
public interface UserService {

    /**
     * 用户排行榜
     * @param queryNum 查询数量
     * @param topType 排行榜类型
     * @return 返回用户排行榜
     */
    List<UserTop> queryUserTop(Integer queryNum, String topType);

}
