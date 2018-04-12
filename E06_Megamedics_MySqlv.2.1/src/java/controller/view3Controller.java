package controller;

import dao.view3Dao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.view3Model;

@ManagedBean
@SessionScoped
public class view3Controller implements Serializable {

    private List<view3Model> lstvw32;
    private List<view3Model> lstvw3;
    private List<view3Model> lstSp;

    view3Model vwSP3 = new view3Model();
    private String ups;
    private String estab;
    private String micro;
    private String red;

    
    @PostConstruct
    public void inicio(){
        try {
            listarVW();
        } catch (Exception e) {
            System.out.println(e);
        }
 
    }
    
    public void listarVW() throws Exception {
        view3Dao dao;
        try {
            dao = new view3Dao();
            lstvw3 = dao.lstAtencionesview();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listSP() throws Exception {
        view3Dao dao;
        try {
            dao = new view3Dao();
            lstSp = dao.listAtencionesSp(ups, estab, micro, red);
        } catch (Exception e) {
            throw e;
        }

    }

    public List<view3Model> getLstSp() {
        return lstSp;
    }

    public void setLstSp(List<view3Model> lstSp) {
        this.lstSp = lstSp;
    }

    public view3Model getVwSP3() {
        return vwSP3;
    }

    public void setVwSP3(view3Model vwSP3) {
        this.vwSP3 = vwSP3;
    }

    public String getUps() {
        return ups;
    }

    public void setUps(String ups) {
        this.ups = ups;
    }

    public String getEstab() {
        return estab;
    }

    public void setEstab(String estab) {
        this.estab = estab;
    }

    public String getMicro() {
        return micro;
    }

    public void setMicro(String micro) {
        this.micro = micro;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public List<view3Model> getLstvw3() {
        return lstvw3;
    }

    public void setLstvw3(List<view3Model> lstvw3) {
        this.lstvw3 = lstvw3;
    }

    public List<view3Model> getLstvw32() {
        return lstvw32;
    }

    public void setLstvw32(List<view3Model> lstvw32) {
        this.lstvw32 = lstvw32;
    }

}
