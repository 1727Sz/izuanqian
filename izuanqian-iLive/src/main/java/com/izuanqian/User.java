package com.izuanqian;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17-3-5.
 */
@Data
public class User {

    private int age;
    private String name;
//    private List<Address> addresses = new ArrayList<>();
    private List<User> friends = new ArrayList<>();
    private Address locate;
    private Wife wife;
}
