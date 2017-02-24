/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sanlion
 */
@Data
public class DboFocus implements Serializable {

    private static final long serialVersionUID = 426495515371058786L;

    private String id;
    private String title;
    private String address;
    private String category;
    private int count;
}
