package com.example.e_workmanager_2;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionServer {

    public static void connetionServer2(){
        log("Entra en la conexion.....................................");
        Boolean connexion_OK = false;
        int tipoConnection = 10;
        String ip = "LaiFel.asuscomm.com";
        int puerto = 5556;
        Gson gson = new Gson();
        try {
            log("Entra en try.....................................");
            Socket sk = new Socket(ip, puerto);
            log("despues de socket.....................................");
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(sk.getInputStream()));
            log("despues de entrada.....................................");
            PrintWriter salida = new PrintWriter(
                    new OutputStreamWriter(sk.getOutputStream()), true);
            log("Comprobando tipo conexión = " + tipoConnection);
            //Envio de datos a Server. El cero (0) indica al server que es comprobacion no repetido email (ver Helperclass).
            //HelperClass.typeConnection = tipoConnection;
            //HelperClass.datosJSONUsuario = new DatosJSON_usuario(HelperClass.name, HelperClass.email, HelperClass.firma, HelperClass.password, HelperClass.typeConnection, HelperClass.newPassword, HelperClass.newFirma, HelperClass.newName);
            DatosJSON_usuario datosJSONUsuario = new DatosJSON_usuario("12345", " ", " ", " ", tipoConnection, " "," ", " ");
            String json = gson.toJson(HelperClass.datosJSONUsuario);
            salida.println(json);
            String recepcionServer = entrada.readLine();
            log("Recibiendo del Server: " + recepcionServer);
            //Para conexion de envio botella

            sk.close();
            if(recepcionServer.equals("ERROR")) {
                log("Error tipo de conexion = " + tipoConnection);
            }
            else {
                connexion_OK=true;
            }
        } catch (Exception e) {
            log("Error conexion Server............................................" + e.toString());
        }
    }

    private static void log(String string) {//Salida por consola de la comunicacion con server
        //output.append(string + "\n"); output seria por ejemplo un : private TextView output;
        System.out.println(string);
    }

}
