class Solution {

    private int maxInACol(int nums[][], int col, int n) {
        int idx = -1;
        int maxVal = Integer.MIN_VALUE;

        for(int i=0;i<n;i++) {
            if (nums[i][col] > maxVal) {
                maxVal = nums[i][col];
                idx = i;
            }
        }

        return idx;
    }


    public int[] findPeakGrid(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;

        int low = 0;
        int high = m-1;

        int ans [] = new int[2];
        Arrays.fill(ans, -1);

        while(low <= high) {
            int mid = (low + high)/2;
            int idx = maxInACol(nums, mid, n);

            int leftVal = (mid == 0) ? Integer.MIN_VALUE : nums[idx][mid-1];
            int rightVal = (mid == m-1) ? Integer.MIN_VALUE : nums[idx][mid+1];
            int val = nums[idx][mid];

            if (val > leftVal && val > rightVal) {
                ans[0] = idx;
                ans[1] = mid;
                return ans;
            } else if (val < leftVal) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return ans;
    }
}
