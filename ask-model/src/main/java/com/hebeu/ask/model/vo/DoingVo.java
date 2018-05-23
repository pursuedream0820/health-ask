package com.hebeu.ask.model.vo;

import com.hebeu.ask.model.po.Doing;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : chenDeHua
 * Time   : 2018/5/23 下午6:31
 * Desc   :
 **/

@Setter
@Getter
public class DoingVo extends Doing {

    /**
     * 创建时间
     */
    private String createTime;
}
