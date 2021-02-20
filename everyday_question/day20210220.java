package com.leetcode.every_question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class day20210220 {
/*
 * 697. 数组的度
给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。

你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

 

示例 1：

输入：[1, 2, 2, 3, 1]
输出：2
解释：
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.
示例 2：

输入：[1,2,2,3,1,4,2]
输出：6
 

提示：

nums.length 在1到 50,000 区间范围内。
nums[i] 是一个在 0 到 49,999 范围内的整数。
 * 
 * */
	//[1, 2, 2, 3, 1]
    public int findShortestSubArray(int[] nums) { 	
    	HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
    	int max = 0;
    	int len = 0;
    	for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
    	}
        for (Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (max < arr[0]) {
                max = arr[0];
                len = arr[2] - arr[1] + 1;
            } else if (max == arr[0] && len > arr[2] - arr[1] + 1) {
                    len = arr[2] - arr[1] + 1;
            }
        }
    	return len;
    	
    	/*
    	int[][] arr = new int[50000][3];
    	int max = 0;
    	int len = 0;
    	for (int i = 0; i < nums.length; ++i) {
    		++arr[nums[i]][0];
    		if (arr[nums[i]][1] != 0)
    			arr[nums[i]][2] = i + 1 - arr[nums[i]][1];    			
    		else
    			arr[nums[i]][1] = i + 1;
    		System.out.println("arr["+nums[i]+"][0]:"+arr[nums[i]][0]);
    		System.out.println("arr["+nums[i]+"][2]:"+arr[nums[i]][2]);
    		if (arr[nums[i]][0] > max) {
    			max = arr[nums[i]][0];
    			len = arr[nums[i]][2];
    		}
    		else if (arr[nums[i]][0] == max && arr[nums[i]][2] < len) {
    			len = arr[nums[i]][2];
    		}
    	}
    	return len + 1;
    	*/
    }
}
