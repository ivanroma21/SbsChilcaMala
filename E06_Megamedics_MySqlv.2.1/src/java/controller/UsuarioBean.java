package controller;

import dao.UsuarioDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.UsuarioMod;

@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

    private List<UsuarioMod> lstUs;
    private UsuarioMod selectUs;
    static private UsuarioMod Us = new UsuarioMod();
    private UsuarioDao usdao = new UsuarioDao();

    private String User;
    private String Pass;

//    public String inicio() {
//        try {
//            if (usdao.inicioSesion(Us) != 0) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bienvenido"));
//                return "/faces/vistas/index.xhtml";
//            } else {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario/Contraseña incorrecta"));
//            }
//        } catch (SQLException e) {
//        }
//        return null;
//    }
    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void listar() throws Exception {
        UsuarioDao dao;
        try {
            dao = new UsuarioDao();
            lstUs = dao.listar();
        } catch (Exception e) {
        }
    }

    public void logearse() throws Exception {
        try {
            Us = usdao.logeo(User);
            if (Us == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "Usuario incorrecto"));
            } else {
                if (Us.getPassUser().equals(Pass)) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
                }else{
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "Contraseña incorrecta"));
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void addPaciente() throws SQLException, Exception {
        UsuarioDao dao;
        try {
            dao= new UsuarioDao();
            dao.agregarPac(selectUs);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ingresado"));
            listar();
//            limpiar();
        } catch (SQLException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error " + e));
            System.out.println("Error " + e);
        }

    }

    public UsuarioMod getUs() {
        return Us;
    }

    public void setUs(UsuarioMod Us) {
        this.Us = Us;
    }

    public UsuarioDao getUsdao() {
        return usdao;
    }

    public void setUsdao(UsuarioDao usdao) {
        this.usdao = usdao;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public List<UsuarioMod> getLstUs() {
        return lstUs;
    }

    public void setLstUs(List<UsuarioMod> lstUs) {
        this.lstUs = lstUs;
    }

    public UsuarioMod getSelectUs() {
        return selectUs;
    }

    public void setSelectUs(UsuarioMod selectUs) {
        this.selectUs = selectUs;
    }

}
