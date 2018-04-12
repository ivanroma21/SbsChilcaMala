package controller;

import dao.view5Dao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.view5Model;

@ManagedBean
@SessionScoped
public class view5Controller implements Serializable {

    private List<view5Model> lstVw52;
    private List<view5Model> lstVw5;
    private List<view5Model> lstSp;

    view5Model vwSP5 = new view5Model();
    private String ups;
    private String personal;

    @PostConstruct
    public void inicio() {
        try {
            listarVW();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void listarVW() throws Exception {
        view5Dao dao;
        try {
            dao = new view5Dao();
            lstVw5 = dao.lstHCxEnfyUpsview();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<view5Model> getLstVw5() {
        return lstVw5;
    }

    public void setLstVw5(List<view5Model> lstVw5) {
        this.lstVw5 = lstVw5;
    }

    public List<view5Model> getLstSp() {
        return lstSp;
    }

    public void setLstSp(List<view5Model> lstSp) {
        this.lstSp = lstSp;
    }

    public view5Model getVwSP5() {
        return vwSP5;
    }

    public void setVwSP5(view5Model vwSP5) {
        this.vwSP5 = vwSP5;
    }

    public List<view5Model> getLstVw52() {
        return lstVw52;
    }

    public void setLstVw52(List<view5Model> lstVw52) {
        this.lstVw52 = lstVw52;
    }

}
