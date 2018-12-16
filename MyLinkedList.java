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

}
