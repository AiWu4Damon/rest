package com.tuya.dameng.fan.base;

/**
 * @author 达蒙
 * @version 1.0
 * @date 2022/7/26 2:25 下午
 */
public class 最大连续1的个数 {

    /**
     * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数
     * 双指针算法
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int val = 1;
        int range = 0;
        int fastInd = 0;
        int slowInd = -1;
        for (;fastInd < nums.length;fastInd++){
            if (nums[fastInd] != val){
                slowInd = fastInd;
            }
            range = Math.max(range, fastInd - slowInd);
        }
        return range;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int val = 1;
        int range = 0;
        int fastInd = 0;
        int num = 0;
        for (;fastInd < nums.length;fastInd++){
            if (nums[fastInd] == val){
                num++;
            }else {
                num = 0;
            }
            range = Math.max(range, num);
        }
        return range;
    }
}
