package com.leetcode.every_question;

public class day20210125 {
/*
 *在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。
 *这些字符会将方块划分为一些共边的区域。
（请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
返回区域的数目。

示例 1：
输入：
[
  " /",
  "/ "
]
输出：2
解释：2x2 网格如下：

示例 2：
输入：
[
  " /",
  "  "
]
输出：1
解释：2x2 网格如下：

示例 3：
输入：
[
  "\\/",
  "/\\"
]
输出：4
解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
2x2 网格如下：

示例 4：
输入：
[
  "/\\",
  "\\/"
]
输出：5
解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
2x2 网格如下：

示例 5：
输入：
[
  "//",
  "/ "
]
输出：3
解释：2x2 网格如下：

提示：
1 <= grid.length == grid[0].length <= 30
grid[i][j] 是 '/'、'\'、或 ' '。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/regions-cut-by-slashes
 * */
	
    public int regionsBySlashes(String[] grid) {
        /*
         * 先将n*n的矩形分成 2*n*n份，减去没有斜杠的，减去内边，加上内接矩形，即得结果
         * */
    	
    	int n = grid.length;
        
        //有多少个内接矩形
        int m = 0;   
        
        //一共分成多少个小分块
        int num = n*n*2;   
        
        //一共有多少个内边
        int link = n*(n-1)*2;  
        
        //通过并查集来计算一共有多少个内接矩形
        UnionFindFor25 fa = new UnionFindFor25((n+1)*(n+1));
        for (int i = 0; i < n; i++) {
        	char [] a = grid[i].toCharArray();
        	for (int j = 0; j < n; j++) {
        		if (a[j] == ' ') {
        			//只要有一个为空，就减少个小分块
        			num--;
        		}
        		/*将顶点联通，看看有多少个联通闭环，即内接矩形
        		 * 中心：i*n+j
        		 * 左上：i*n+j+i
        		 * 右上：i*n+j+i+1
        		 * 左下：i*n+j+i+1+n
        		 * 右下：i*n+j+i+1+n+1
        		 * 注：下边必须加括号
        		*/
        		else if (a[j] == '/') {
        			if (fa.connected((i*n+j+i+1), (i*n+j+i+1+n)))
        				m++;
        			fa.unite((i*n+j+i+1), (i*n+j+i+1+n));
        		}
        		else if (a[j] == '\\') {
        			fa.unite((i*n+j+i), (i*n+j+i+1+n+1));        			
        		}
        	}
        }
		System.out.println(m);

        return num-link+m;
    }
}

class UnionFindFor25 {
	int[] fa;
	int n;
	
	public UnionFindFor25(int n) {
	    this.n = n;
	    this.fa = new int[n];
	    for (int i = 0; i < n; ++i) {
	        fa[i] = i;
	    }
	}
	 
	public int find(int x) {
	    return fa[x] == x ? x : (fa[x] = find(fa[x]));
	}
	 
	public void unite(int x, int y) {
	    x = find(x);
	    y = find(y);
	    if (x == y) {
	        return;
	    }
	    fa[x] = y;
	}
	public boolean connected(int x, int y) {
		x = find(x);
		y = find(y);
		return x == y;
	}
}
