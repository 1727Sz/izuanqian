/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian.rest.focus;

import com.google.common.collect.Lists;
import java.util.List;

import com.izuanqian.rest.focus.vo.FocusVo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sanlion
 */
@RestController
@RequestMapping("/focus")
public class FocusController {

    @Autowired private FocusService focusService;

    @GetMapping
    public List<FocusVo> sayHello(
            @RequestParam("q") String keyword) {
        List<Focus> focuses = focusService.search(keyword);
        List<FocusVo> vos = Lists.newArrayList();
        focuses.forEach((Focus t) -> {
            vos.add(
                    FocusVo.builder()
                            .title(t.getTitle())
                            .content(t.getAddress())
                            .build()
            );
        });
        return vos;
    }
}
