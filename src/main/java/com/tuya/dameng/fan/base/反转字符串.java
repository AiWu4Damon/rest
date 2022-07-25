package com.tuya.dameng.fan.base;

/**
 * @author 达蒙
 * @version 1.0
 * @date 2022/7/23 6:37 下午
 */
public class 反转字符串 {

    public void reverseString(char[] s) {
        if (s == null || s.length == 1){return;}
        char mid;
        for(int s1 = 0, e1 = s.length-1; s1 < e1; s1++,e1--){
            mid = s[s1];
            s[s1] = s[e1];
            s[e1] = mid;
            //说明距离已经不用反转
            if (e1 - s1 <= 2){return;}
        }
    }
}
