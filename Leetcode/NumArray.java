public class NumArray {
    private int[] sum ;
    public NumArray(int[] nums) {
       sum = new int[nums.length];
       int currentSum = 0;
       for (int i =0; i < nums.length; i++) {
           currentSum += nums[i];
           sum[i] = currentSum;
       }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sum[j];
        } else {
            return sum[j] - sum[i-1];
        }
    }
}

public class NumArray {
    private FenwickTree tree;
    public NumArray(int[] nums) {
       tree = new FenwickTree(nums);
    }

    public int sumRange(int i, int j) {
        return tree.sum(j+1) - tree.sum(i);
    }
    
    
}
class FenwickTree {
    private int[] nums;
    private int[] sums;
    private int n;
    public FenwickTree(int[] nums) {
        if (nums != null && nums.length > 0) {
            this.nums = nums;
            this.n = nums.length;
            this.sums = new int[n+1];
            for(int i = 0; i < n; i++) {
                add(i+1, nums[i]);
            }
        }
    }
    
    public int lowBit(int x) {
        return x & -x;
    }
    
    public void add(int i, int value) {
        while(i <= n) {
            sums[i] += value;
            i += lowBit(i);
        }
    }
    
    public int sum(int i) {
        int result = 0;
        while(i > 0) {
            result += sums[i];
            i -= lowBit(i);
        }
        return result;
    }
    
    public void update(int i, int value) {
         add(i+1, value - nums[i]);
         nums[i] = value;
    }
}
