class Solution {
    public int search(List<Integer> nums, int target){
        int low = 0;
        int high = nums.size()-1;
        int out = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums.get(mid) == target){
                return mid;
            }else if(nums.get(mid) > target){
                out = Math.min(out,mid);
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return out==Integer.MAX_VALUE ? -1 : out;
    }
    public int[] findRightInterval(int[][] intervals) {
        List<Integer> starts = new ArrayList<>();
        Map<Integer,Integer> keys = new HashMap<>();

        for(int i=0; i<intervals.length; i++){
            starts.add(intervals[i][0]);
            keys.put(intervals[i][0],i);
        }
        Collections.sort(starts);

        int[] out = new int[intervals.length];

        for(int i=0; i<intervals.length; i++){
            int index = search(starts, intervals[i][1]);
            if(index == -1){
                out[i] = -1;
            }else{
                out[i] = keys.get(starts.get(index));
            }
            
        }
        return out;
    }
}
