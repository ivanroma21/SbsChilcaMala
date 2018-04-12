package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.UsuarioMod;

public class UsuarioDao extends Dao{
    static UsuarioMod us = new UsuarioMod();
    
//    public int inicioSesion (UsuarioMod user) throws SQLException{
//        this.conectar();
//        int ingreso = 0;
//        try {
//            String sql = "exec logeo ?,?";
//            PreparedStatement ps = this.getCn().prepareStatement(sql);
//            ps.setString(1,user.getNomUser());
//            ps.setString(2,user.getPassUser());
//            ResultSet rs = ps.executeQuery();
//            
//            if (rs.next()){
//                ingreso = Integer.parseInt(rs.getString(1));
//            }
//        } catch (NumberFormatException | SQLException e) {
//            System.out.println("Error" + e);
//        }
//        return ingreso;
//    }
    
    public UsuarioMod logeo (String Us) throws Exception{
        UsuarioMod User = new UsuarioMod();
        this.conectar();
        try {
            String sql = "Select * from Usuario where nomUser like ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1,Us);
            ResultSet rs = ps.executeQuery();            
            if (rs.next()){                
                User.setNomUser(rs.getString("nomUser"));
                User.setPassUser(rs.getString("passUser"));
                User.setTipoUser(rs.getInt("tipoUser"));
                switch(User.getTipoUser()){
                    case 1:
                        User.setTemplate("Template.xhtml");
                        break;
                    case 2:
                        User.setTemplate("Template_user.xhtml");
                        break;
                }
            }
            return User;
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Error" + e);
            return null;
        }
    }
    public List<UsuarioMod> listar() throws Exception {
        List<UsuarioMod> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "select * from vw_User";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                UsuarioMod usmo = new UsuarioMod();
                usmo.setCodUser(rs.getString("codUser"));
                usmo.setNomUser(rs.getString("nomUser"));
                usmo.setPassUser(rs.getString("passUser"));
                usmo.setTipoUser(rs.getInt("tipoUser"));                
                lista.add(usmo);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }    
    
    public void agregarPac(UsuarioMod pac) throws SQLException, ClassNotFoundException {
        this.conectar();
        try {
            String sql = "insert into Usuario values (?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, pac.getCodUser());
            ps.setString(2, pac.getNomUser());
            ps.setString(3, pac.getPassUser());
            ps.setInt(4, pac.getTipoUser());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
    }
    
    
}
