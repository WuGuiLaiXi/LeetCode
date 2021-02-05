package com.leetcode.hot_100;

public class easy_21 {
/*
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例 1：
输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]

示例 2：
输入：l1 = [], l2 = []
输出：[]

示例 3：
输入：l1 = [], l2 = [0]
输出：[0]
 

提示：
两个链表的节点数目范围是 [0, 50]
-100 <= Node.val <= 100
l1 和 l2 均按 非递减顺序 排列

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 
 * */
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	//l1 = [1,2,4], l2 = [3,4,5]
	// res  1 
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		//ListNode res = new ListNode(l1.val,null);
		ListNode res = new ListNode();
		if(l1.val <= l2.val) {
			res = l1;
			while (l1.next != null && l1.val > l2.val) {
				while(l1.val <= l2.val) {
					l1.next = new ListNode(l2.val,l1.next);
					l2 = l2.next;
					l1 = l1.next;
				}
				l1 = l1.next;
			}	
		}
		else {
			res = l2;
			while (l2.next != null && l2.val > l1.val) {
				while(l2.val <= l1.val) {
					l2.next = new ListNode(l1.val,l2.next);
					l1 = l1.next;
					l2 = l2.next;
				}
				l2 = l2.next;
			}		
		}
		return res;
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }	
}
