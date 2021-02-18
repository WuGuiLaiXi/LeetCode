package com.leetcode.every_question;

public class day20210218 {
/*
 * 995. K 连续位的最小翻转次数
在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。

返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。

 

示例 1：

输入：A = [0,1,0], K = 1
输出：2
解释：先翻转 A[0]，然后翻转 A[2]。
示例 2：

输入：A = [1,1,0], K = 2
输出：-1
解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
示例 3：

输入：A = [0,0,0,1,0,1,1,0], K = 3
输出：3
解释：
翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
 

提示：

1 <= A.length <= 30000
1 <= K <= A.length
 * 
 * */
	
	
    public int minKBitFlips(int[] A, int K) {
    	int count = 0;
    	int n = A.length;
    	int dif = 0;
    	int left = 0;
    	while (left < n) {
    		if (left - K >= 0 && A[left - K] > 1) {
    			A[left - K] -= 2;
    			--dif;
    		}
    		if (dif % 2 == A[left]) {
    			if (left + K - 1 >= n )
    				return -1;
    			A[left] += 2;
    			++dif;
    			++count;
    		}
    		++left;
    	}
    	return count;
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	/*
    	 * 
		超时运行
    	int count = 0;
    	int n = A.length;
    	int left = 0;
    	while (left + K <= n) {
    		if (A[left] == 1) {
    			++left;
    			continue;
    		}
    		else if (A[left] == 0) {
    			for (int i = 0; i < K; ++i) {
    				if (A[left + i] == 0)
    					A[left + i] = 1;
    				else
    					A[left + i] = 0;
    			}
    			++left;
    			++count;
    		}
    	}
    	for (int i = left; i < n; ++i) {
    		if (A[i] == 0) {
    			count = -1;
    			break;
    		}			
    	}
    	return count;
    	
    	    	 
    	 */
    }
}
