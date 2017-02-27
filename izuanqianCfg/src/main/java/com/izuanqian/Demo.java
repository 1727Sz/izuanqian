/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian;

/**
 *
 * @author sanlion
 */
public class Demo {

    public static void main(String[] args) {

        // 首先输入一个
        System.out.println(execute(3));
    }

    public static int execute(int n) {

        //对任何一个自然数n，如果它是偶数，那么把它砍掉一半；如果它是奇数，
        //那么把(3n+1)砍掉一半。这样一直反复砍下去，最后一定在某一步得到n=1。
        //给定的任一不超过1000的正整数n,简单地数一下，需要多少步（砍几下）才能得到n=1？
        // 初始化次数为0
        int count = 0; // 计数
        // 首先判断n 是否小于等于1，若是，直接跳出
        if (n == 1) {
            return count;
        }

        // 循环，直到n==1时，跳出，结束
        while (n != 1) {
            // 正式的逻辑
            // 偶数
            if (n % 2 == 0) {
                n /= 2;
            } else {
                // 奇数
                n = (3 * n + 1) / 2;
            }
            // 计数+1
            count++;
        }
        return count;
    }

}
