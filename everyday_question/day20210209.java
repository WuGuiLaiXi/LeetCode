package com.leetcode.every_question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class day20210209 {

/*
* 992. K 个不同整数的子数组
给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
（例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
返回 A 中好子数组的数目。

示例 1：
输入：A = [1,2,1,2,3], K = 2
输出：7
解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].

示例 2：
输入：A = [1,2,1,3,4], K = 3
输出：3
解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 

提示：
1 <= A.length <= 20000
1 <= A[i] <= A.length
1 <= K <= A.length
* */
	
	//A = [1,2,1,2,3], K = 2
	//A = {2,1,1,1,2};//{1,2,1,3,4};//{1,2,1,2,3};////
    public int subarraysWithKDistinct(int[] A, int K) {
    	return atMostK(A,K) - atMostK(A, K - 1);
    	
    	
    	
    	/*
    	 * 官方解法
    	int n = A.length;
        int[] num1 = new int[n + 1];
        int[] num2 = new int[n + 1];
        int tot1 = 0, tot2 = 0;
        int left1 = 0, left2 = 0, right = 0;
        int count = 0;
        while (right < n) {
            if (num1[A[right]] == 0) {
                tot1++;
            }
            num1[A[right]]++;
            if (num2[A[right]] == 0) {
                tot2++;
            }
            num2[A[right]]++;
            while (tot1 > K) {
                num1[A[left1]]--;
                if (num1[A[left1]] == 0) {
                    tot1--;
                }
                left1++;
            }
            while (tot2 > K - 1) {
                num2[A[left2]]--;
                if (num2[A[left2]] == 0) {
                    tot2--;
                }
                left2++;
            }
            count += left2 - left1;
            right++;
        }
        return count;
        */
    	
    	
    	
    	/*
    	int count = 0;
        int n = A.length;
        int left = 0;
        int right = 0;
        int num = 0;
        Set<Integer> seta = new HashSet<Integer>();
        while (left <= n - K) {
        	System.out.println("left  A["+left+"]:"+A[left]);
        	while (right < n) {
        		System.out.println("right  A["+right+"]:"+A[right]);
        		System.out.println("前num:"+num);
        		if(!seta.contains(A[right]) && num < K) {
        			seta.add(A[right]);
        			num++;
        		}
        		else if (seta.contains(A[right]) && num == K) {
        			count++;        			
        		}
        		else if (!seta.contains(A[right]) && num == K) {
        			break;
        		}
        		right++;
        		System.out.println("count:"+count);
        	}
        	System.out.println("后num:"+num);
        	if(num == K)
        		count++;
 
        	left++;
        	right = left;
        	seta.clear();
        	num = 0;
        }   
        return count;
        */
        
    }
    /**
     * 最多 K 个不同整数组成的子数组的个数
     * */
    //1,2,1,2,3  K = 2
    public int atMostK(int[] A, int K) {
    	int count = 0;
    	int n = A.length;
    	int[] arr = new int[n+1];
    	int left = 0;
    	int right = 0;
    	int df = 0;
    	while (right < n) {
    		if (arr[A[right]] == 0)
    			df++;
    		arr[A[right]]++;
    		while (df > K) {
    			arr[A[left]]--;
    			if (arr[A[left]] == 0)
    				df--;
    			left++;
    		}
    		//如果求由 K 个不同整数组成的最长子数组的长度
    		//则 count = Math.max(count, right - left +1);
    		count += right - left +1;
    		right++;
    	}
    	return count;
    }
}
