package com.tuya.dameng.fan.pointer;

import java.util.Arrays;

/**
 * @author 达蒙
 * @version 1.0
 * @date 2022/7/23 7:05 下午
 */
public class 数组拆分求min最大 {


    /**
     * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
     *
     *
     * 1 <= n <= 104
     * nums.length == 2 * n
     * -104 <= nums[i] <= 104
     */
    public int arrayPairSum(int[] nums) {
        //排序后取奇数项
        Arrays.sort(nums);
        int sum = 0;
        for (int i=0; i < nums.length; i+=2){
            sum += nums[i];
        }
        return sum;
    }
}
