package Servicios;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@Named(value = "validaciones")
@SessionScoped
public class Validaciones implements Serializable {

    public void soloLetras(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
        if (((String) arg2).matches("[0-9]*")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Solo Letras", ""));
        }
    }

    public void soloNumeros(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
        if (!((String) arg2).matches("[0-9]*")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Solo Numeros", ""));
        }
    }

    public void DNI(FacesContext arg0, UIComponent arg1, Object arg2) throws Exception {
        if (((String) arg2).length() > 8) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_FATAL, "DNI", "Ingrese solo 8 caracteres"));
        } else if (((String) arg2).length() < 8) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_FATAL, "DNI", "Ingrese 8 caracteres"));
        } else if (!((String) arg2).matches("[0-9]*")) {
            throw new ValidatorException(new FacesMessage("Solo Numeros"));
        }
    }

    public void tamaño(FacesContext arg0, UIComponent arg1, Object arg2) throws Exception {
        if (((String) arg2).length() != 8) {
            throw new ValidatorException(new FacesMessage("Solo 8 caracteres"));
        } else if (!((String) arg2).matches("[0-9]*")) {
            throw new ValidatorException(new FacesMessage("Solo Numeros"));
        }
    }

}
