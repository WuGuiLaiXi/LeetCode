package com.leetcode.every_question;

public class day20210326 {
/*
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。

返回同样按升序排列的结果链表。

 

示例 1：


输入：head = [1,1,2]
输出：[1,2]
示例 2：


输入：head = [1,1,2,3,3]
输出：[1,2,3]
 

提示：

链表中节点数目在范围 [0, 300] 内
-100 <= Node.val <= 100
题目数据保证链表已经按升序排列
 * */
	
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
    	ListNode q = head;
    	ListNode p = head.next;
    	while (p != null) {
    		if (q.val == p.val) {
    			q.next = p.next;
    			p = q.next;
    		}
    		else {
    			q = p;
    			p = p.next;
    		}
    	}
    	return head;
    }


    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode() {}
    	ListNode(int val) { this.val = val; }
    	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


