package com.leetcode.every_question;

import java.util.*;

public class day20210130 {
/*
 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。
你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。
假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。
当然，在你游泳的时候你必须待在坐标方格里面。
你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？

示例 1:
输入: [[0,2],[1,3]]
输出: 3
解释:
时间为0时，你位于坐标方格的位置为 (0, 0)。
此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置

示例2:
输入: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
输出: 16
解释:
 0  1  2  3  4
24 23 22 21  5
12 13 14 15 16
11 17 18 19 20
10  9  8  7  6

最终的路线用加粗进行了标记。
我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/swim-in-rising-water
*/
    public int swimInWater(int[][] grid) {
    	int count = 0;
    	int m = grid.length;
    	int n = grid[0].length;
    	List<int[]> lists = new ArrayList<int[]>();
    	for (int i = 0; i < m; i++)
    	{
    		for (int j = 0; j < n; j++)
    		{
    			int id = i*n+j;
    			if (i>0)
    				lists.add(new int [] {id - n, id, Collections.max(Arrays.asList(grid[i-1][j],grid[i][j]))});
    			if (j > 0)
    				lists.add(new int [] {id - 1, id, Collections.max(Arrays.asList(grid[i][j-1],grid[i][j]))});		
    		}
    	}
    	
    	Collections.sort(lists, new Comparator<int[]>(){
			 public int compare(int[] list1, int[] list2) {
				 return list1[2] - list2[2];
			 }
    	});
    	
    	UnionFindFor30 fa = new UnionFindFor30(m*n);
    	for (int[] list : lists) {
    		int x = list[0], y = list[1], z = list[2];
    		System.out.println(x+" , "+y+" , "+" , "+z);
    		fa.unite(x, y);
    		if(fa.connected(0, m*n-1)) {
    			count = z;
    			break;
    		}
    	}
    	return count;
    }
}

class UnionFindFor30 {
	int[] fa;
	int[] rank;
	int n;
 
	public UnionFindFor30(int n) {
	    this.n = n;
	    this.fa = new int[n];
	    this.rank = new int[n];
	    for (int i = 0; i < n; ++i) {
	        fa[i] = i;
	        rank[i] = 1;
	    }
	}
	 
	public int find(int x) {
	    return fa[x] == x ? x : (fa[x] = find(fa[x]));
	}
	 
	public boolean unite(int x, int y) {
	    x = find(x);
	    y = find(y);
	    if (x == y) {
	        return false;
	    }
	    if (rank[x] <= rank[y]) 
	    	fa[x] = y;
	    else
	    	fa[y] = x;
	    if (rank[x] == rank[y] && x != y)
	        rank[y]++;
	    return true;
	}
	public boolean connected(int x, int y) {
	    x = find(x);
	    y = find(y);
	    return x == y;
	}
}
