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

  public boolean add(int value){
    Node n = new Node(value);
    if (this.size() == 0){
      n.setNext(null);
      n.setPrev(null);
      size = size + 1;
      start = n;
      end = n;
      return true;
    }else{
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
     if(start == null){
       return "[]";
     }
     for (int n = 0; n < size; n++){
       while(i.hasNext()){
         str = str + i.getData();
         i = i.Next();
       }
     }
     return str + "]";
   }

   public int get(int index){
     if (index > this.size - 1 || index < 0){
       throw new IndexOutOfBoundsException();
     }
     Node i = start;
     for(int n = 0; n < index; n++){
       i = i.Next();
     }
     return i.getData();

   }

   public Integer set(int index, Integer value){
     if (index > this.size - 1 || index < 0){
       throw new IndexOutOfBoundsException();
     }
     Node i = start;
     for(int n = 0; n < index; n++){
       i = i.Next();
     }
     int org = i.getData();
     i.setData(value);
     return org;
   }

   public boolean contains(Integer value){
     Node i = start;
     for(int n = 0; n < this.size() ; n++){
       if(i.getData() == value){
         return true;
       }
       i = i.Next();
     }
     return false;
   }

   public int indexOf(Integer value){
     Node i = start;
     for(int n = 0; n < this.size() ; n++){
       if(i.getData() == value){
         return n;
       }
       i = i.Next();
     }
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
       throw new IndexOutOfBoundsException();
     }
     if(index == size){
       this.add(index);
     }
     Node NewNode = new Node(value);
     if(index == 0){
       Node old = getNthNode(index);
       start = NewNode;
       NewNode.setNext(old);
       old.setPrev(NewNode);
       size = size + 1;
     }else{
       Node old = getNthNode(index);
       NewNode.setNext(old);
       NewNode.setPrev(old.Prev()); //we didn't update shiftedNode's prev yet, so this sets newN's prev to two Nodes back from shiftedNode
       old.Prev().setNext(NewNode); //the Node two nodes back from shiftedNode (since it still isn't updated yet) sets the next one to be newN
       old.setPrev(NewNode); //now we updated shiftedNode's prev
       size = size + 1;
     }

   }

}
