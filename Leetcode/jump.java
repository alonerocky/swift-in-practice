//Time limit exceed
public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] minSteps = new int[len];
        Arrays.fill(minSteps, 0, len, -1);
        minSteps[len-1] = 0;
        for (int i = len -2; i >=0; i--) {
            
            int minStep = Integer.MAX_VALUE;
            int maxSteps = nums[i];
            if (i + maxSteps >= len - 1) {
                maxSteps = len - 1 - i;
            }
            boolean canReach = false;
            for (int j = 1; j <= maxSteps; j++) {
                if (minSteps[i+j] != -1 ) {
                    canReach = true;
                    minStep = Math.min(minStep, minSteps[i+j]);
                }
            }
            if (canReach) {
                minSteps[i] = minStep + 1;
            }
        }
        return minSteps[0];
    }

//better solution,
public int jump(int[] nums) {
	if (nums == null || nums.length == 0)
		return 0;
 
	int lastReach = 0;
	int reach = 0;
	int step = 0;
 
	for (int i = 0; i <= reach && i < nums.length; i++) {
		//when last jump can not read current i, increase the step by 1
		if (i > lastReach) {
			step++;
			lastReach = reach;
		}
		//update the maximal jump 
		reach = Math.max(reach, nums[i] + i);
	}
 
	if (reach < nums.length - 1)
		return 0;
 
	return step;
}
