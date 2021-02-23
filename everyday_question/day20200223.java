package com.leetcode.every_question;

public class day20210223 {
/*
 * 1052. 爱生气的书店老板
今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。

在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。

书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。

请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 

示例：

输入：customers = [1,1,7,5,1,0,1,2], grumpy = [0,1,0,1,0,1,0,1], X = 3
输出：16             
解释：
书店老板在最后 3 分钟保持冷静。
感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 

提示：

1 <= X <= customers.length == grumpy.length <= 20000
0 <= customers[i] <= 1000
0 <= grumpy[i] <= 1
 * */
	//customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
    	int res = 0;    //不生气的人数
    	int count = 0;  //当前区间生气的人数
    	int max = 0;  //生气的最大人数
    	int n = customers.length;
    	int left = 0;
    	int right = 0;
    	while (right < n) {
    		//统计所有不生气的人数
    		if (grumpy[right] == 0)
    			res += customers[right];
    		
    		//右边结点生气的话 count加
    		else if (grumpy[right] == 1)
				count += customers[right];
			
			//当区间大于X且左边结点生气的话  count减
			if (right - left >= X) {
				if(grumpy[left] == 1)
					count -= customers[left];
    			++left;
			}
			//取最大生气的人数
			if (max < count)
				max = count;
    		++right;    			
    	}	
    	return res + max;
    }
}
