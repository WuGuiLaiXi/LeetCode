package com.leetcode.offer;

public class offer_05 {
/*
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 

示例 1：
输入：s = "We are happy."
输出："We%20are%20happy."

限制：
0 <= s 的长度 <= 10000

作者：Krahets
链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/50ywkd/
来源：力扣（LeetCode）
 * */
	    
	public String replaceSpace(String s) {    
		return s.replace(" ", "%20");   
	}
}
