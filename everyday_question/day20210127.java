public class day20200127 {
	/*
Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3  种类型的边：

类型 1：只能由 Alice 遍历。
类型 2：只能由 Bob 遍历。
类型 3：Alice 和 Bob 都可以遍历。
给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。

返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。


提示：

1 <= n <= 10^5
1 <= edges.length <= min(10^5, 3 * n * (n-1) / 2)
edges[i].length == 3
1 <= edges[i][0] <= 3
1 <= edges[i][1] < edges[i][2] <= n
所有元组 (typei, ui, vi) 互不相同

	 * */
	
	//4
	//[[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
	
	 public int maxNumEdgesToRemove(int n, int[][] edges) {
	        UnionFind uda = new UnionFind(n+1);
	        UnionFind udb = new UnionFind(n+1);
	        int count = 0;
	        
	        for (int [] edge : edges)
	        {
	        	if(edge[0] == 3)
	        		if(!uda.merge(edge[1], edge[2]))
	        			count++;
	        		else
	        			udb.merge(edge[1], edge[2]);
	        }
	        for (int [] edge : edges)
	        {
	        	if(edge[0] == 1){
	        		if(!uda.merge(edge[1], edge[2]))
	        			count++;
	            }
	        	else if(edge[0] == 2){
	        		if(!udb.merge(edge[1], edge[2]))
	        			count++;
	            }
	        }
	        if(uda.setCount !=2 || udb.setCount !=2)
	        	return -1;

	        return count;
	    }
}

//并查集模板
class UnionFind{
	int[] fa;
	int[] rank;
	int n;
	int setCount;
	
	
	//生成结点,并记录每个节点的秩
	public UnionFind(int n)
	{
		this.n = n;
		this.setCount = n;
		this.fa = new int[n];
		this.rank = new int[n];
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
	public boolean merge(int x, int y)
	{
		x = find(x);
		y = find(y);
		if(x == y)
			return false;
		if(rank[x] <= rank[y])
			fa[x] = y;
		else
			fa[y] = x;
		if(rank[x] == rank[y] && x !=y)
			rank[y]++;
		--setCount;
		return true;
	}
	
    public boolean connected(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }
	
}
