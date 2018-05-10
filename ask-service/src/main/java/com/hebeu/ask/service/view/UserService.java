package com.hebeu.ask.service.view;

import com.hebeu.ask.model.vo.CoinTop;

import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/5/10 下午6:26
 * Desc   :
 **/
public interface UserService {

    /**
     * 查询财富榜
     * @param queryNum 查询数量
     * @return 返回财富榜用户
     */
    List<CoinTop> queryCoinsTop(Integer queryNum);
}
