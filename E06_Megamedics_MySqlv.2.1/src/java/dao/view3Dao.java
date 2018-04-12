package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.view3Model;

public class view3Dao extends Dao{
    
    public List<view3Model> lstAtencionesview() throws Exception {
        List<view3Model> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "Select * from 3view";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            view3Model vw3;
            while (rs.next()) {
                vw3 = new view3Model();
                vw3.setHistoria(rs.getString("historia"));
                vw3.setDNI(rs.getString("DNI"));
                vw3.setDESC_ESTAB(rs.getString("DESC_ESTAB"));
                vw3.setDESC_MICRO(rs.getString("DESC_MICRO"));
                vw3.setDESC_RED(rs.getString("DESC_RED"));
                vw3.setDESC_SERVS(rs.getString("DESC_SERVS"));
                vw3.setPaciente(rs.getString("paciente"));
                vw3.setTotal(rs.getString("total"));
                lista.add(vw3);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    
    public List<view3Model> listAtencionesSp(String a,String b,String c,String d) throws Exception {
        List<view3Model> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "call SP_Atenciones ?,?,?,?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, a);
            ps.setString(2, b);
            ps.setString(3, c);
            ps.setString(4, d);
            rs = ps.executeQuery();
            lista = new ArrayList();
            view3Model sp3;
            while (rs.next()) {
                sp3 = new view3Model();
                sp3.setHistoria(rs.getString("historia"));
                sp3.setDNI(rs.getString("DNI"));
                sp3.setDESC_ESTAB(rs.getString("DESC_ESTAB"));
                sp3.setDESC_MICRO(rs.getString("DESC_MICRO"));
                sp3.setDESC_RED(rs.getString("DESC_RED"));
                sp3.setDESC_SERVS(rs.getString("DESC_SERVS"));
                sp3.setPaciente(rs.getString("paciente"));
                sp3.setTotal(rs.getString("total"));                
                lista.add(sp3);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
}
