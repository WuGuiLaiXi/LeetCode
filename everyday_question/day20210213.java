package com.leetcode.every_question;

import java.util.ArrayList;
import java.util.List;

public class day20210213 {
/*
 * 448. 找到所有数组中消失的数字
给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
找到所有在 [1, n] 范围之间没有出现在数组中的数字。
您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

示例:
输入:
[4,3,2,7,8,2,3,1]

输出:
[5,6]
 * 
 * */
	
	
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> list = new ArrayList<Integer>();
    	int n = nums.length;
    	for (int num : nums) {
    		int x = (num - 1) % n;
    		nums[x] += n;
    	}
    	for (int i = 0; i < n; ++i) {
    		if (nums[i] <= n)
    			list.add(i + 1);	
    	}
    	return list;
    }
    
       /* //超时
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> list = new ArrayList<Integer>();
    	int n = nums.length;
    	for (int num : nums) {
    		if (!list.contains(num))
    			list.add(num);
    	}
    	while (n > 0) {
    		if (list.contains(n)) {
    			list.remove(list.indexOf(n));
    		}
    		else
    			list.add(n);
    		--n;
    	}
    	return list;
    }
    */
}
