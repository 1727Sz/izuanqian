/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian;

import java.text.MessageFormat;

/**
 *
 * @author sanlion
 */
public final class Key {

    public static String __(String key, Object... args) {
        return MessageFormat.format(key, args);
    }

    public static byte[] ___(String key, Object... args) {
        return __(key, args).getBytes();
    }
}
