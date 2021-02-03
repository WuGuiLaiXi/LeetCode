package com.shujujiegou;

//并查集
public class bingchaji {
	private int fa[] = new int[5005];
	private int rank[] = new int[5005];
	
	//生成结点,并记录每个节点的秩
	public void init(int n)
	{
		for (int i = 1; i <= n; ++i)
		{
			fa[i] = i;
			rank[i] = 1;
		}
	}
	
	//查找父节点
	public int find(int x)
	{
		return x == fa[x] ? x :(fa[x] = find(fa[x]));
	}
	
	//合并，首先查找父节点再进行秩的判断秩大的当父节点，如果相等 秩加1
	public void merge(int i, int j)
	{
		int x = find(i), y = find(j);
		if(rank[x] <= rank[y])
			fa[x] = y;
		else
			fa[y] = x;
		if(rank[x] == rank[y] && x !=y)
			rank[y]++;
	}
}
