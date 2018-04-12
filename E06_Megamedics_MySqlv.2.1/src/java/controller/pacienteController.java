package controller;

import dao.pacienteDao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.pacienteModel;

@ManagedBean
@SessionScoped
public class pacienteController implements Serializable {
    private List<pacienteModel> lstpacientes;
    private List<pacienteModel> lstpacientes2;
    pacienteModel paciente = new pacienteModel();
    pacienteDao dao = new pacienteDao();
    private pacienteModel selected;
    
    @PostConstruct
    public void inicio() {
        try {
            listarPacientes();
        } catch (Exception e) {
        }
    }
    
    
    
    public void listarPacientes() throws Exception {
        try {
            lstpacientes = dao.listarPacientes();
        } catch (Exception e) {
            throw e;
        }
    }
    
     public void addTramite() throws Exception {
        try {
            dao.addPacientes(paciente);
            listarPacientes();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto", "Paciente Ingresado"));
        } catch (Exception e) {
            throw e;
        }
    }
     
     public void limpiar() {
        try {
            paciente = new pacienteModel();
        } catch (Exception e) {
        }
    }
    
      public void preparedPacientes() throws Exception {
        selected = new pacienteModel();
    }

    public List<pacienteModel> getLstpacientes() {
        return lstpacientes;
    }

    public void setLstpacientes(List<pacienteModel> lstpacientes) {
        this.lstpacientes = lstpacientes;
    }

    public pacienteModel getPaciente() {
        return paciente;
    }

    public void setPaciente(pacienteModel paciente) {
        this.paciente = paciente;
    }

    public pacienteModel getSelected() {
        return selected;
    }

    public void setSelected(pacienteModel selected) {
        this.selected = selected;
    }

    public pacienteDao getDao() {
        return dao;
    }

    public void setDao(pacienteDao dao) {
        this.dao = dao;
    }

    public List<pacienteModel> getLstpacientes2() {
        return lstpacientes2;
    }

    public void setLstpacientes2(List<pacienteModel> lstpacientes2) {
        this.lstpacientes2 = lstpacientes2;
    }
    
    
}
