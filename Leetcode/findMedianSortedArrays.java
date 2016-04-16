public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            int n = nums2.length;
            if (n % 2 == 0) {
                return (nums2[n/2] + nums2[n/2 - 1] )/2.0;
            } else {
                return nums2[n / 2];
            }
        } else if (nums2 == null || nums2.length == 0) {
            int n = nums1.length;
            if (n % 2 == 0) {
                return (nums1[n/2] + nums1[n/2 - 1] )/2.0;
            } else {
                return nums1[n / 2];
            }
        } else {
            int m = nums1.length;
            int n = nums2.length;
            int k = (m + n) / 2;
            if ((m + n) % 2 != 0) {
                return findKth(nums1, 0, m-1, nums2, 0, n-1, k+1 );
            } else {
                return (findKth(nums1, 0, m-1, nums2, 0, n-1, k ) + findKth(nums1, 0, m-1, nums2, 0, n-1, k + 1 ) )/2.0;
            }
            
        }
    }
    
    
    //k is 1 based
    public double findKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        if (start1 > end1) {
            return nums2[start2+k-1];
        } else if (start2 > end2) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        if (end2 - start2 > end1 - start1) {
            return findKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        
        //nums1 is the longer one
        int m = end1 - start1 + 1;
        int n = end2 - start2 + 1;
        if (nums1[end1] <= nums2[start2]) {
            
            if (end1 - start1 >= k - 1) {
                return nums1[start1 + k - 1];
            } else {
                return nums2[start2 + k - m - 1];
            }
        } else {
            //maintain K elements always
            int j = Math.min(end2 - start2 + 1, k / 2);  //nums2 is the shorter one, count
            int i = k - j;
            if (nums1[start1 + i -1] > nums2[start2 + j -1]) {
                return findKth(nums1, start1, end1, nums2, start2 + j, end2, k-j);
            } else {
                return findKth(nums1, start1 + i, end1, nums2, start2, end2, k - i);
            } 
        } 
    }


public double findKthII(int[] nums1, int[] nums2, int k) {
         int m = nums1.length;
        int n = nums2.length;
        int i =0;
        int j = 0;
        while (i < m && j < n ) {
            if (nums1[i] < nums2[j]) {
                if (i+j == k-1) {
                    return nums1[i];
                }
                i++;
            } else {
                if (i + j == k - 1) {
                    return nums2[j];
                }
                j++;
            }
        }
        while (i < m) {
            if (i+ n == k-1) {
                return nums1[i];
            }
            i++;
        }
        while (j < n) {
            if (j + m == k -1) {
                return nums2[j];
            }
            j++;
        }
        return -1;
    }
