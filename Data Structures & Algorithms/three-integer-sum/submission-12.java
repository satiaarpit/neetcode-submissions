class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)    {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1;
            int k = nums.length - 1;
            int target = 0 - nums[i];
            while(j<k)  {
                if((nums[j] + nums[k]) == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                    while(j<k && nums[j] == nums[j-1])  {
                        j++;
                    }
                } else  {
                    if((nums[j] + nums[k]) > target)  {
                        k--;
                    } else  {
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
