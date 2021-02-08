package com.leetcode.every_question;

public class day20210208 {
/*
978. 最长湍流子数组

当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
返回 A 的最大湍流子数组的长度。

示例 1：
输入：[9,4,2,10,7,8,8,1,9]
输出：5
解释：(A[1] > A[2] < A[3] > A[4] < A[5])

示例 2：
输入：[4,8,12,16]
输出：2

示例 3：
输入：[100]
输出：1

提示：
1 <= A.length <= 40000
0 <= A[i] <= 10^9
 * *///0 1 2 3  4 5 6 7 8
	// 9,4,2,10,7,8,8,1,9
	// L
	//   R
	// 奇数 大   偶数 小  
	// 偶数 大   奇数小
	//如果 前边大于 那随后的肯定是小于 反之 如果 当前小于 那随后一定大于 ，所以设置个 参数 去记录 下一步是 大于还是小于 ，用来统计最大长度
    public int maxTurbulenceSize(int[] arr) {
    	int count = 0;
    	int right = 0;
    	int maxCount = 0;
    	char flag = '=';
    	while (right < arr.length - 1) {
    		if((flag == '>'||flag == '=') && arr[right] > arr[right + 1]) {
    			right++;
    			count++;
    			flag = '<';
    		}
    		else if ((flag == '<'||flag == '=') && arr[right] < arr[right + 1]) {
    			right++;
    			count++;
    			flag = '>';
    		}
    		else if (arr[right] == arr[right + 1]) {
    			count = 0;
    			flag = '=';
    			right++;
    		}
    		else {
    			count = 0;
    			flag = '=';
    		}
    		if(count > maxCount)
    			maxCount = count;
    	}
    	return maxCount+1;
    }
	
}
