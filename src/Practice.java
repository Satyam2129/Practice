import java.sql.*;
import java.util.Scanner;

class abc{
    Scanner sc = new Scanner(System.in);
    public void insert() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","");
        PreparedStatement ps = con.prepareStatement("Insert into student_details values (?,?,?)");
        ps.setInt(1,sc.nextInt());
        ps.setString(2,sc.next());
        ps.setString(3,sc.next());
        if(ps.executeUpdate()==1)
            System.out.println("val inserted");
        else
            System.out.println("val not inserted");
    }
    public void delete() throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","");
        PreparedStatement ps1 = con.prepareStatement("delete from student_details where sid = (?)");
        ps1.setInt(1,sc.nextInt());
        if(ps1.executeUpdate()==1) System.out.println("val deleted succesfully");else System.out.println("val not deleted");
    }
    public void show() throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","");
        PreparedStatement ps3 = con.prepareStatement("select * from student_details");
        ResultSet rs = ps3.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
        }
    }
        }

public class Practice {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        abc obj = new abc();
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 for insertion."+"\nPress 2 for deletion."+"\nPress 3 from table view.");
        int n = sc.nextInt();
        if(n==1) {
            obj.insert();
        }
        else if(n==2){
            obj.delete();
        }
        else if(n==3){
            obj.show();
        }
        else{
            System.out.println("invalid input");
        }
    }
}
