package com.leetcode.every_question;

import java.util.HashSet;
import java.util.Set;

public class day20210201 {
/*
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
如果有多个答案，你可以返回其中任何一个。保证答案存在。

示例 1：
输入：A = [1,1], B = [2,2]
输出：[1,2]

示例 2：
输入：A = [1,2], B = [2,3]
输出：[1,2]

示例 3：
输入：A = [2], B = [1,3]
输出：[2,3]

示例 4：
输入：A = [1,2,5], B = [2,4]
输出：[5,4]
 

提示：
1 <= A.length <= 10000
1 <= B.length <= 10000
1 <= A[i] <= 100000
1 <= B[i] <= 100000
保证爱丽丝与鲍勃的糖果总量不同。
答案肯定存在。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fair-candy-swap
 * */
	
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] change = new int[2];
        int numa = 0, numb = 0;
        int dis = 0;
        Set<Integer> seta = new HashSet<Integer>();
        for(int a : A){
        	seta.add(a);
        	numa += a;
        }
        for(int b : B){
        	numb += b;
        }
        dis = (numa - numb)/2;
        for(int b : B){
        	int a = b + dis;
        	if(seta.contains(a)){
        		change[0] = a;
        		change[1] = b;
        	}       		
        }
        return change;
    }

/*
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] change = new int[2];
        int numa = 0, numb = 0, changea = 0;
        for(int a : A){
        	numa += a;
        }
        for(int b : B){
        	numb += b;
        }
        changea = ((numa+numb)/2)-numa;
        if(changea > 0)
        {
        	int flag = -1;
            for(int a : A){
            	if(flag == 0)
            		break;
            	for(int b : B){
            		if((b - a) == changea){
            	        change[0] = a;
            	        change[1] = b;
            	        flag = 0;
            	        break;
            		}		
            	}
            }
        }
        else
        {
        	int flag = -1;
            for(int a : A){
            	if(flag == 0)
            		break;
            	for(int b : B){
            		if((a - b) == (-changea)){
            	        change[0] = a;
            	        change[1] = b;
            	        flag = 0;
            	        break;
            		} 			
            	}
            }
        	
        }
        return change;
    }
*/
}
