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

  public Node getNext() {
    return next;
  }

  public Node getPrev() {
    return prev;
  }

  public void setNext(Node newNext) {
    this.next = newNext;
  }

  public void setValue(int newValue){
    this.data = newValue;
  }

  public void setPrev(Node newPrev) {
    this.prev = newPrev;
  }

  public String toString() {
		return "" + data;
	}

}
