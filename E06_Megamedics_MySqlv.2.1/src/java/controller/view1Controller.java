package controller;

import dao.view1Dao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.view1Model;

@ManagedBean
@SessionScoped
public class view1Controller implements Serializable{
    private List<view1Model> lstvw;
    private List<view1Model> lstvw2;
    private List<view1Model> lstsp;
    
    view1Model vwSP = new view1Model();
    
    private String historia;
    private String dni;

    @PostConstruct
    public void inicio(){
        try {
            listarVW();
        } catch (Exception e) {
            System.out.println(e);
        }
 
    }
    
    public void listarVW() throws Exception {
        view1Dao dao;
        try {
            dao = new view1Dao();
            lstvw = dao.lstHCview();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listarVW2() throws Exception {
        view1Dao dao;
        try {
            dao = new view1Dao();
            lstvw2 = dao.lstHCview2();
        } catch (Exception e) {
            throw e;
        }
    }
    
       public void listSP() throws Exception {
        view1Dao dao;
        try {
            dao = new view1Dao();
            lstsp = dao.listHCsp(historia,dni);
        } catch (Exception e) {
            throw e;
        }

    }
    
    
    public List<view1Model> getLstvw() {
        return lstvw;
    }

    public void setLstvw(List<view1Model> lstvw) {
        this.lstvw = lstvw;
    }

    public List<view1Model> getLstsp() {
        return lstsp;
    }

    public void setLstsp(List<view1Model> lstsp) {
        this.lstsp = lstsp;
    }

    public view1Model getVwSP() {
        return vwSP;
    }

    public void setVwSP(view1Model vwSP) {
        this.vwSP = vwSP;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<view1Model> getLstvw2() {
        return lstvw2;
    }

    public void setLstvw2(List<view1Model> lstvw2) {
        this.lstvw2 = lstvw2;
    }
    
    
}
