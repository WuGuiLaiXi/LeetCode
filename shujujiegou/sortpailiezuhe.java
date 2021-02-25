package com.shujujiegou;

public class sortpailiezuhe {
	// 排列组合 C(m,n)
    public int cSort (int m, int n) {
    	if(n == 0)
    		return 1;
    	int up = m;
    	int down = n;
    	for (int i = 1; i < n; ++i) {
    		up *= (m - i);
    		down *= (n - i);
    	} 		
    	return up / down; 
    } 
	
}
