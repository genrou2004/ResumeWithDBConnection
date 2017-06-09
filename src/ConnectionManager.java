
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
    
    Connection con;
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost/Employee","root","root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
        
    }
    
    public void outSkillSet(){
        String sql = "SELECT * FROM SkillSet";
        try{
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);
   while (result.next()){
       String name = result.getString(2);
       String pass = result.getString(3);
       String fullname = result.getString("fullname");
       String email = result.getString("email");
    
       String output = "User #%d: %s - %s - %s - %s";
       //System.out.println(String.format(output, ++count, name, pass, fullname, email));
   }
        }catch(Exception e){
       e.getStackTrace();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
