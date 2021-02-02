package com.leetcode.every_question;

public class day20210202 {
/*
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
 * 在执行上述操作后，找到包含重复字母的最长子串的长度。
        注意：字符串长度 和 k 不会超过 104。

示例 1：
输入：s = "ABAB", k = 2
输出：4
解释：用两个'A'替换为两个'B',反之亦然。

示例 2：
输入：s = "AABABBA", k = 1
输出：4
解释：
将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
子串 "BBBB" 有最长重复字母, 答案为 4。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * */
	/* A B C B E A E E A C B   k = 2
	   0 1 2 3 4 5 6 7 8 9 10
	 * 间距等于 1 或间距等于 2
	 * */
    public int characterReplacement(String s, int k) {
    	
    	char[] ch = s.toCharArray();
    	if(ch.length == k)
    		return k;
    	int count = k+1;
    	System.out.println("ch.length:"+ch.length);
    	for(int i = 0; i < (ch.length - k); i++) {
    		char start = ch[i];
    		int n = k+1;
    		System.out.println("start"+i+":"+start+",");
    		for (int j = 1; j < n; j++) {
    			System.out.printf("n1:"+n+",");
    			if((i+j) > (ch.length - 1))
    				break;
    			System.out.printf("i+j:"+(i+j)+",");
    			System.out.println("后ch["+(i+j)+"]:"+ch[i+j]+";");
    			if (ch[i+j] == start) 				
    				n++;
    		}
    		while((i+n) < ch.length) {
    			System.out.printf("后ch["+n+"]:"+ch[n]);
    			if (ch[n+i] == start)
    				n++;
    			else
    				break;
    		} 
    		if (n > count)
    		{
    			count = n;
    		}
    		System.out.println("n2:"+n);
    		System.out.printf("\n");
    	}
    	if (count > ch.length)
    		count = ch.length;
    	return count;
    	
    	
    	/*
    	//官方双指针滑动 "ABCBACBEAEE"
        int[] map = new int[26];
    	char[] ch = s.toCharArray();
    	int left = 0; 
    	int	right;
    	int count = 0;
    	for (right = 0; right < ch.length; right++) {
    		int id = ch[right] - 'A';
    		map[id]++;  //每次记录一些相同的
    		count = Math.max(count, map[id]);
    		if (right - left + 1 > count + k) {
    			map[ch[left] - 'A']--;
    			left++;
    		}
    	}
    	return ch.length - left;
    	*/
    }
}
