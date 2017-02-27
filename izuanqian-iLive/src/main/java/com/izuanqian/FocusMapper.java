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
public interface FocusMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "address", column = "address"),
            @Result(property = "category", column = "category"),
            @Result(property = "count", column = "id", many = @Many(select = "count"))
    })
    @Select("SELECT title, address, category, tel FROM ilive_res.t_resource where title like concat('%',#{keyword},'%') or address like concat('%',#{keyword},'%') limit 0, 10")
    List<DboFocus> queryFocusesBySearch(String keyword);

    @Select("select 1 from dual")
    int count();

}
