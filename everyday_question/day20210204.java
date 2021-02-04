package com.leetcode.every_question;

public class day20210204 {
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
