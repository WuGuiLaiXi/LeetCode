package com.leetcode.every_question;

public class day20210303 {
/*
 * 338. 比特位计数
给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

示例 1:

输入: 2
输出: [0,1,1]
示例 2:

输入: 5
输出: [0,1,1,2,1,2]
进阶:

给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
要求算法的空间复杂度为O(n)。
你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * */
    public int[] countBits(int num) {
        //动态规划-最高有效位
    	int[] res = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            res[i] = res[i - highBit] + 1;
        }
        return res;

    	
    	
    	/*
    	int[] res = new int[num + 1];
    	for (int i = 0; i <= num; ++i) {
    		String s = Integer.toBinaryString(i);
            // 定义一个count来存放字符串出现的次数
            int count = 0 ;
            // 调用String类的indexOf(String str)方法，返回第一个相同字符串出现的下标
            while (s.indexOf('1') != -1){
                count ++ ;
                int index = s.indexOf('1');
                //将长的那个字符串做截取
                s = s.substring(index+1);
            }
            res[i] = count;
    	}
    	return res;
    	*/
    	
    }
}
