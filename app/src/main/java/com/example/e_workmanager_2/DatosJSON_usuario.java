package com.example.e_workmanager_2;

public class DatosJSON_usuario {

    private String name="";
    private String email="";
    private String firma="";
    private String password="";
    private int typeConnection;
    private String newPassword="";
    private String newFirma="";
    private String newName="";

    public DatosJSON_usuario(String name, String email, String firma, String password, int typeConnection, String newPassword, String newFirma, String newName) {
        this.name = name;
        this.email = email;
        this.firma = firma;
        this.password = password;
        this.typeConnection = typeConnection;
        this.newPassword = newPassword;
        this.newFirma = newFirma;
        this.newName = newName;
    }

    public DatosJSON_usuario() {
    }

    @Override
    public String toString() {
        return "DatosJSON_usuario{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", firma='" + firma + '\'' +
                ", password='" + password + '\'' +
                ", typeConnection=" + typeConnection +
                ", newPassword='" + newPassword + '\'' +
                ", newFirma='" + newFirma + '\'' +
                '}';
    }

}
