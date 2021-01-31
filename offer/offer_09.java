package com.leetcode.offer;

import java.util.LinkedList;

public class offer_09 {

	/*
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

示例 1：
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]

示例 2：
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]

提示：
1 <= values <= 10000
最多会对 appendTail、deleteHead 进行 10000 次调用

作者：Krahets
链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5d3i87/
来源：力扣（LeetCode）
	 * */
	
}

class CQueue {
    LinkedList<Integer> A,B;
    public CQueue() {
    	A = new LinkedList<Integer>();
    	B = new LinkedList<Integer>();
    }
    
    public void appendTail(int value) {
    	A.addLast(value);
    }
    
    public int deleteHead() {
    	int pop = -1;
    	if(B.peekLast() != null) {
    		pop = B.peekLast();
    		B.removeLast();
    	}
    	else if (B.peekLast() == null && A.peekLast() != null) {
    		while (A.peekLast() != null) {
    			B.addLast(A.peekLast());
    			A.removeLast();
    		}
    		pop = B.peekLast();
    		B.removeLast();
    	}
    	return pop;
    	
    }
}
