package com.leetcode.every_question;

import java.util.TreeMap;

public class day20210221 {
/*
 * 1438. 绝对差不超过限制的最长连续子数组
给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。

如果不存在满足条件的子数组，则返回 0 。

 

示例 1：

输入：nums = [8,2,4,7], limit = 4
输出：2 
解释：所有子数组如下：
[8] 最大绝对差 |8-8| = 0 <= 4.
[8,2] 最大绝对差 |8-2| = 6 > 4. 
[8,2,4] 最大绝对差 |8-2| = 6 > 4.
[8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
[2] 最大绝对差 |2-2| = 0 <= 4.
[2,4] 最大绝对差 |2-4| = 2 <= 4.
[2,4,7] 最大绝对差 |2-7| = 5 > 4.
[4] 最大绝对差 |4-4| = 0 <= 4.
[4,7] 最大绝对差 |4-7| = 3 <= 4.
[7] 最大绝对差 |7-7| = 0 <= 4. 
因此，满足题意的最长子数组的长度为 2 。
示例 2：

输入：nums = [10,1,2,4,7,2], limit = 5
输出：4 
解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
示例 3：

输入：nums = [4,2,2,2,4,4,2,2], limit = 0
输出：3
 

提示：

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
0 <= limit <= 10^9
 * */
	//10,1,2,4,7,2    5
	//
    public int longestSubarray(int[] nums, int limit) {

    	TreeMap<Integer, Integer> map = new TreeMap<>();
    	int left = 0, right = 0;
    	int count = 0;
    	while (right < nums.length) {
    		map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
    		while (map.lastKey() - map.firstKey() > limit) {
    			map.put(nums[left], map.get(nums[left]) - 1);
    			if (map.get(nums[left]) == 0) {
    				map.remove(nums[left]);
    			}
    			++ left;
    		}
			if (right - left + 1 > count)
				count = right - left + 1;
    		++ right;
    	}
    	return count;


    	
    	/*  没有考虑 Left左移时 的情况 ，应该 找到 最小的 下一位的，
    	int count = 0;
    	int n = nums.length;
    	int maxNum = 0;
    	int min = nums[0];
    	int left = 0;
    	int right = 0;
    	while (right < n) {
    		if (nums[right] < min) {
    			maxNum = min - nums[right] + maxNum;
    			min = nums[right];
    			if (maxNum <= limit)
    				++right;
    			else {
    				maxNum = 0;
    				if (right - left > count)
    					count = right - left;
    				left = right;
    				++right;
    			}
    		}
    		else if (nums[right] > min) {
    			if (nums[right] - min <= limit) {
    				if (nums[right] - min > maxNum)
    					maxNum = nums[right] - min;
    				++right;
    			}
    			else {
    				min = nums[right];
    				maxNum = 0;
    				if (right - left > count)
    					count = right - left;
    				left = right;
    				++right;
    			}
    		}	
    		else
    			++right;
			if (right - left > count)
				count = right - left;
    	}   	
    	return count;
    	
    	*/
    }
}
