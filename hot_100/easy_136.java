package com.leetcode.hot_100;

import java.util.HashSet;
import java.util.Set;

public class easy_136 {
/*
 * 136. 只出现一次的数字
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4
 * */
	
    public int singleNumber(int[] nums) {
    	
    	/*
    	 * 任何数和 00 做异或运算，结果仍然是原来的数，即 a⊕0=a。
                             任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
		        异或运算满足交换律和结合律，即a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b
    	 * */
    	int con = 0;
    	for (int num : nums)
    		con ^= num;
    	return con;
    	
    	
    	/*
    	Set<Integer> con = new HashSet<Integer>();
    	for (int i = 0; i < nums.length; ++i) {
    		if (con.contains(nums[i]))
    			con.remove(nums[i]);
    		else
    			con.add(nums[i]);
    	}
    	return con.hashCode();
    	*/
    }
}
