public void quicksort(int[] nums) {
	if (nums == null || nums.length == 0) {
	{
		return;
	}
	quicksort(nums, 0, nums.length - 1);
}

public void quicksort(int[] nums, int start, int end) {
	if (start >= end) {
	{
		return;
	}
	int i = start;
	int j = end;
	int pivot = nums[start];
	while (i <= j) {
	{
		while (i <= j && nums[i] <= pivot) i++;
		while (i <= j && nums[j] >= pivot) j--;
		if (i < j) {
			swap(nums, i, j);
		}
	}
	//now i point the element of bigger than pivot, [start ... i -1] are all smaller or equal than pivot
	//j point the element of smaller than pivot, [j+1, end] are all bigger or equal to pivot, and j = i -1
	swap(nums, start, j)
	quicksort(nums, start, j-1);
	quicksort(nums, i, end);
}
public void swap(int[] nums, int i, int j) {
	if (i != j) {
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
