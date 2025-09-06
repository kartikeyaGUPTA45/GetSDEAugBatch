class Solution {

    private boolean isPossible(int weights[], int capacity, int days) {
        int d = 1;
        int cap = 0;
        for(int wt : weights) {
            if (cap + wt > capacity) {
                d+=1;
                cap = wt;
            } else {
                cap += wt;
            }
        }

        return (d <= days);
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        int ans = 0;

        for(int wt : weights) {
            low = Math.max(low, wt);
            high += wt;
        }

        while(low <= high) {
            int mid = low + (high-low)/2;

            if (isPossible(weights, mid, days)) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        } 

        return ans;
    }
}
