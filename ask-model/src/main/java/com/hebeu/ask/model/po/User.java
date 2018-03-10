package com.hebeu.ask.model.po;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author : chenDeHua
 * @Time : 2018/3/7 下午11:07
 * @Desc :
 **/
@Setter
@Getter
public class User  implements Serializable {
    private Integer id;
    private String name;
}
