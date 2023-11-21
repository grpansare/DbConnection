import java.sql.*;

public class TestConnection {
    public void test() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver load");
            String url = "jdbc:mysql://localhost:3306/ganeshdb?useSSL=false";
            Connection con = DriverManager.getConnection(url, "root", "@grpansare123");
            System.out.println("Connection obtained " + con);
            String query="select * from stud";
            Statement st=con.createStatement();
//            ResultSet rs=st.executeQuery(query);
//            rs.next();
//            while(rs.next()) {
//                System.out.println(rs.getInt(1) + " " + rs.getString(2));
//            }
//            DML --executeUpdate
//            String insert="insert into stud values(234,'anshul',123)";
//            int rows=st.executeUpdate(insert);
//            System.out.println("rows "+rows +" updated");
//            String q1="select * from stud where name='anshul'";
//            ResultSet rd1=st.executeQuery(q1);
//            rd1.next();
//            System.out.println(rd1.getInt(1)+ " "+rd1.getString(2)+" "+rd1.getInt(3));
            String delete="delete from stud where name='ganesh'";
            int row=st.executeUpdate(delete);
            System.out.println(row+" rows updated");
//            while(rs.next()) {
//                System.out.println(rs.getInt(1) + " " + rs.getString(2));
//            }
            ResultSet rs1=st.executeQuery(query);
            rs1.next();
            while(rs1.next()) {
                System.out.println(rs1.getInt(1) + " " + rs1.getString(2));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        TestConnection e=new TestConnection();
        e.test();
    }

    }

