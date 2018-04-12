package controller;

import dao.view4Dao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.view4Model;

@ManagedBean
@SessionScoped
public class view4Controller implements Serializable{
    private List<view4Model> lstvw4;
    private List<view4Model> lstvw42;
    private List<view4Model> lstSp;
    
    view4Model vwSP4 = new view4Model();
    private String ups;
    private String personal;

    @PostConstruct
    public void inicio(){
        try {
            listarVW();
        } catch (Exception e) {
            System.out.println(e);
        }
 
    }
    
    public void listarVW() throws Exception {
        view4Dao dao;
        try {
            dao = new view4Dao();
            lstvw4 = dao.lstProductividadView();
        } catch (Exception e) {
            throw e;
        }
    }
    
    
     public void listSP() throws Exception {
        view4Dao dao;
        try {
            dao = new view4Dao();
            lstSp = dao.listProductividad(ups, personal);
        } catch (Exception e) {
            throw e;
        }

    }
    
    public List<view4Model> getLstSp() {
        return lstSp;
    }

    public void setLstSp(List<view4Model> lstSp) {
        this.lstSp = lstSp;
    }

    public view4Model getVwSP4() {
        return vwSP4;
    }

    public void setVwSP4(view4Model vwSP4) {
        this.vwSP4 = vwSP4;
    }

    public String getUps() {
        return ups;
    }

    public void setUps(String ups) {
        this.ups = ups;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public List<view4Model> getLstvw4() {
        return lstvw4;
    }

    public void setLstvw4(List<view4Model> lstvw4) {
        this.lstvw4 = lstvw4;
    }

    public List<view4Model> getLstvw42() {
        return lstvw42;
    }

    public void setLstvw42(List<view4Model> lstvw42) {
        this.lstvw42 = lstvw42;
    }
    
    
}
