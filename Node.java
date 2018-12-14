public class Node{
  private int data;
  private Node next,prev;

  public Node(int value){
    this.data = value;
  }

  public Node(int value, Node nxt, Node prv ) {
    data = value;
    next = nxt;
    prev = prv;
  }

  public int getData() {
    return data;
  }

  public Node Next() {
    return next;
  }

  public Node Prev() {
    return prev;
  }

  public void setNext(Node newNext) {
    this.next = newNext;
  }

  public void setData(int newValue){
    this.data = newValue;
  }
  public boolean hasNext(){
    return this.Next() != null;
  }

  public void setPrev(Node newPrev) {
    this.prev = newPrev;
  }

  public String toString() {
		return "" + data;
	}

}
