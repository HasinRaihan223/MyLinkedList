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
    //Finish middle case
  }

  public String get(int index){

  }

  public String set(int index, String value){

  }

  public String toString(){

  }

}
