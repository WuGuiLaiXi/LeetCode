	public static void main(String[] args) {
		
		/*
		//easy_1
		int[] nums = {1, 6, 9, 11, 7,20 ,-18,3, 4, 5,50};
		easy_1 test = new easy_1();
		int[] a = test.twoSum(nums, 57);
		System.out.println("a[0]:"+a[0]);
		System.out.println("a[1]:"+a[1]);
		*/
		
		//easy_21
		//l1 = [1,2,4], l2 = [3,4,5]
		int[] a = {1,2,4};
		int[] b = {3,4,5};
		ListNode l1 = new ListNode(a[a.length-1]);
		for (int i = a.length-2; i >= 0; i--) {
			l1 = new ListNode(a[i],l1);
		}
		System.out.println("l1:");
		while (l1.next != null) {
			System.out.printf(l1.val+",");
			l1 = l1.next;
		}
		System.out.printf(l1.val+",");
		System.out.printf("\n");
		
		ListNode l2 = new ListNode(b[b.length-1]);
		for (int i = b.length-2; i >= 0; i--) {
			l2 = new ListNode(b[i],l2);
		}
		System.out.println("l2:");
		while (l2.next != null) {
			System.out.printf(l2.val+",");
			l2 = l2.next;
		}
		System.out.printf(l2.val+",");
		System.out.printf("\n");
		
		easy_21 test = new easy_21();
		ListNode res = new ListNode();
		res = test.mergeTwoLists(l1, l2);
			
		System.out.println("整合后:");
		while (res.next != null) {
			System.out.printf(res.val+",");
			res = res.next;
		}
		System.out.printf(res.val+",");
		System.out.printf("\n");
	}

