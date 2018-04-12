package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
    
     private Connection cn ;

    public void conectar() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://LocalHost/datanv", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
   
    public static Connection ConectarReporte() throws ClassNotFoundException {
        String url = "jdbc:mysql://LocalHost/datanv";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection link = DriverManager.getConnection(url, "root", "root");
            return link;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error de conexion " + e + "error de conexion ");
        }
        return null;
    }
    
     public void Cerrar() throws SQLException {      //Cerrar la coneccion
        if (cn != null) {
            if (cn.isClosed() == false) {
                cn.close();
            }
        }
    }

     public static void main(String[] args) throws Exception {
        Dao dao = new Dao();
        dao.conectar();
        if(dao.getCn()!=null){
            System.out.println("conectado");
        }else{
            System.out.println("error");
        }
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
}
