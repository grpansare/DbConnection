
import java.sql.*;

public class DemoMetaDate {
    public DemoMetaDate(){
        try{
            Connection con=DemoConnection.getConnection();
            String sql="select * from stud";
            Statement st=con.createStatement();
            boolean ans=st.execute(sql);
            if(ans){
                ResultSet rs=st.getResultSet();
                ResultSetMetaData rsmd=rs.getMetaData();
                System.out.println("getcolumn count "+rsmd.getColumnCount());
                for(int i=1;i<=rsmd.getColumnCount();i++){
                    System.out.print(rsmd.getColumnName(i)+" ");
                    System.out.println(rsmd.getColumnTypeName(i));
                }
                while(rs.next()){
                    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));

                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DemoMetaDate md=new DemoMetaDate();

    }
}
