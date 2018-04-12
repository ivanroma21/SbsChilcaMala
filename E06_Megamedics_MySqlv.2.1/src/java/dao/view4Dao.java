package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.view4Model;

public class view4Dao extends Dao{
    
    public List<view4Model> lstProductividadView() throws Exception {
        List<view4Model> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "Select * from 4view";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            view4Model vw4;
            while (rs.next()) {
                vw4 = new view4Model();
                vw4.setCODPSAL(rs.getString("CODPSAL"));
                vw4.setDESC_SERVS(rs.getString("DESC_SERVS"));
                vw4.setNOMBRE(rs.getString("NOMBRE"));
                vw4.setTotal(rs.getString("Total"));
                lista.add(vw4);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    
    public List<view4Model> listProductividad(String a,String b) throws Exception {
        List<view4Model> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "call SP_Productividad ?,?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, a);
            ps.setString(2, b);
            rs = ps.executeQuery();
            lista = new ArrayList();
            view4Model sp4;
            while (rs.next()) {
                sp4 = new view4Model();
                sp4.setCODPSAL(rs.getString("CODPSAL"));
                sp4.setDESC_SERVS(rs.getString("DESC_SERVS"));
                sp4.setNOMBRE(rs.getString("NOMBRE"));
                sp4.setTotal(rs.getString("Total"));
                lista.add(sp4);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
}
