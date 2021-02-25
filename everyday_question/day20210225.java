package com.leetcode.every_question;

public class day20210225 {
/*
 * 867. 转置矩阵
给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。

矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。



 

示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[[1,4,7],[2,5,8],[3,6,9]]
示例 2：

输入：matrix = [[1,2,3],[4,5,6]]
输出：[[1,4],[2,5],[3,6]]
 

提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 1000
1 <= m * n <= 105
-109 <= matrix[i][j] <= 109
 * 
 * */
	
    public int[][] transpose(int[][] matrix) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	//建立一个输出数组，行和列转换
    	int[][] res = new int[n][m];
    	//行变成列，列变成行
    	for (int i = 0; i < m; ++i) {
    		for (int j = 0; j < n; ++j) {
    			res[j][i] = matrix[i][j];
    		}
    	}
    	return res;
    }
}
