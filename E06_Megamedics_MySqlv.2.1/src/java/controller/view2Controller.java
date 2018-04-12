package controller;

import dao.view2Dao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.view2Model;

@ManagedBean
@SessionScoped
public class view2Controller implements Serializable{
    
    private List<view2Model> lstSp;
    private List<view2Model> lstvw;
    private List<view2Model> lstvw2;
    
    view2Model vwSP2 = new view2Model();
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
        view2Dao dao;
        try {
            dao = new view2Dao();
            lstvw = dao.lstAtedidosview();
        } catch (Exception e) {
            throw e;
        }
    }

     public void listSP() throws Exception {
        view2Dao dao;
        try {
            dao = new view2Dao();
            lstSp = dao.listAtendidos(ups, estab,micro,red);
        } catch (Exception e) {
            throw e;
        }

    }
    
    public List<view2Model> getLstSp() {
        return lstSp;
    }

    public void setLstSp(List<view2Model> lstSp) {
        this.lstSp = lstSp;
    }

    public String getUps() {
        return ups;
    }

    public void setUps(String ups) {
        this.ups = ups;
    }

    public view2Model getVwSP2() {
        return vwSP2;
    }

    public void setVwSP2(view2Model vwSP2) {
        this.vwSP2 = vwSP2;
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

    public List<view2Model> getLstvw() {
        return lstvw;
    }

    public void setLstvw(List<view2Model> lstvw) {
        this.lstvw = lstvw;
    }

    public List<view2Model> getLstvw2() {
        return lstvw2;
    }

    public void setLstvw2(List<view2Model> lstvw2) {
        this.lstvw2 = lstvw2;
    }

    
    
    
}
