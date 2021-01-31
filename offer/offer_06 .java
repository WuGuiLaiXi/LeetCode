package com.leetcode.offer;

import java.util.LinkedList;

public class offer_06 {
/*
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：
输入：head = [1,3,2]
输出：[2,3,1]
 
限制：
0 <= 链表长度 <= 10000

作者：Krahets
链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5dt66m/
来源：力扣（LeetCode）
 * */
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public int[] reversePrint(ListNode head) {
        if (head == null)
            return new int[0];
        int n = 1;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addLast(head.val);
        while(head.next != null) {
            stack.addLast(head.next.val);
            head = head.next;
            n++;
        }
        int[] str = new int[n];
        for (int i = 0; i < n; i++)
            str[i] = stack.removeLast();
        return str;
    }
	
}
