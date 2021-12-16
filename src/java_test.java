import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

class pqr extends Exception{
    pqr(String s){
        super(s);
    }
}

class xyz{
    private int rollno;
    private String name;
    private int marks;

    public int getrollno(){
        return rollno;
    }
    public void setrollno(int rollno){
        this.rollno = rollno;
    }
  public String getname(){
        return name;
  }
  public void setname(String name){
        this.name = name;
  }
  public int getmarks(){
        return marks;
  }
  public void setmarks(int marks){
        this.marks = marks;
  }
}

public class java_test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        ArrayList<xyz> l = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
                xyz obj = new xyz();
                {
                    obj.setrollno(sc.nextInt());
                    obj.setname(sc.next());
                    obj.setmarks(sc.nextInt());
                    if(obj.getmarks()>=35){
                        l.add(obj);
                    }else{
                        try {
                            throw new pqr("Not pass");
                        }catch (pqr obj1){
                            System.out.println(obj1.getMessage());
                        }
                    }
              }
        }
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Prac","root","");
        PreparedStatement ps = con.prepareStatement("insert into stu_info values(?,?,?)");
        for (xyz res: l) {
                ps.setInt(1,res.getrollno());
                ps.setString(2,res.getname());
                ps.setInt(3,res.getmarks());
                if(ps.executeUpdate()==1) System.out.println("val inserted");
                else{
                    System.out.println("not inserted");
                }
        }
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("select  * from stu_info");
        while(rs.next()){
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
        }
    }
}
