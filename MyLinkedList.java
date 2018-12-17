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
    if (size == 0){
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
     if (index > size - 1 || index < 0){
       throw new IndexOutOfBoundsException();
     }
     Node i = start;
     for(int n = 0; n < index; n++){
       i = i.Next();
     }
     return i.getData();

   }

   public Integer set(int index, Integer value){
     if (index > size - 1 || index < 0){
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
     for(int n = 0; n < size ; n++){
       if(i.getData() == value){
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
       add(index);
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
       NewNode.setPrev(old.Prev());
       old.Prev().setNext(NewNode);
       old.setPrev(NewNode);
       size = size + 1;
     }

   }

   public Integer remove(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException();
    }
    Node removeNode = getNthNode(index);
    Integer value = removeNode.getData();
    Node previous = removeNode.Prev();
    Node after = removeNode.Next();
    int n = removeNode.getData();
    if(index == 0){
      if(size == 1){
        start = null;
        end = null;
        size = size - 1;
      }else{
        start = previous;
        after.setPrev(null);
        size = size - 1;
      }
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
     if(contains(value)){
       remove(indexOf(value));
       return true;
     }
     return false;
   }

}
