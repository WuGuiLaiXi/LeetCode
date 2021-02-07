package com.leetcode.every_question;


public class day20210207 {

	/*
	 * 665. 非递减数列
给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。

示例 1:
输入: nums = [4,2,3]
输出: true
解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。

示例 2:
输入: nums = [4,2,1]
输出: false
解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 
说明：
1 <= n <= 10 ^ 4
- 10 ^ 5 <= nums[i] <= 10 ^ 5
* */
	//5 7 1 8
    public boolean checkPossibility(int[] nums) {
    	int count = 0;
    	for (int i = 0; i < nums.length && count < 2; i++) {
    		//只要有大于的 就++，如果 第三位 比第一位 小 那就将第三位 降 ，如果 大，那就将 第二位 升
    		if (nums[i] > nums[i+1]) {
    			count++;
    			if(i > 0 && nums[i+1] < nums[i-1])
    				nums[i+1] = nums[i];
    			else
    				nums[i] = nums[i+1];
    		}
    	}
    	return count < 2;   	
    }
}
