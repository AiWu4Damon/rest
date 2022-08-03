package com.tuya.dameng.fan.base;

/**
 * @author 达蒙
 * @version 1.0
 * @date 2022/7/26 3:27 下午
 */
public class 长度最小的子数组 {


    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0
     *
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     */
    public int minSubArrayLen(int target, int[] nums) {
        int rangeMin = nums.length + 1;
        int leftInd =0;
        int rightInd =0;
        while (true){
            int sum = 0;
            for (int i = leftInd; i <= rightInd; i++){
                sum += nums[i];
            }
            if (sum >= target){
                leftInd++;
                rangeMin = Math.min(rangeMin, rightInd - leftInd + 1);
            }else {
                rightInd++;
            }
            if (rightInd > nums.length-1){
                return rangeMin > nums.length ? 0 : rangeMin;
            }
        }
    }
}
