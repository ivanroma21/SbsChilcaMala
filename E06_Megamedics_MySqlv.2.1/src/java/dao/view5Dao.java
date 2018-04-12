package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.view5Model;

public class view5Dao extends Dao{
    
    public List<view5Model> lstHCxEnfyUpsview() throws Exception {
        List<view5Model> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "Select * from 5view";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            view5Model vw5;
            while (rs.next()) {
                vw5 = new view5Model();
                vw5.setDNI(rs.getString("DNI"));
                vw5.setPaciente(rs.getString("Paciente"));
                vw5.setDireccion(rs.getString("Direccion"));
                vw5.setFICHAFAM(rs.getString("FICHAFAM"));
                vw5.setSexo(rs.getString("sexo"));
                vw5.setEDAD(rs.getString("EDAD"));
                vw5.setTipo(rs.getString("Tipo"));
                vw5.setDesc_enf(rs.getString("desc_enf"));
                vw5.setDESC_SERVS(rs.getString("DESC_SERVS"));
                vw5.setDESC_ESTAB(rs.getString("DESC_ESTAB"));
                vw5.setDESC_MICRO(rs.getString("DESC_MICRO"));
                vw5.setDESC_RED(rs.getString("DESC_RED"));
                vw5.setANO(rs.getString("ANO"));
                vw5.setFinanciero(rs.getString("Financiero"));
                vw5.setMes(rs.getString("mes"));
                vw5.setDIA(rs.getString("DIA"));
                vw5.setServicio(rs.getString("Servicio"));
                vw5.setNOMBRE(rs.getString("NOMBRE"));
                lista.add(vw5);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
}
