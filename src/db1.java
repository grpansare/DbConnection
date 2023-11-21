import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;

public class db1 {

    public void test(){
        try{
            Connection con=DemoConnection.getConnection();
            Statement st=con.createStatement();
            String sql="select count(id),id from emp group by(id) order by(id)" ;
                    ;
            String insert="insert into emp values(2,'suraj',56666)";
            String delete="delete from emp where name='ganesh'";

//            int rows=st.executeUpdate(delete);
//            System.out.println(rows+" rows updated");
            ResultSet rs=st.executeQuery(sql);
              while(rs.next()){
                  System.out.println(rs.getInt(1)+" "+rs.getInt(2));
              }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new db1().test();
    }
}
