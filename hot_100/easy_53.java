package com.leetcode.hot_100;

public class easy_53 {
/*
 * 53. 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例 1：
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

示例 2：
输入：nums = [1]
输出：1

示例 3：
输入：nums = [0]
输出：0

示例 4：
输入：nums = [-1]
输出：-1

示例 5：
输入：nums = [-100000]
输出：-100000
 

提示：
1 <= nums.length <= 3 * 104
-105 <= nums[i] <= 105
 
进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * */
	//-2,1,-3,4,-1,2,1,-5,4
	//以当前的数 来看，我自己加上前面的 
    public int maxSubArray(int[] nums) {
    	int preNum = 0;
    	int max = nums[0];
    	for (int a : nums) {
    		// 挑选最大的，在后面用时，只有前面的和最大 我才能保证 在和我结合 有可能最大
    		/*
    		 *  如果 preNum > 0，则说明 preNum 对结果有增益效果，则 preNum + a 保留并加上当前遍历数字
				如果 preNum <= 0，则说明 preNum 对结果无增益效果，需要舍弃，则 preNum 直接更新为当前遍历数字
				每次比较 preNum 和 max的大小，将最大值置为max，遍历结束返回结果

    		 * */
    		preNum = preNum + a < a ? a : preNum + a;
    		if(max < preNum)
    			max = preNum;
    	}
    	return max;
    }
/*
 * 方法二：分治
思路和算法

这个分治方法类似于「线段树求解最长公共上升子序列问题」的 pushUp 操作。 也许读者还没有接触过线段树，没有关系，方法二的内容假设你没有任何线段树的基础。当然，如果读者有兴趣的话，推荐阅读线段树区间合并法解决多次询问的「区间最长连续上升序列问题」和「区间最大子段和问题」，还是非常有趣的。

我们定义一个操作 get(a, l, r) 表示查询 aa 序列 [l,r][l,r] 区间内的最大子段和，那么最终我们要求的答案就是 get(nums, 0, nums.size() - 1)。如何分治实现这个操作呢？对于一个区间 [l,r][l,r]，我们取 m = \lfloor \frac{l + r}{2} \rfloorm=⌊ 
2
l+r
​	
 ⌋，对区间 [l,m][l,m] 和 [m+1,r][m+1,r] 分治求解。当递归逐层深入直到区间长度缩小为 11 的时候，递归「开始回升」。这个时候我们考虑如何通过 [l,m][l,m] 区间的信息和 [m+1,r][m+1,r] 区间的信息合并成区间 [l,r][l,r] 的信息。最关键的两个问题是：

我们要维护区间的哪些信息呢？
我们如何合并这些信息呢？
对于一个区间 [l,r][l,r]，我们可以维护四个量：

\textit{lSum}lSum 表示 [l,r][l,r] 内以 ll 为左端点的最大子段和
\textit{rSum}rSum 表示 [l,r][l,r] 内以 rr 为右端点的最大子段和
\textit{mSum}mSum 表示 [l,r][l,r] 内的最大子段和
\textit{iSum}iSum 表示 [l,r][l,r] 的区间和
以下简称 [l,m][l,m] 为 [l,r][l,r] 的「左子区间」，[m+1,r][m+1,r] 为 [l,r][l,r] 的「右子区间」。我们考虑如何维护这些量呢（如何通过左右子区间的信息合并得到 [l,r][l,r] 的信息）？对于长度为 11 的区间 [i, i][i,i]，四个量的值都和 \textit{nums}[i]nums[i] 相等。对于长度大于 11 的区间：

首先最好维护的是 \textit{iSum}iSum，区间 [l,r][l,r] 的 \textit{iSum}iSum 就等于「左子区间」的 \textit{iSum}iSum 加上「右子区间」的 \textit{iSum}iSum。
对于 [l,r][l,r] 的 \textit{lSum}lSum，存在两种可能，它要么等于「左子区间」的 \textit{lSum}lSum，要么等于「左子区间」的 \textit{iSum}iSum 加上「右子区间」的 \textit{lSum}lSum，二者取大。
对于 [l,r][l,r] 的 \textit{rSum}rSum，同理，它要么等于「右子区间」的 \textit{rSum}rSum，要么等于「右子区间」的 \textit{iSum}iSum 加上「左子区间」的 \textit{rSum}rSum，二者取大。
当计算好上面的三个量之后，就很好计算 [l,r][l,r] 的 \textit{mSum}mSum 了。我们可以考虑 [l,r][l,r] 的 \textit{mSum}mSum 对应的区间是否跨越 mm——它可能不跨越 mm，也就是说 [l,r][l,r] 的 \textit{mSum}mSum 可能是「左子区间」的 \textit{mSum}mSum 和 「右子区间」的 \textit{mSum}mSum 中的一个；它也可能跨越 mm，可能是「左子区间」的 \textit{rSum}rSum 和 「右子区间」的 \textit{lSum}lSum 求和。三者取大。
这样问题就得到了解决。

代码

C++C#JavaJavaScriptGolangC

class Solution {
    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }
}
复杂度分析

假设序列 aa 的长度为 nn。

时间复杂度：假设我们把递归的过程看作是一颗二叉树的先序遍历，那么这颗二叉树的深度的渐进上界为 O(\log n)O(logn)，这里的总时间相当于遍历这颗二叉树的所有节点，故总时间的渐进上界是 O(\sum_{i=1}^{\log n} 2^{i-1})=O(n)O(∑ 
i=1
logn
​	
 2 
i−1
 )=O(n)，故渐进时间复杂度为 O(n)O(n)。
空间复杂度：递归会使用 O(\log n)O(logn) 的栈空间，故渐进空间复杂度为 O(\log n)O(logn)。
题外话
「方法二」相较于「方法一」来说，时间复杂度相同，但是因为使用了递归，并且维护了四个信息的结构体，运行的时间略长，空间复杂度也不如方法一优秀，而且难以理解。那么这种方法存在的意义是什么呢？

对于这道题而言，确实是如此的。但是仔细观察「方法二」，它不仅可以解决区间 [0, n-1][0,n−1]，还可以用于解决任意的子区间 [l,r][l,r] 的问题。如果我们把 [0, n-1][0,n−1] 分治下去出现的所有子区间的信息都用堆式存储的方式记忆化下来，即建成一颗真正的树之后，我们就可以在 O(\log n)O(logn) 的时间内求到任意区间内的答案，我们甚至可以修改序列中的值，做一些简单的维护，之后仍然可以在 O(\log n)O(logn) 的时间内求到任意区间内的答案，对于大规模查询的情况下，这种方法的优势便体现了出来。这棵树就是上文提及的一种神奇的数据结构——线段树。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
来源：力扣（LeetCode）
 * 
 * */
}
