public void mergesort(int[] nums) {
	if (nums == null || nums.length == 0) {
		return;
	}
	mergesort(nums, 0, nums.length - 1);
}
public void mergesort(int[] nums, int start, int end) {
	if (start >= end) {
		return;
	}
	int middle = (start + end) / 2;
	mergesort(nums, start, middle);
	mergesort(nums, middle + 1, end);
	//now [start ... middle] are sorted
	//and [middle ... end] are sorted too
	int i = start;
	int j = middle + 1;
	while (i <= middle && j <= end ) {
		if (nums[i] <= nums[j]) {
			i++;
		} else {
			int temp = nums[j];
			//move [i ... j -1] to [i + 1, j] ,  (j - i) elements
			System.arraycopy(nums, i,nums,i+1,j-i);
			nums[i] = temp;
			i++;
			middle++;
			j++;
		}
	}
}
public void swap(int[] nums, int i, int j) {
}
