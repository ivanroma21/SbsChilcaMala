package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.view1Model;

public class view1Dao extends Dao{
    public List<view1Model> lstHCview() throws Exception {
        List<view1Model> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "Select * from 1view";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            view1Model vw1;
            while (rs.next()) {
                vw1 = new view1Model();
                vw1.setDNI(rs.getString("DNI"));
                vw1.setData_pac(rs.getString("Data_pac"));
                vw1.setDireccion(rs.getString("Direccion"));
                vw1.setHISTORIA(rs.getString("HISTORIA"));
                vw1.setEDAD(rs.getInt("EDAD"));
                vw1.setTipo(rs.getString("Tipo"));
                vw1.setDesc_enf(rs.getString("Desc_enf"));
                vw1.setDESC_SERVS(rs.getString("DESC_SERVS"));
                vw1.setDESC_ESTAB(rs.getString("DESC_ESTAB"));
                vw1.setDESC_MICRO(rs.getString("DESC_MICRO"));
                vw1.setDESC_RED(rs.getString("DESC_RED"));
                vw1.setANO(rs.getInt("ANO"));
                vw1.setMes(rs.getString("Mes"));
                vw1.setDIA(rs.getInt("DIA"));
                vw1.setNOMBRE(rs.getString("NOMBRE"));
                lista.add(vw1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    public List<view1Model> lstHCview2() throws Exception {
        List<view1Model> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "Select * from 1view";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            view1Model vw1;
            while (rs.next()) {
                vw1 = new view1Model();
                vw1.setDNI(rs.getString("DNI"));
                vw1.setData_pac(rs.getString("Data_pac"));
                vw1.setDireccion(rs.getString("Direccion"));
                vw1.setHISTORIA(rs.getString("HISTORIA"));
                vw1.setEDAD(rs.getInt("EDAD"));
                vw1.setTipo(rs.getString("Tipo"));
                vw1.setDesc_enf(rs.getString("Desc_enf"));
                vw1.setDESC_SERVS(rs.getString("DESC_SERVS"));
                vw1.setDESC_ESTAB(rs.getString("DESC_ESTAB"));
                vw1.setDESC_MICRO(rs.getString("DESC_MICRO"));
                vw1.setDESC_RED(rs.getString("DESC_RED"));
                vw1.setANO(rs.getInt("ANO"));
                vw1.setMes(rs.getString("Mes"));
                vw1.setDIA(rs.getInt("DIA"));
                vw1.setNOMBRE(rs.getString("NOMBRE"));
                lista.add(vw1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    
    public List<view1Model> listHCsp(String a,String b) throws Exception {
        List<view1Model> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "call SP_HC1 ?,?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, a);
            ps.setString(2, b);
            rs = ps.executeQuery();
            lista = new ArrayList();
            view1Model sp1;
            while (rs.next()) {
                sp1 = new view1Model();
                sp1.setDNI(rs.getString("DNI"));
                sp1.setData_pac(rs.getString("Data_pac"));
                sp1.setDireccion(rs.getString("Direccion"));
                sp1.setHISTORIA(rs.getString("HISTORIA"));
                sp1.setEDAD(rs.getInt("EDAD"));
                sp1.setTipo(rs.getString("Tipo"));
                sp1.setDesc_enf(rs.getString("Desc_enf"));
                sp1.setDESC_SERVS(rs.getString("DESC_SERVS"));
                sp1.setDESC_ESTAB(rs.getString("DESC_ESTAB"));
                sp1.setDESC_MICRO(rs.getString("DESC_MICRO"));
                sp1.setDESC_RED(rs.getString("DESC_RED"));
                sp1.setANO(rs.getInt("ANO"));
                sp1.setMes(rs.getString("Mes"));
                sp1.setDIA(rs.getInt("DIA"));
                sp1.setNOMBRE(rs.getString("NOMBRE"));
                lista.add(sp1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
}
