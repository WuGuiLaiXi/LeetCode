package com.leetcode.every_question;

import java.util.Arrays;


public class day20210203 {
/*
 * 中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 * 
例如：
[2,3,4]，中位数是 3
[2,3]，中位数是 (2 + 3) / 2 = 2.5
给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。
你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。

示例：
给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。

窗口位置                      中位数
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7      -1
 1  3 [-1  -3  5] 3  6  7      -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。

提示：
你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。
与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sliding-window-median
 * */
	
    public double[] medianSlidingWindow(int[] nums, int k) {
    	int n = nums.length;
    	int m = (k-1)/2;
    	int left;
    	double[] res = new double[n];
    	int[] subnums = new int[k];				
    	System.arraycopy(nums, 0, subnums, 0, k);	
    	ListNode a = new ListNode();
    	
    	if (k % 2 == 0)	{
    		for (left = 0; left < n-k+1; left++) {
    			System.arraycopy(nums, left, subnums, 0, k);				
    			Arrays.sort(subnums);				
    			res[left] = ((double)subnums[m] + (double)subnums[m+1]) / 2;
    		}    		
    	}
    	else {
    		for (left = 0; left < n-k+1; left++) {
    			System.arraycopy(nums, left, subnums, 0, k);
    			Arrays.sort(subnums);
    			res[left] = subnums[m];
    		}    			
    	}
    	return java.util.Arrays.copyOf(res, left);
    }

    /*基于 treeSet 他人版本
     * 
     *     public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n-k+1];
        Set<int[]> set = new TreeSet<>((a, b)->a[0]==b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        for(int i=0; i<k; i++) set.add(new int[]{nums[i], i});        
        for(int i=k, j=0; i<n; i++, j++){
            ans[j] = findMid(set);
            set.add(new int[]{nums[i], i});
            set.remove(new int[]{nums[i-k], i-k});
        }    
        ans[n-k] = findMid(set);
        return ans;
    }
    
    double findMid(Set<int[]> set){
        int mid = (set.size() - 1) / 2;
        var it = set.iterator();
        while(mid-->0) it.next();
        return set.size()%2 == 0 ? ((double)it.next()[0] + it.next()[0]) / 2 : it.next()[0];
    } 
     * */
}

class ListNode {
	
	private int count;		//代表链表程度
	private Node root;		//标识根节点
	
	//链接点类,内部方法实现，外部使用
	private class Node{
		
		private int data;		//数据信息
		private Node next;	//下一个节点引用
		
		public Node(int data) {
			this.data = data;
		}
		
		//添加节点
		private void add(int data){
			if(this.next == null){
				this.next = new Node(data);		//如果当前节点的next为null,直接创建一个新的节点
			}else {
				this.next.add(data);			//否则进行递归调用，直到最后在某个为空的节点创建一个新节点
			}
		}
		
		//删除节点2 
		public void remove(Node previous, int data){
			if(this.data == data){
				previous.next = this.next;
				this.next = null;
				ListNode.this.count--;
				return ;
			}else{
				if(this.next != null){
					this.next.remove(this,data);
				}else{
					return;
				}
			}
		}
	}
	
	public ListNode() {
		
	}
	
	//检查链表是否为空
	public boolean isEmpty(){
		if(count == 0 || this.root == null){
			return true;
		}else{
			return false;
		}
	}
	
	//获取链表的长度
	public int size(){
		return this.count;
	}
	
	//添加
	public void add(int data){
		if(this.isEmpty()){ //如果链表为空，新建一个节点
			this.root = new Node(data);
		}else{
			this.root.add(data);
		}
		this.count++;
	}
	
	//根据传入的数值删除
	public void remove(int data){
		if(this.isEmpty()){
			return;
		}
		if(this.root.data == data){	//如果删除的正好是根节点
			Node temp = this.root;
			this.root = this.root.next;
			temp.next = null;
			this.count--;
			return ;
		}else{
			this.root.remove(this.root, data);
		}
	}
}


