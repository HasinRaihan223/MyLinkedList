public class Node{
 private String data;
 private Node next,prev;

 public Node(String value){
   data = value;
   next = null;
   prev = null;
 }

 public String getData(){
   return data;
 }

 public void setData(String newValue){
   data = newValue;
 }

 public Node getNext(){
   return next;
 }

 public void setNext(String newValue)){
   next = new Node(newValue);
 }

 public Node getPrev(){
   return prev;
 }

 public void setPrev(String newValue)){
   prev = new Node(newValue);
 }

}
