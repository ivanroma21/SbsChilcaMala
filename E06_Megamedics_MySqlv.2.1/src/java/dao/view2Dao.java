package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.view2Model;

public class view2Dao extends Dao{
    
    public List<view2Model> lstAtedidosview() throws Exception {
        List<view2Model> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "Select * from 2view";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            view2Model vw2;
            while (rs.next()) {
                vw2 = new view2Model();
                vw2.setCOD_ESTAB(rs.getString("COD_ESTAB"));
                vw2.setDESC_ESTAB(rs.getString("DESC_ESTAB"));
                vw2.setDESC_MICRO(rs.getString("DESC_MICRO"));
                vw2.setDESC_RED(rs.getString("DESC_RED"));
                vw2.setCOD_SERVSA(rs.getString("COD_SERVSA"));
                vw2.setDESC_SERVS(rs.getString("DESC_SERVS"));
                vw2.setTotal(rs.getString("total"));
                lista.add(vw2);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    
    public List<view2Model> listAtendidos(String a,String b,String c, String d) throws Exception {
        List<view2Model> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "call SP_Atendidos ?,?,?,?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, a);
            ps.setString(2, b);
            ps.setString(3, c);
            ps.setString(4, d);
            rs = ps.executeQuery();
            lista = new ArrayList();
            view2Model sp2;
            while (rs.next()) { 
                sp2 = new view2Model();
                sp2.setCOD_ESTAB(rs.getString("COD_ESTAB"));
                sp2.setDESC_ESTAB(rs.getString("DESC_ESTAB"));
                sp2.setDESC_MICRO(rs.getString("DESC_MICRO"));
                sp2.setDESC_RED(rs.getString("DESC_RED"));
                sp2.setCOD_SERVSA(rs.getString("COD_SERVSA"));
                sp2.setDESC_SERVS(rs.getString("DESC_SERVS"));
                sp2.setTotal(rs.getString("total"));
                lista.add(sp2);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    
    
}
