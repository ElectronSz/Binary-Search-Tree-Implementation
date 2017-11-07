package registrationsystem;

import com.sun.org.apache.xerces.internal.dom.ParentNode;

/**
 *
 * @author Mr B A Dlamini
 */
public class BinaryTree {

    Node root;

    public BinaryTree() {

        this.root = null;
    }

    public void insertStudent(Student student) {

        Node newNode = new Node(student);

        if (root == null) {

            root = newNode;
            return; 

        }
        //instance
        Node currentNode = root;//run if false(root== null)

        Node parrentNode = null;

        while (true) {//infinite loop
            //set parent to the current
            parrentNode = currentNode;
            if (student.getStudentID().equals(currentNode.student.getStudentID())) {

                System.out.print("Student ID: " + student.getStudentID() + " " + "Allready exist, try another new student ID");
                return;
                
            } 
            else if (student.getStudentID() < currentNode.student.getStudentID()) {

                currentNode = currentNode.leftChild;
                if (currentNode == null) {
                    parrentNode.leftChild = newNode;
                    return;
                }

            } else {

                currentNode = currentNode.rightChild;
                if (currentNode == null) {
                    parrentNode.rightChild = newNode;
                    return;

                }
            }

        }

    }

    public void displayStudent(Node root1) {
        
        if (root1 != null) {
            displayStudent(root1.leftChild);
           
            System.out.println(root1.student.getStudentID() + "\t " + root1.student.getName() + " \t" + root1.student.getSurname() + "\t " + root1.student.getGender() + " \t"
                    + root1.student.getAge() + "\t " + root1.student.getCell() + " \t" + root1.student.getPosition() + " \t" + root1.student.getPlace() + "\t " + root1.student.getParentName());

            displayStudent(root1.rightChild);

        }

    }
    public void search(int id){
    Node current = root;
    //set current to not equall to null
    while(current != null){
    if(current.student.getStudentID() == id){
        
      System.out.println("ID: "+" "+ current.student.getStudentID());
      System.out.println("NAME: "+" "+ current.student.getName());
      System.out.println("SURNAME: "+" "+ current.student.getSurname());
      System.out.println("GENDER: "+" "+ current.student.getGender());
      System.out.println("AGE: "+" "+ current.student.getAge());
      System.out.println("CELL: "+" "+ current.student.getCell());
      System.out.println("POSITION: "+" "+ current.student.getPosition());
      System.out.println("PLACE: "+" "+ current.student.getPlace());
      System.out.println("PARENT NAME: "+" "+ current.student.getParentName());
    return;
    }
    else if(current.student.getStudentID() > id){
    current = current.leftChild;
    }
    else{
    current = current.rightChild;
    }
        
    }
    
System.out.println("STUDENT ID WITH ID:"+ id +"IS NOT FOUND IT THE LIST");
System.out.println("--------------------------------------------");
     return;
    }
    public boolean delete(int id){
        boolean isDeleted = false;
        Node parrent = root;
        Node current = root;
        
        boolean isLeftChiled = false;
        while(current.student.getStudentID() != id){
        parrent = current;
        if(current.student.getStudentID() > id){
        
            isLeftChiled = true;
            
            current = current.leftChild;
        }
        else{
            isLeftChiled = false;
            
        current = current.rightChild;
        }
        if(current == null){
        System.out.println("The student with ID"+" "+id+" "+"is not found");
        }
        
        }
        //continue with the part
        if(current.leftChild == null && current.rightChild == null){
            if(current == root){
            
            root = null;
            }
            if(isLeftChiled == true){
            
            parrent.leftChild = null;
            }
            else{
            parrent.rightChild = null;
            }
        
        }
        //has one kid
        else if(current.rightChild == null){
        if(current == root){
        root = current.rightChild;
        
        }else if( isLeftChiled){
            parrent.leftChild = parrent.rightChild;
        
        }
       
        else{
        parrent.rightChild = current.rightChild;
        }
        
        }
         else if(current.leftChild != null && current.rightChild != null){
         
         Node sucessor = getSucessor(current);
         if(current == root){
         root = sucessor;
         }
         else if(isLeftChiled){
         
             parrent.leftChild = sucessor;
         }
         else{
         parrent.rightChild = sucessor;
         }
         sucessor.leftChild = current.leftChild;
         }
        System.out.println("Student with ID:"+id + " "+"is deleted sucessful");
        
    return isDeleted;
    }
    public Node getSucessor(Node deletedNode){
    Node sucessor = null;
    Node sucessorParent = null;
    
    Node current = deletedNode.rightChild;
    while(current != null){
    
    sucessorParent = sucessor;
    sucessor = current;
    current = current.leftChild;
    }if( sucessor != deletedNode.rightChild){
    
        sucessorParent.leftChild = sucessor.rightChild;
        sucessor.rightChild = deletedNode.rightChild; //to delete the node to the right child
    }
    
    return sucessor;
    }
public void printInOder(Node node){
    if(node == null){
    return;
    }
    printInOder(node.leftChild);
    System.out.println(node.student.getStudentID() + "\t " + node.student.getName() + " \t" + node.student.getSurname() + "\t " + node.student.getGender() + " \t"
                    + node.student.getAge() + "\t " + node.student.getCell() + " \t" + node.student.getPosition() + " \t" + node.student.getPlace() + "\t " + node.student.getParentName());
    
    printInOder(node.rightChild);
    
} 
public void printPreOder(Node node){
     if(node == null){
    return;
     }
    System.out.println(node.student.getStudentID() + "\t " + node.student.getName() + " \t" + node.student.getSurname() + "\t " + node.student.getGender() + " \t"
                    + node.student.getAge() + "\t " + node.student.getCell() + " \t" + node.student.getPosition() + " \t" + node.student.getPlace() + "\t " + node.student.getParentName());
    
     printInOder(node.leftChild);
     printInOder(node.rightChild);
     
}  
public void printPostOder(Node node){
     if(node == null){
    return;
}
          printInOder(node.leftChild);
     printInOder(node.rightChild);
     
    System.out.println(node.student.getStudentID() + "\t " + node.student.getName() + " \t" + node.student.getSurname() + "\t " + node.student.getGender() + " \t"
                    + node.student.getAge() + "\t " + node.student.getCell() + " \t" + node.student.getPosition() + " \t" + node.student.getPlace() + "\t " + node.student.getParentName());
    
     
}
public void printInOder(){
   printInOder(root);
} 
public void printPreOder(){
     printPreOder(root);
}
public void printPostOder(){
 printPostOder(root);
}
}
