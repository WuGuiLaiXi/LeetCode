package com.leetcode.every_question;

import java.util.*;

public class day20210129 {
/*
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。
 * 一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。
 * 你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
请你返回从左上角走到右下角的最小 体力消耗值 。
示例 1：
输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
输出：2
解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
示例 2：
输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
输出：1
解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
示例 3：
输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
输出：0
解释：上图所示路径不需要消耗任何体力。
 
提示：
rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106
 * */

	 public int minimumEffortPath(int[][] heights) {
		 int count = 0;
		 int m = heights.length;
		 int n = heights[0].length;
		 List<int[]> lists = new ArrayList<int[]>();
		 for(int i = 0; i < m; i++)
		 {
			 for(int j = 0; j< n; j++)
			 {
				 int id = i*n+j;
				 if(i>0)
					 lists.add(new int[] {id - n, id, Math.abs(heights[i - 1][j] - heights[i][j])});	//Math.abs 取绝对值
				 if(j>0)
					 lists.add(new int[] {id - 1, id, Math.abs(heights[i][j - 1] - heights[i][j])});
			 }
		 }
		 //以lists中的第三个栏位排序
		 Collections.sort(lists, new Comparator<int[]>() {
			 public int compare(int[] list1, int[] list2) {
				 return list1[2] - list2[2];
			 }
		 });
		 UnionAndFind fa = new UnionAndFind(m * n);
		 for (int[] list : lists) { 
			 int x = list[0], y = list[1], v = list[2];
	         fa.unite(x, y);
	         //一直遍历，一直添加，只要有右下角栏位那就终止，当前的值为最小的
	         if (fa.connected(0, m * n - 1)) {
	        	 count = v;
	        	 break;	        	 
	         }
		 } 
		 return count;
	 }
}	

class UnionAndFind{
	int[] fa;
	int[] rank;
	int n;
	//当前连通分量的数目
	int setCount;
	
	public UnionAndFind(int n) {
		this.n = n;
		this.setCount = n;
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
		setCount--;
		return true;
	}
	 public boolean connected(int x, int y) {
	     x = find(x);
	     y = find(y);
	     return x == y;
	 }
}



/*	
    public int minimumEffortPath(int[][] heights) {
  
    	int count = 0;
		@SuppressWarnings("rawtypes")
		ArrayList<Map> list  = new ArrayList<Map>();
		for(int i = 0; i < heights.length; i++)
		{
			for(int j = 0; j< heights[i].length; j++)
			{
				Map<String, String> map =  new HashMap<String, String>();
				if(i == 0 && j == 0) {
					map.put("up", "N");
					map.put("down", "Y");
					map.put("left", "N");
					map.put("right", "Y");			
				}
				else if(i == 0 && j == heights[i].length-1) {
					map.put("up", "N");
					map.put("down", "Y");
					map.put("left", "N");
					map.put("right", "N");	
				}
				else if(i == 0 && (j != 0 && j !=heights[i].length-1)) {
					map.put("up", "N");
					map.put("down", "Y");
					map.put("left", "N");
					map.put("right", "Y");	
				}
				else if(i == heights.length-1 && j == 0)
				{
					map.put("up", "N");
					map.put("down", "N");
					map.put("left", "N");
					map.put("right", "Y");
				}
				else if(i == heights.length-1 && j == heights[i].length-1)
				{
					map.put("up", "N");
					map.put("down", "N");
					map.put("left", "N");
					map.put("right", "N");
				}
				else if(i == heights.length-1 && (j != heights[i].length-1 && j != 0))
				{
					map.put("up", "Y");
					map.put("down", "N");
					map.put("left", "N");
					map.put("right", "Y");
				}
				else if(j == 0 && (i != heights.length-1 && i != 0))
				{
					map.put("up", "N");
					map.put("down", "Y");
					map.put("left", "N");
					map.put("right", "Y");
				}
				else if(j == heights[i].length && (i != heights.length-1 && i != 0))
				{
					map.put("up", "N");
					map.put("down", "Y");
					map.put("left", "Y");
					map.put("right", "N");
				}
				else {
					map.put("up", "Y");
					map.put("down", "Y");
					map.put("left", "Y");
					map.put("right", "Y");
				}
				map.put("position_id", String.valueOf(i)+String.valueOf(j));
				list.add(map);
			}
		}

    	return count ;
    }
}

class transforListMap {
	@SuppressWarnings("rawtypes")
	public List<Map> sort(int[][] heights)
	{
		ArrayList<Map> list  = new ArrayList<Map>();
		for(int i = 0; i < heights.length; i++)
		{
			Map<String, String> map =  new HashMap<String, String>();
			for(int j = 0; j< heights[i].length; j++)
			{
				map.put("position_id", String.valueOf(i)+String.valueOf(j));
				map.put("up", "");
				map.put("down", "");
				map.put("left", "");
				map.put("right", "");
				System.out.println("map:"+map);
			}
			list.add(map);
		}
		return list;
	}
	
}
	*/
