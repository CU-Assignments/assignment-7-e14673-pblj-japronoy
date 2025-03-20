import java.sql.SQLException;
import java.util.Scanner;

public class StudentView {
    public static void main(String[] args) {
        try {
            StudentController controller = new StudentController();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n1. Add Student\n2. View Students\n3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();

                    controller.addStudent(new Student(id, name, dept, marks));
                    System.out.println("Student added successfully!");
                } else if (choice == 2) {
                    controller.viewStudents();
                } else {
                    System.exit(0);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
