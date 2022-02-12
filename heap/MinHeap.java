package heap;

import java.util.ArrayList;

public class MinHeap {
  public static class PriorityQueue {
    private ArrayList<Integer> heap;
    public PriorityQueue() {
      heap = new ArrayList<>();
      heap.add(0); // 인덱스 채우기
    }

    public void insert(int val){
      heap.add(val);
      int p = heap.size() - 1;
      while(p > 1 && heap.get(p / 2) > heap.get(p)) {
        System.out.println("Swap");
        int temp = heap.get(p/2);
        heap.set(p/2, heap.get(p));
        heap.set(p, temp);
        p = p/2;
      }
    } 
  }
}
