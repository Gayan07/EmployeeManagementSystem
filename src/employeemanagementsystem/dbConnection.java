package employeemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.Class.forName;

public class dbConnection {

    public static Connection con(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem","root","1234");
            return connection;
        }catch(Exception e) {e.printStackTrace();}
        return null;
    }
}
