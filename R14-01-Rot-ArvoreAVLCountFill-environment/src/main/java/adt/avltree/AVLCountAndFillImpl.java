package adt.avltree;

import java.util.ArrayList;
import java.util.Arrays;

import adt.bst.BSTNode;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends AVLTreeImpl<T> implements AVLCountAndFill<T> {

   private int LLcounter;
   private int LRcounter;
   private int RRcounter;
   private int RLcounter;

   public AVLCountAndFillImpl() {

   }

   @Override
   public int LLcount() {
      return LLcounter;
   }

   @Override
   public int LRcount() {
      return LRcounter;
   }

   @Override
   public int RRcount() {
      return RRcounter;
   }

   @Override
   public int RLcount() {
      return RLcounter;
   }

   @Override
   public void fillWithoutRebalance(T[] array) {
      ArrayList<T> aux = new ArrayList<T>();

      for (T element : array)
         aux.add(element);
      for (T element : this.order())
         aux.add(element);

      T[] elementsToInsert = (T[]) aux.toArray(new Comparable[0]);

      super.root = new BSTNode<T>();

      Arrays.sort(elementsToInsert);
      fillWithoutRebalance(array, 0, elementsToInsert.length - 1);
   }

   private void fillWithoutRebalance(T[] array, int left, int right) {
      if (left <= right) {
         int mid = (left + right + 1) / 2;

         fillWithoutRebalance(array, left, mid - 1);
         fillWithoutRebalance(array, mid + 1, right);

         this.insert(array[mid]);
      }
   }

   // AUXILIARY
   protected void rebalance(BSTNode<T> node) {
      int height = calculateBalance(node);
      if (height > 1) {
         if (calculateBalance((BSTNode<T>) node.getRight()) < 0) {
            rightRotation((BSTNode<T>) node.getRight());
            leftRotation(node);
            this.RLcounter++;
         } else {
            leftRotation(node);
            this.RRcounter++;
         }
      } else if (height < -1) {
         if (calculateBalance((BSTNode<T>) node.getLeft()) > 0) {
            leftRotation((BSTNode<T>) node.getLeft());
            rightRotation(node);
            this.LRcounter++;
         } else {
            rightRotation(node);
            this.LLcounter++;
         }
      }
   }
}
