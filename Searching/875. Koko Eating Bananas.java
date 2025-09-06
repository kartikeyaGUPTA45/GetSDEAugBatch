class Solution {

    private boolean isPossbile(int piles[], int mid, int h) {
        int hrs = 0;

        for(int ele : piles) {
            hrs += Math.ceil((double)ele/mid);
        }

        return hrs <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        int ans = 0;

        for(int ele : piles) {
            high = Math.max(high, ele);
        }

        while(low <= high) {
            int mid = low + (high - low)/2;

            if (isPossbile(piles, mid, h)) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return ans;
    }
}
