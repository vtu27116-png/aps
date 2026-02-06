class Solution {
    
   public boolean func(int len, int[] nums, int limit){
    int n = nums.length;
    TreeMap<Integer, Integer> map = new TreeMap<>();

    for(int i = 0; i < n; i++) {

        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        if(i >= len) {
            int x = nums[i - len];
            int c = map.get(x);
            if(c == 1) map.remove(x);
            else map.put(x, c - 1);
        }

        if(i >= len - 1) {
            int min = map.firstKey();
            int max = map.lastKey();
            if(max - min <= limit) return true;
        }
    }
    return false;
}

    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int l = 1, r = n, ans = 1;


        while(l <= r){
            int mid = l + (r-l)/2;
            if(func(mid, nums, limit)){
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}