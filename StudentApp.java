import java.sql.*;
import java.util.Scanner;

public class StudentApp {

    // connection code is the heart of JDBC
    static final String URL = "jdbc:mysql://localhost:3306/studentenrollmentms";
    static final String USER = "root";
    static final String PASSWORD = "Tech@STORE#26";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("DB Connection Failed: " + e.getMessage());
        }

        return con;

    }

    // Adding student in our database
    public static void addStudent(int id, String name, String email, String course) {
        try {
            Connection con = getConnection();
            String sql = "INSERT INTO student VALUE (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, course);

            ps.executeUpdate();
            System.out.println("Student added Successfully");

            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Read or display all students
    public static void viewStudent() {
        try {
            Connection con = getConnection();
            String sql = "SELECT * FROM student";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("ID | Name | Email | Course");
            System.out.println("---------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("email") + " | " +
                                rs.getString("course"));
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Unable to fetch the Student details" + e.getMessage());
        }
    }

    // Update - update student details ( right now email)
    public static void updateStudent(int id, String email, String name) {
        try {
            Connection con = getConnection();
            String sql = "UPDATE student SET email=? , name=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, name);
            ps.setInt(3, id);

            ps.executeUpdate();
            System.out.println("Student Updated Successfully");

            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println("No student found with given ID " + e.getMessage());
        }
    }

    // Delete - Remove Student
    public static void deleteStudent(int id) {
        try {
            Connection con = getConnection();
            String sql = "DELETE FROM student WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Student Deleted !");

            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Not found the student with this id" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n=====--------- Student Enrollment Management System -----------=====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    addStudent(id, name, email, course);
                    break;

                case 2:
                    viewStudent();
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int upId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    updateStudent(upId, newEmail, newName);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();

                    deleteStudent(delId);
                    break;

                case 5:
                    System.out.println("Ab aur admission nahi chahiye");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();

    }

}