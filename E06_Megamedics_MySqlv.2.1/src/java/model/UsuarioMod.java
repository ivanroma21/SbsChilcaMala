package model;

public class UsuarioMod {
    private static String codUser, nomUser, passUser,Template;
    private static int tipoUser;

    public  String getCodUser() {
        return codUser;
    }

    public  void setCodUser(String codUser) {
        this.codUser = codUser;
    }

    public  String getNomUser() {
        return nomUser;
    }

    public  void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public  String getPassUser() {
        return passUser;
    }

    public  void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    public  String getTemplate() {
        return Template;
    }

    public  void setTemplate(String Template) {
        this.Template = Template;
    }

    public  int getTipoUser() {
        return tipoUser;
    }

    public  void setTipoUser(int tipoUser) {
        this.tipoUser = tipoUser;
    }

    
}
