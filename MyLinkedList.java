public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList(){
    size = 0;
  }

  public int size(){
    return size;
  }

  public boolean add(String value){
    if(size==0){
      start = new Node(value);
      end = new Node(value);
      size++;
    }
    else {
      end.setNext(new Node(value));
      end.getNext().setPrev(end);
      end = end.getNext();
      size++;
    }
    return true;
  }

  public void add(int index, String value){
    if (index < 0 || index > size()){
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }
    if (index==size){
      add(value);
    }
    if (index==0){
      Node temp = new Node(value);
      start.setPrev(temp);
      insert.setNext(start);
      start = temp;
      size++;
    }
    else {
      Node current = start;
      for (int i = 0; i < index; i++) {
        current = current.getNext();
      }
      Node newNode = new Node(value);
      newNode.setNext(current);
      newNode.setPrev(current.getPrev());
      current.getPrev().setNext(newNode);
      current.setPrev(newNode);
      size++;
    }
  }

  public String get(int index){
    Node current = start;
    for(int i = 0; i < index; i++){
      current = current.getNext();
    }
    return current.getData();
  }

  public String set(int index, String value){

  }

  public String toString(){
    String str = "[";
    Node current = start;
    for(int i = 0; i < size - 1; i++){
      str += current.getData();
      str += ", ";
    }
    str += end.getData();
    str += "]"
    return str;
  }

}
