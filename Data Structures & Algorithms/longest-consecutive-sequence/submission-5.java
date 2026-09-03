class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++)    {
            set.add(nums[i]);
        }
        int lcs = 0;
        for(int i = 0 ; i < nums.length; i++)   {
            if(!set.contains(nums[i]-1)){
                int currentLength = 1;
                int num = nums[i] + 1;
                while(set.contains(num))    {
                    currentLength++;
                    num++;
                }
                if(currentLength > lcs) {
                    lcs = currentLength;
                } 
            } 
        }
        return lcs;
    }
}
