import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;

public class DemoPreparedStatement {
    Connection con=DemoConnection.getConnection();
       public void display(){
           try {
               String sql = "select * from stud";
               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery(sql);
               while (rs.next()) {
                   System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));

               }
           }catch(Exception e){
               e.printStackTrace();
           }
       }
//    public void insertDate(int id,String name,int age){
public void insertDate(int id,String name,int age){

    try(Connection con=DemoConnection.getConnection()){
            con.setAutoCommit(false);
//            PreparedStatement pstat=con.prepareStatement("insert into stud values(?,?,?)");
            PreparedStatement pstat=con.prepareStatement("insert into stud values(?,?,?)");
         pstat.setInt(1,id);
            pstat.setString(2,name);
            pstat.setInt(3,age);
//            pstat.setInt(3,age);
            int rows=pstat.executeUpdate();
            System.out.println(rows+" rows updated");


            con.commit();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DemoPreparedStatement p = new DemoPreparedStatement();

//        System.out.println("what do you want tot do");
//        System.out.println("1.insert 2.update 3.delete");
//        int ch = sc.nextInt();



                System.out.println("enter name");
                String name = sc.nextLine();
                System.out.println("enter id");
                int id = sc.nextInt();
                System.out.println("entter age");
                int age = sc.nextInt();
                p.insertDate(id,name,age);
//                String oldName=sc.next();
//                p.insertDate(newname,oldName);
         p.display();
    }}
