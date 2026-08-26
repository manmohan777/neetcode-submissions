class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue();
    PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(minHeap.size()>maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
       
        if((minHeap.size() + maxHeap.size()) % 2 == 1){
            return maxHeap.peek();
        }else{
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
    }
}
