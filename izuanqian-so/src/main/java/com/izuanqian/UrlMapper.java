/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian;


import java.util.List;

import org.apache.ibatis.annotations.*;

/**
 * @author sanlion
 */
@Mapper
public interface UrlMapper {


    @Select("select url from t_url where md5 = #{md5Code}")
    String getUrlByMd5Code(String md5Code);

    @Insert("insert into t_url (id, md5, url, ourl) values (uuid(), #{md5Code}, #{url}, #{originalUrl})")
    boolean saveUrl(String url, String originalUrl, String md5Code);
}
