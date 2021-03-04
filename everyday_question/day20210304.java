package com.leetcode.every_question;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class day20210304 {
/*
 * 
 * 354. 俄罗斯套娃信封问题
给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。

请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。

说明:
不允许旋转信封。

示例:

输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
输出: 3 
解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * */
	
    public int maxEnvelopes(int[][] envelopes) {
    	int n = envelopes.length;
    	if (n == 0)
    		return 0;

    	Arrays.sort(envelopes, new Comparator<int[]>() {
    		public int compare(int[] o1, int[] o2) {
    			if (o1[0] == o2[0]) return o2[1] - o1[1];          //第一位升序 第二位降序
    			return o1[0] - o2[0];
    		}
    	});
    	for (int i = 0; i < envelopes.length; ++i) {
    		for (int j = 0; j < envelopes[0].length; ++j) {
    			System.out.print(envelopes[i][j]+",");
    		}
    		System.out.println();
    	}
        ArrayList<Integer> f = new ArrayList<Integer>();
        f.add(envelopes[0][1]);
        for (int i = 1; i < n; ++i) {
            int num = envelopes[i][1];
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }
    
    //二分查找
    public int binarySearch(ArrayList<Integer> f, int target) {
        int low = 0, high = f.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (f.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
