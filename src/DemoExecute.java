//import java.sql.Connection;
//import java.sql.Statement;
import java.sql.*;

public class DemoExecute {

    public DemoExecute(){
       Connection con;
        try{
            con=DemoConnection.getConnection();
            String sql="select * from stud";
//            String update ="update stud set age=21 where age=20";
            String insert="insert into stud values(6,'shoaib',21)";

            Statement st=con.createStatement();
            boolean ans=st.execute(sql);
            if(ans){
                ResultSet rs=st.getResultSet();
                while(rs.next()){
                    System.out.println(rs.getInt(1) + " " + rs.getString(2)+" "+rs.getInt(3));

                }
            }else{
                int rows=st.getUpdateCount();
                System.out.println(rows+" rows updated");

            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new  DemoExecute();
    }
}
