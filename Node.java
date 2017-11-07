package registrationsystem;

public class Node {
//refrerence of the class node 
   Node leftChild, rightChild;
   
//student object   
Student student;

//coctructures
public Node(){

}
public Node(Student student){
    this.student = student;
    leftChild = rightChild = null;

}
}
