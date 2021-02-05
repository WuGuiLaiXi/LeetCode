package com.leetcode.every_question;

public class day20210205 {
/*
 * 给你两个长度相同的字符串，s 和 t。
将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。

示例 1：
输入：s = "abcd", t = "bcdf", cost = 3
输出：3
解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。

示例 2：
输入：s = "abcd", t = "cdef", cost = 3
输出：1
解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。

示例 3：
输入：s = "abcd", t = "acde", cost = 0
输出：1
解释：你无法作出任何改动，所以最大长度为 1。
 

提示：
1 <= s.length, t.length <= 10^5
0 <= maxCost <= 10^6
s 和 t 都只含小写英文字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/get-equal-substrings-within-budget
 * */
	//s = "abcd", t = "cdef", cost = 3
	/*
	 *  String s = "abcd";
		String t = "aghc";
	 * */
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
	
    public int equalSubstring(String s, String t, int maxCost) {
        char[] chs = s.toCharArray();
    	char[] cht = t.toCharArray();
        int n = chs.length;
    	int cost = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (chs[right] - cht[right] > 0)
                cost += (chs[right] - cht[right]);
            else
                cost -= (chs[right] - cht[right]);
    		if (cost > maxCost) {
                if (chs[left] - cht[left] > 0)
                    cost -= (chs[left] - cht[left]);
                else
                    cost += (chs[left] - cht[left]);
    			left++;
    		}
            right++;
        }
    	return n - left;
    }
}
