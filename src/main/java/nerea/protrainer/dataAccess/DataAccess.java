
package nerea.protrainer.dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* @author Nerea
*/

public class DataAccess {
    
    public static Connection getConnection(){
        Connection connection = null;   
        Properties properties=new Properties(); 

        try {
            properties.load(DataAccess.class.getClassLoader().getResourceAsStream("properties/application.properties"));  
            String connectionUrl=properties.getProperty("connectionUrl"); 
            connection = DriverManager.getConnection(connectionUrl);  
          
        } catch (Exception e) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return connection;
    }

}
