public class easy_1 {
  /*  
	给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
	你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
	你可以按任意顺序返回答案。	 

	示例 1：

	输入：nums = [2,7,11,15], target = 9
	输出：[0,1]
	解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
	示例 2：

	输入：nums = [3,2,4], target = 6
	输出：[1,2]
	示例 3：

	输入：nums = [3,3], target = 6
	输出：[0,1]
	 
	提示：
	2 <= nums.length <= 103
	-109 <= nums[i] <= 109
	-109 <= target <= 109
	只会存在一个有效答案
*/
	public int[] twoSum(int[] nums, int target) {
		int[] targets = new int[2];
		for(int i = 0; i < nums.length; i++)
		{
			for(int j = i+1; j < nums.length; j++)
			{
				if((nums[i]+nums[j]) == target)
				{
					targets[0] = i;
					targets[1] = j;
					return targets;
				}
			}	
		}	
		return targets;
    }
}


/**
 * 堆排序演示
 *
 * @author Lvan
 */
class HeapSort {
	int[] arr = new int[103];

    /**
     * 创建堆，
     * @param arr 待排序列
     */
    public void heapSort(int[] arr) {
        //创建堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //重新对堆进行调整
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 调整堆
     * @param arr 待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
    public void adjustHeap(int[] arr, int parent, int length) {
        //将temp作为父节点
        int temp = arr[parent];
        //左孩子
        int lChild = 2 * parent + 1;

        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= arr[lChild]) {
                break;
            }

            // 把孩子结点的值赋给父结点
            arr[parent] = arr[lChild];

            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[parent] = temp;
    }
}
