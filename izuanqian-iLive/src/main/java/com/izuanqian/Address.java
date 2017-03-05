package com.izuanqian;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17-3-5.
 */
@Data
public class Address {

    private String address;
    private List<Integer> a = new ArrayList<>();
}
