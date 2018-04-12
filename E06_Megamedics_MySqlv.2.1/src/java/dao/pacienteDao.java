package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.pacienteModel;

public class pacienteDao extends Dao{
    
    public void addPacientes(pacienteModel pac) throws Exception {
        try {
            this.conectar();
            String sql = "call addPaciente (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, pac.getCod_establec1());
            ps.setString(2, pac.getHPaciente());
            ps.setString(3, pac.getDNI());
            ps.setDate(4, pac.getFec_nac());
            ps.setString(5, pac.getAp_Paterno());
            ps.setString(6, pac.getAp_Materno());
            ps.setString(7, pac.getNombres());
            ps.setString(8, pac.getSexo());
            ps.setString(9, pac.getEdad());
            ps.setString(10, pac.getTipo_Edad());
            ps.setString(11, pac.getCod_Dpto());
            ps.setString(12, pac.getCod_prov());
            ps.setString(13, pac.getCod_dist());
            ps.setString(14, pac.getDireccion());
            ps.setString(15, pac.getResponsable());
            ps.setString(16, pac.getResponsable());
            ps.setString(17, pac.getEdad_responsable());
            ps.setString(18, pac.getDni_responsable());
            ps.setDate(19, pac.getFec_registro());
            ps.setString(20, pac.getHabilitado());
            ps.setString(21, pac.getTipo_edad_resp());
            ps.setString(22, pac.getVdfrespdigitacion());
            ps.setString(23, pac.getFte_fto());
            ps.setString(24, pac.getEtnia());
            ps.setString(25, pac.getSHClinica());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    

    public List<pacienteModel> listarPacientes() throws Exception {
        List<pacienteModel> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM paciente order by DNI desc";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            pacienteModel lstpac;
            while (rs.next()) {
                lstpac = new pacienteModel();
                lstpac.setCod_establec1(rs.getString("Cod_establec1"));
                lstpac.setHPaciente(rs.getString("HPaciente"));
                lstpac.setDNI(rs.getString("DNI"));
                lstpac.setFec_nac(rs.getDate("Fec_nac"));
                lstpac.setAp_Paterno(rs.getString("Ap_Paterno"));
                lstpac.setAp_Materno(rs.getString("Ap_Materno"));
                lstpac.setNombres(rs.getString("Nombres"));
                lstpac.setSexo(rs.getString("Sexo"));
                lstpac.setEdad(rs.getString("Edad"));
                lstpac.setTipo_Edad(rs.getString("Tipo_Edad"));
                lstpac.setEstado_gestando(rs.getString("Estado_gestando"));
                lstpac.setCod_Dpto(rs.getString("Cod_Dpto"));
                lstpac.setCod_prov(rs.getString("Cod_prov"));
                lstpac.setCod_dist(rs.getString("Cod_dist"));
                lstpac.setDireccion(rs.getString("Direccion"));
                lstpac.setResponsable(rs.getString("responsable"));
                lstpac.setEdad_responsable(rs.getString("edad_responsable"));
                lstpac.setDni_responsable(rs.getString("dni_responsable"));
                lstpac.setFec_registro(rs.getDate("Fec_registro"));
                lstpac.setHabilitado(rs.getString("habilitado"));
                lstpac.setTipo_edad_resp(rs.getString("tipo_edad_resp"));
                lstpac.setVdfrespdigitacion(rs.getString("Vdfrespdigitacion"));
                lstpac.setFte_fto(rs.getString("fte_fto"));
                lstpac.setEtnia(rs.getString("etnia"));
                lstpac.setSHClinica(rs.getString("SHClinica"));
                lista.add(lstpac);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
