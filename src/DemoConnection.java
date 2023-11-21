import java.sql.Connection;
import java.sql.DriverManager;

public class DemoConnection {
    public  static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ganeshdb?useSSL=false";
             con = DriverManager.getConnection(url, "root", "@grpansare123");
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
