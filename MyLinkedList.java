import java.util.List;
public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList(){
    size = 0;
  }

  public int size(){
    return size;
  }
//Adds the given value to the end of the ArrayList
  public boolean add(int value){
    Node n = new Node(value);
    if (size == 0){
      n.setNext(null);
      n.setPrev(null);
      size = size + 1;
      start = n;
      end = n;
      return true;
    }else{ //if the length is not 0, that means we have to set the "old" end as the new node's previous
      n.setPrev(end);
      n.setNext(null);
      size = size + 1;
      end.setNext(n);
      end = n;
      return true;
    }
  }

   public String toString(){
     Node i = start;
     String str = "[";
     while (i != null){
       str = str + i.getData();
     if (i.Next() != null){
       str= str + ", ";
     }
     i = i.Next();
   }
   return str + "]";
 }

   public int get(int index){
     if (index > size - 1 || index < 0){
       //if the index is out of bounds, it throws exception
       throw new IndexOutOfBoundsException();
     }
     Node i = start;
     for(int n = 0; n < index; n++){
       i = i.Next();
     }
     //gets the data of the Node at index i
     return i.getData();

   }

   public Integer set(int index, Integer value){
     if (index > size - 1 || index < 0){
       //if the index is out of bounds, it throws exception
       throw new IndexOutOfBoundsException();
     }
     Node i = start;
     for(int n = 0; n < index; n++){
       i = i.Next();
     }
     //sets the data of the Node at index i
     int org = i.getData();
     i.setData(value);
     return org;
   }

   public boolean contains(Integer value){
     Node i = start;
     for(int n = 0; n < size ; n++){
       if(i.getData() == value){
          //if value is equal to one number in the list, end here
         return true;
       }
       i = i.Next();
     }
     return false;
   }

   public int indexOf(Integer value){
     Node i = start;
     for(int n = 0; n < size ; n++){
       if(i.getData() == value){
         return n;
       }
       i = i.Next();
     }
     //returns -1 if the loop hasn't found the value
     return -1;
   }

   private Node getNthNode(int index){
     int n = 0;
     Node i = start;
     if (i != null) {
      //checks up to the correct index
      while (n < index) {
        i = i.Next();
        n++;
      }
    }
    return i;
   }

   public void add(int index,Integer value) {
     if(index > size || index < 0){
       //if the index is out of bounds, throw exception
       throw new IndexOutOfBoundsException();
     }
     Node NewNode = new Node(value);
     //if the index is at the end, just add to the end with the other method
     if(index == size){
       add(value);
     //if index is 0 add it to the start and push the old start back
     }else if(index == 0){
       Node old = getNthNode(index);
       start = NewNode;
       NewNode.setNext(old);
       old.setPrev(NewNode);
       size = size + 1;
     //otherwise just adjust nearby nodes to include the new one
     }else{
       Node old = getNthNode(index);
       old.setPrev(NewNode);
       NewNode.setPrev(old.Prev());
       NewNode.setNext(old);
       old.Prev().setNext(NewNode);
       size = size + 1;
     }

   }

   public Integer remove(int index) {
    if (index < 0 || index >= size()) {
      //if the index is out of bounds, throw exception
      throw new IndexOutOfBoundsException();
    }
    Node removeNode = getNthNode(index);
    Integer value = removeNode.getData();
    Node previous = removeNode.Prev();
    Node after = removeNode.Next();
    //if size is 1 just make both start and end null
    if(index == 0 && size == 1){
      start = null;
      end = null;
      size = size - 1;
    //if you start at the front you change the old first node to point to the new one
    }else if(index == 0){
      start = after;
      after.setPrev(null);
      size = size - 1;
    //if its in the end make the revious node point to null since the last node is removed
    }else if (index == size - 1){
      end = previous;
      previous.setNext(null);
      size = size - 1;
    }else{
      after.setPrev(previous);
      previous.setNext(after);
      size = size - 1;
    }
    return value;
   }
   public boolean remove(Integer value){
     //if it contains the value remove it else return false
     if(contains(value)){
       remove(indexOf(value));
       return true;
     }
     return false;
   }

}
