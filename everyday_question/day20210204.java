package com.leetcode.every_question;

public class day20210204 {
	
	/*
	 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
	 * 
示例：
输入：[1,12,-5,-6,50,3], k = 4
输出：12.75
解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75

提示：
1 <= k <= n <= 30,000。
所给数据范围 [-10,000，10,000]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
	 * */
    public double findMaxAverage(int[] nums, int k) {
    	int mun = 0;
    	for(int i = 0 ; i < k; i++) {
    		mun += nums[i];
    	}
    	int newmun = mun; 
    	for (int right = k; right < nums.length; right++) {
    		newmun = newmun - nums[right-k] + nums[right];
    		if (newmun > mun) {
    			mun = newmun;
    		}
    	}
    	return (double)mun / k;
    }
}
