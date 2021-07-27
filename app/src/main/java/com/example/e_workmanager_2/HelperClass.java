package com.example.e_workmanager_2;

public class HelperClass {

    // public static int NumeroPapel = 0;
    // public static int positionBotella = 0;
    public static boolean cartaescribirleer = true;

    //creamos objeto con los datos del cliente para enviar a server y dar de alta.
    public static DatosJSON_usuario datosJSONUsuario;

    //Aquí vendrán los datos del usuario para recogerlos y enviarlos al server.
    //La clase donde está la entrada de datos email y password es: MainActivityRegistro
    public static String name= "";
    public static int typeConnection;//tipo conexion con server, alta (0), envio botella(1) etc.
    public static String password ="";
    public static String password2 ="";
    public static String firma ="";
    public static String email ="";
    public static String newPassword="";
    public static String newFirma="";
    public static String newName="";


    //creamos objeto con los datos de la botella para enviar a server.
    //public static DatosJSON_botella datosJSON_botella;

    public static String titulo="";
    public static String texto="";
    public static int NumeroPapel= 0;
    public static int positionBotella = 0;

    //Nombre base datos SQLite
    public static String BD_NAME = "mi_BDD";

    //Futuro Idiomas
    //  public static ArrayList<Languages> languages = new ArrayList<>();

}
