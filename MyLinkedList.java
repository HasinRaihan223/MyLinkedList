public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList(){
    size = 0;
    // start = null;
    // end = null;
  }

  public int size(){
    return size;
  }

  public boolean add(String value){
    if(size==0){
      Node node = new Node(value);
      start = node;
      end = node;
      size++;
    }
    else {
      Node newNode = new Node(value);
      end.setNext(newNode);
      newNode.setPrev(end);
      end = newNode;
      size++;
    }
    return true;
  }

  public void add(int index, String value){
    if (index < 0 || (index > size())){
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }
    if (index==size){
      add(value);
    }
    else if (index==0){
      Node temp = new Node(value);
      temp.setNext(start);
      start.setPrev(temp);
      start = temp;
      size++;
    }
    else {
      Node current = findNode(index);
      Node prevCurrent = current.getPrev();
      Node newNode = new Node(value);
      // Connects prevCurrent & newNode
      prevCurrent.setNext(newNode);
      newNode.setPrev(prevCurrent);
      // Connects newNode & current
      newNode.setNext(current);
      current.setPrev(newNode);
      size++;
    }
  }

  public String get(int index){
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }
    return findNode(index).getData();
  }

  public String set(int index, String value){
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }
    Node temp = findNode(index);
    String str = temp.getData();
    temp.setData(value);
    return str;
  }

  // public String toString() {
	// 	String s = "[";
	// 	Node current = start;
	// 	for (int i = 0; i < size() - 1; i++){
	// 		s += current.getData() + ", ";
	// 		current = current.getNext();
	// 	}
	// 	s += current.getData() + "]";
	// 	return s;
	// }

  public String toString() {
    String s = "[";
    Node current = start;
    for(int i = 0; i < size; i++) {
      s += current.getData();
      if(i!=size - 1){
        s += ", ";
      }
      current = current.getNext();
    }
    s += "]";
    return s;
  }

  //Reversed
  public String toStringReversed() {
    String s = "[";
    Node current = end;
    for(int i = 0; i < size; i++) {
      s += current.getData();
      if(i!=size - 1){
        s += ", ";
      }
      current = current.getPrev();
    }
    s += "]";
    return s;
  }

  private Node findNode(int index) {
    Node current = start;
    for(int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current;
  }

  public String remove(int index){
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }
    String s = "";
    if (size==1){
      s += start.getData();
      start = null;
      start = null;
      size--;
    }
    else if(index==0){
      s += start.getData();
      Node newStart = start.getNext();
      start.setNext(null);
      newStart.setPrev(null);
      start = newStart;
      size--;
    }
    else if(index==size-1){
      s += end.getData();
      Node newEnd = end.getPrev();
      newEnd.setNext(null);
      end.setPrev(null);
      end = newEnd;
      size--;
    }
    else{
      Node middleNode = findNode(index);
      s += middleNode.getData();
      Node beforeMid = middleNode.getPrev();
      Node afterMid = middleNode.getNext();
      //breaks beforeMid & middleNode
      beforeMid.setNext(null);
      middleNode.setPrev(null);
      //breaks middleNode & afterMid
      middleNode.setNext(null);
      afterMid.setPrev(null);
      //connects before & after
      beforeMid.setNext(afterMid);
      afterMid.setPrev(beforeMid);
      size--;
    }
    return s;
  }

  public void extend(MyLinkedList other){
    end.setNext(other.start);
    other.start.setPrev(end);
    end = other.end;
    size += other.size();
    other.size = 0;
    other.start = null;
    other.end = null;
  }

}
