import java.util.List;
public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList(){
    size = 0;
    start = null;
    end = null;
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
       while(i.hasNext())
     }
     return str;
   }

}
