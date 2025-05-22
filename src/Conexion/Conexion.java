package Conexion;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion { 
    static Properties config = new Properties();
    //String path = "C:\\Proyecto_Final_Grupo_5_Antigua_UMG\\Proyecto_Final_Grupo_5_Antigua_UMG\\src\\Conexion\\dbconfigProyecto_Final.properties";
    String path = "C:\\Proyecto_Final_Grupo_5_Antigua_UMG\\Proyecto_Final_Grupo_5_Antigua_UMG\\src\\Conexion\\dbconfigProyecto_Final_v2.properties";
    
    public Conexion(){
        try(InputStream in = Files.newInputStream(Paths.get(path))){
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


