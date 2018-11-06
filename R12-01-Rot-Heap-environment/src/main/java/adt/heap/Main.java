package adt.heap;

import java.util.Comparator;

public class Main {

   public static void main(String[] args) {

      HeapImpl<Integer> heap = new HeapImpl<Integer>(new Comparator<Integer>() {
         @Override
         public int compare(Integer o1, Integer o2) {
            return o1 - o2;
         }
      });

      //System.out.println(Arrays.toString(heap.heapsort(new Integer[] { 34, 92, 5, 12, 49, 20, 43, 6 })));

   }
}
