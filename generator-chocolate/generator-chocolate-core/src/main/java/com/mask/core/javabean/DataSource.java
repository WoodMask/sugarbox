package com.mask.core.javabean;

import lombok.Data;

/**
 * Name: DataSource Model
 * Desc: 主要用于数据库连接
 **/
@Data
public class DataSource {

    /**
     * Name: 数据库类型
     * Desc: MYSQL, ORACLE etc...
     **/
    private String database;

    /**
     * Name: 驱动类型
     * Desc: 例如 MYSQL的为： com.mysql.jdbc.Driver
     **/
    private String driver;

    private String url;

    private String userName;

    private String password;
}
