import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

  public static void main(String[] args) {
    Queue<Pair> q = new LinkedList<>();
    int arr[] = new int[]{1,2,3,1,5};

    for(int i = 0 ; i < arr.length; i++){
      q.add(new Pair(i, arr[i]));
    }
    for(int a: arr){
      System.out.println(q.poll().value);
    }
  }


}
class Pair{
  int idx;
  int value;
  public Pair(int idx, int value){
    this.idx = idx;
    this.value = value;
  }
}