package com.zy.snippets;

import lombok.Data;

import java.io.Serializable;

/**
 * 个人基础信息DO
 *
 * @author : zy
 * @date : 2019/3/24 14:43
 */
@Data
public class Person implements Serializable {

    /**
     * 名称
     */
    private String name;

    /**
     * 性别：0-女性，1-男性
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 身高
     */
    private Integer height;

    /**
     * 体重
     */
    private Integer weight;

}
