package adt.btree;

import java.util.Collections;
import java.util.LinkedList;

public class BNode<T extends Comparable<T>> {
   protected LinkedList<T> elements; // PODERIA TRABALHAR COM ARRAY TAMBEM
   protected LinkedList<BNode<T>> children; // PODERIA TRABALHAR COM ARRAY
   // TAMBEM
   protected BNode<T> parent;
   protected int maxKeys;
   protected int maxChildren;

   public BNode(int order) {
      this.maxChildren = order;
      this.maxKeys = order - 1;
      this.elements = new LinkedList<T>();
      this.children = new LinkedList<BNode<T>>();
   }

   @Override
   public String toString() {
      return this.elements.toString();
   }

   @Override
   public boolean equals(Object obj) {
      boolean resp = false;
      if (obj != null) {
         if (obj instanceof BNode) {
            if (this.size() == ((BNode<T>) obj).size()) {
               resp = true;
               int i = 0;
               while (i < this.size() && resp) {
                  resp = resp && this.getElementAt(i).equals(((BNode<T>) obj).getElementAt(i));
                  i++;
               }
            }
         }
      }
      return resp;
   }

   public boolean isEmpty() {
      return this.size() == 0;
   }

   public int size() {
      return this.elements.size();
   }

   public boolean isLeaf() {
      return this.children.size() == 0;
   }

   public boolean isFull() {
      return this.size() == maxKeys;
   }

   public void addElement(T element) {
      this.elements.add(element);
      Collections.sort(elements);
   }

   public void removeElement(T element) {
      this.elements.remove(element);
   }

   public void removeElement(int position) {
      this.elements.remove(position);
   }

   public void addChild(int position, BNode<T> child) {
      this.children.add(position, child);
      child.parent = this;
   }

   public void removeChild(BNode<T> child) {
      this.children.remove(child);
   }

   public int indexOfChild(BNode<T> child) {
      return this.children.indexOf(child);
   }

   public T getElementAt(int index) {
      return this.elements.get(index);
   }

   private void guardaElementos(T mediana, BNode<T> maior, BNode<T> menor) {

      int index = 0;

      while (index < getElements().size()) {

         if (mediana.compareTo(getElementAt(index)) < 0) {
            maior.addElement(getElementAt(index));
         }

         if (mediana.compareTo(getElementAt(index)) > 0) {
            menor.addElement(getElementAt(index));
         }

         index++;
      }
   }

   private void reorganizador(LinkedList<BNode<T>> filhos, BNode<T> node, int first, int last) {

      int pos;
      int index = first;

      while (index < last) {
         pos = position(node.getElements(), filhos.get(index).getElements().get(0));
         node.addChild(pos, filhos.get(index));

         index++;
      }
   }

   private int position(LinkedList<T> lista, T mediana) {

      int i = 0;
      while (i < lista.size()) {

         if (lista.get(i).compareTo(mediana) > 0) {
            return i;
         }

         i++;
      }

      return lista.size();
   }

   protected void split() {

      T mediana = getElements().get(getElements().size() / 2);

      int pos, left, right;

      BNode<T> maior = new BNode<T>(getMaxChildren());
      BNode<T> menor = new BNode<T>(getMaxChildren());

      LinkedList<BNode<T>> filhos = new LinkedList<BNode<T>>();

      guardaElementos(mediana, maior, menor);

      if (getParent() == null && !isLeaf()) {

         filhos = getChildren();

         setElements(new LinkedList<T>());
         addElement(mediana);
         setChildren(new LinkedList<BNode<T>>());

         addChild(0, menor);
         addChild(1, maior);

         reorganizador(filhos, menor, 0, menor.size() + 1);
         reorganizador(filhos, maior, maior.size() + 1, filhos.size());

      } else if (getParent() == null && isLeaf()) {

         setElements(new LinkedList<T>());
         addElement(mediana);
         addChild(0, menor);
         addChild(1, maior);

      } else if (isLeaf()) {

         BNode<T> node = new BNode<>(getMaxChildren());

         node.getElements().add(mediana);
         node.parent = getParent();

         menor.parent = getParent();
         maior.parent = getParent();

         pos = position(node.getParent().getElements(), mediana);
         left = pos;
         right = pos + 1;

         getParent().getChildren().set(left, menor);
         getParent().getChildren().add(right, maior);

         node.promote();

      } else {

         filhos = getChildren();

         BNode<T> node = new BNode<>(getMaxChildren());

         node.getElements().add(mediana);
         node.parent = getParent();

         menor.parent = getParent();
         maior.parent = getParent();

         pos = position(node.getElements(), mediana);
         left = pos;
         right = pos + 1;

         getParent().getChildren().add(left, menor);
         getParent().getChildren().add(right, maior);

      }
   }

   protected void promote() {

      int pos = position(getParent().getElements(), getElementAt(0));

      getParent().getElements().add(pos, getElementAt(0));

      if (getParent().size() > getMaxKeys()) {
         getParent().split();
      }

   }

   public LinkedList<T> getElements() {
      return elements;
   }

   public void setElements(LinkedList<T> elements) {
      this.elements = elements;
   }

   public LinkedList<BNode<T>> getChildren() {
      return children;
   }

   public void setChildren(LinkedList<BNode<T>> children) {
      this.children = children;
   }

   public BNode<T> copy() {
      BNode<T> result = new BNode<T>(maxChildren);
      result.parent = parent;
      for (int i = 0; i < this.elements.size(); i++) {
         result.addElement(this.elements.get(i));
      }
      for (int i = 0; i < this.children.size(); i++) {
         result.addChild(i, ((BNode<T>) this.children.get(i)).copy());
      }

      return result;
   }

   public BNode<T> getParent() {
      return parent;
   }

   public void setParent(BNode<T> parent) {
      this.parent = parent;
   }

   public int getMaxKeys() {
      return maxKeys;
   }

   public void setMaxKeys(int maxKeys) {
      this.maxKeys = maxKeys;
   }

   public int getMaxChildren() {
      return maxChildren;
   }

   public void setMaxChildren(int maxChildren) {
      this.maxChildren = maxChildren;
   }

}