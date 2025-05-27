package Conexion;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion { 
    private static Properties config = new Properties();
    
    static {
        try(InputStream in = Conexion.class.getResourceAsStream("dbconfigProyecto_Final_v2.properties")){
            if(in == null){
                throw new IOException("Archivo Properties no encontrado");
            }
            config.load(in);
        }catch (IOException ex){
            System.out.println("Error en el Archivo configurativo de conexion:" + ex.getMessage());
        }
    }
    
    public Connection getConnection() throws SQLException{
        String hostname = config.getProperty("hostname");
        String port = config.getProperty("port");
        String database = config.getProperty("database");
        String username = config.getProperty("username");
        String password = config.getProperty("password");
    
        String jdbcUrl = "jdbc:postgresql://"+hostname+":"+port+"/"+database;
    
    Connection conn = DriverManager.getConnection(jdbcUrl,username,password);
    System.out.println("Conexion establecida con:"+ database);
    return conn;
    } 
}


