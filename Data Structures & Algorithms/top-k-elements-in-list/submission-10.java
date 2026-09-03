class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++)    {
            if(map.containsKey(nums[i]))    {
                map.put(nums[i], map.get(nums[i])+ 1);
            }
            else    {
                map.put(nums[i],1);
            }
        }
        PriorityQueue<Point> minHeap = new PriorityQueue<>((a,b)->b.frequency - a.frequency);
        for(Integer i : map.keySet())   {
            Point p = new Point();
            p.number = i;
            p.frequency = map.get(i);
            minHeap.add(p);
        }
        int[] result = new int[k];
        for(int i = 0; i< result.length;i++)    {
            result[i] = minHeap.remove().number;
        }
        return result;
    }
    class Point {
        int number;
        int frequency;
    }
}
