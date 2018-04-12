package Servicios;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import model.UsuarioMod;

@Named(value = "seguridad")
@SessionScoped
public class Seguridad implements Serializable {

    static UsuarioMod us = new UsuarioMod();
    
    public void denegar() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public UsuarioMod getUs() {
        return us;
    }

    public void setUs(UsuarioMod us) {
        Seguridad.us = us;
    }
    
}
