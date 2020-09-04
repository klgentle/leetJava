package com.gentle.config2;

import java.util.PriorityQueue;
import java.util.Comparator;

public class GetMedian {
    int count = 0;
    /*
    * 我们知道，Queue是一个先进先出（FIFO）的队列。
    * PriorityQueue和Queue的区别在于，它的出队顺序与元素的优先级有关，
    * 对PriorityQueue调用remove()或poll()方法，返回的总是优先级最高的元素。
    * */
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {
        if (count % 2 == 0) {
            //PriorityQueue.offer(num) equals to PriorityQueue.add(num)
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        count++;
        System.out.println(GetMedian.GetMedian());
    }

    public static int GetMedian() {
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        GetMedian t = new GetMedian();
        t.Insert(1);
        t.Insert(2);
        t.Insert(0);
        t.Insert(20);
        t.Insert(10);
        t.Insert(22);
    }
}