package adt.avltree;

import java.util.Arrays;

public class Main {

   public static void main(String[] args) {
      AVLTreeImpl<Integer> avl = new AVLTreeImpl<>();
      avl.insert(55);
      
      avl.insert(9);
      System.out.println("Okok");
      avl.insert(91);
      avl.insert(12);
      //avl.remove(-1);
      avl.remove(91);

      System.out.println(avl.size());
      System.out.println(Arrays.toString(avl.order()));
      System.out.println(avl.getRoot());
   }

}
