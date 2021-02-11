class KthLargest {
    //官方解析
    //第K大 建立 一个小顶堆，只要堆元素大于K就弹出 堆顶元素，最后剩下的堆顶元素就是 第K大元素
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);      
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {     // 维持 队列的大小与kk值相等
            pq.poll();           //弹出元素   
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
