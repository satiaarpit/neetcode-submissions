class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(!minHeap.isEmpty() && num > minHeap.peek())   {
            minHeap.add(num);
        } else  {
            maxHeap.add(num);
        }
        if(maxHeap.size() > minHeap.size()) {
            int temp = maxHeap.poll();
            minHeap.add(temp);
        } else if((minHeap.size() - maxHeap.size()) > 1)  {
            int temp = minHeap.poll();
            maxHeap.add(temp);
        }
    }
    
    public double findMedian() {
        if(minHeap.size() != maxHeap.size())    {
            return minHeap.peek();
        } else  {
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
    }
}
