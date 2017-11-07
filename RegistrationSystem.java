package registrationsystem;

public class RegistrationSystem {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println("ID\t" + " " + "NAME\t" + " " + "SURNAME\t" + " " + "GENDER\t" + " " + "ADE\t" + " " + "CELL\t" + " " + "POSITION\t" + " " + "PLACE\t" + " " + "PARENT NAME\t");
        Student student = new Student();
        student.setName("Bongani");
        student.setSurname("dlamini");
        student.setStudentID(123);
        student.setCell(43);
        student.setGender("male");
        student.setAge(23);
        student.setParentName("musa");
        student.setPosition(12);
        student.setPlace("bhudla");

        Student student1 = new Student();
        student1.setName("Zodwa");
        student1.setSurname("Dladla");
        student1.setStudentID(345);
        student1.setCell(784654);
        student1.setGender("female");
        student1.setAge(23);
        student1.setParentName("Zinhle");
        student1.setPosition(6);
        student1.setPlace("bhunya");

        Student student2 = new Student();
        student2.setName("Lolo");
        student2.setSurname("Gina");
        student2.setStudentID(6543);
        student2.setCell(78933);
        student2.setGender("male");
        student2.setAge(54);
        student2.setParentName("Bhubezi");
        student2.setPosition(3);
        student2.setPlace("Mhlume");

        Student student3 = new Student();
        student3.setName("madla");
        student3.setSurname("Gule");
        student3.setStudentID(245);
        student3.setCell(76832);
        student3.setGender("male");
        student3.setAge(13);
        student3.setParentName("Fikile");
        student3.setPosition(5);
        student3.setPlace("Mafutseni");

        Student student4 = new Student();
        student4.setName("Gugu");
        student4.setSurname("Ndlela");
        student4.setStudentID(234);
        student4.setCell(7864);
        student4.setGender("Female");
        student4.setAge(18);
        student4.setParentName("LaBhisha");
        student4.setPosition(15);
        student4.setPlace("Buhleni");

        tree.insertStudent(student);
        tree.insertStudent(student1);
        tree.insertStudent(student2);
        tree.insertStudent(student3);
        tree.insertStudent(student4);

        //tree.displayStudent(tree.root);
        System.out.println("IN ODER" + "\n");
        tree.printInOder();
        System.out.println("--------------------------------------------" + "\n");
        System.out.println("PRE ORDER" + "\n");
       tree.printPreOder();
        System.out.println("--------------------------------------------" + "\n");
        System.out.println("POST ODER" + "\n");
       tree.printPostOder();
        System.out.println("--------------------------------------------" + "\n");

        tree.search(234);
        System.out.println("--------------------------------------------" + "\n");
        tree.delete(245);
        System.out.println("--------------------------------------------" + "\n");
        tree.displayStudent(tree.root);
//        tree.printInOder();
//        tree.printPreOder();
//        tree.printPostOder();
    }

}
