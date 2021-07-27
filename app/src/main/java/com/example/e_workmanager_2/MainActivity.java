package com.example.e_workmanager_2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void cancelar_Tarea(String tag) {
        WorkManager.getInstance(this).cancelAllWorkByTag(tag);
    }

    public void IniciarTarea(View view) {
        Constraints constraints = new Constraints.Builder().setRequiresCharging(true).setRequiredNetworkType(NetworkType.UNMETERED).build();
        Toast.makeText(getApplicationContext(),"Iniciando tarea",Toast.LENGTH_LONG).show();
        WorkManager.getInstance(this).cancelAllWorkByTag("prueba");
        cancelar_Tarea("prueba");
        PeriodicWorkRequest periodicWorkRequest1 = new PeriodicWorkRequest.Builder(BackgroundTask.class,15, TimeUnit.MINUTES)
                .setInitialDelay(5000,TimeUnit.MILLISECONDS).addTag("prueba")
                .build();

        WorkManager workManager =  WorkManager.getInstance(this);

        workManager.enqueue(periodicWorkRequest1);

        workManager.getWorkInfoByIdLiveData(periodicWorkRequest1.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(@Nullable WorkInfo workInfo) {
                        if (workInfo != null) {
                            Log.d("periodicWorkRequest", "Status changed to : " + workInfo.getState());

                        }
                    }
                });
    }

  /*  public static void connetionServer(){
        log("Entra en la conexion.....................................");
        Boolean connexion_OK = false;
        int tipoConnection = 10;
        String ip = "LaiFel.asuscomm.com";
        int puerto = 5556;
        Gson gson = new Gson();
        try {
            log("Entra en try.....................................");
            Socket sk = new Socket(ip, puerto);
            log("Entra en socket.....................................");
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(sk.getInputStream()));
            log("Entra en entrada.....................................");
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
    }*/

    private static void log(String string) {//Salida por consola de la comunicacion con server
        //output.append(string + "\n"); output seria por ejemplo un : private TextView output;
        System.out.println(string);
    }

    public static void conectar(){
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    try {
                        System.out.println("Entra en la conexion.....................................");
                        Boolean connexion_OK = false;
                        int tipoConnection = 10;
                        String ip = "LaiFel.asuscomm.com";
                        int puerto = 5556;
                        Gson gson = new Gson();
                        try {
                            System.out.println("Entra en try.....................................");
                            Socket sk = new Socket(ip, puerto);
                            System.out.println("despues de socket.....................................");
                            BufferedReader entrada = new BufferedReader(
                                    new InputStreamReader(sk.getInputStream()));
                            System.out.println("despues de entrada.....................................");
                            PrintWriter salida = new PrintWriter(
                                    new OutputStreamWriter(sk.getOutputStream()), true);
                            System.out.println("Comprobando tipo conexión = " + tipoConnection);
                            //Envio de datos a Server. El cero (0) indica al server que es comprobacion no repetido email (ver Helperclass).
                           // HelperClass.typeConnection = 10;
                            //HelperClass.datosJSONUsuario = new DatosJSON_usuario(HelperClass.name, HelperClass.email, HelperClass.firma, HelperClass.password, HelperClass.typeConnection, HelperClass.newPassword, HelperClass.newFirma, HelperClass.newName);
                            DatosJSON_usuario datosJSONUsuario = new DatosJSON_usuario("12345", " ", " ", " ", 10, " "," ", " ");
                            String json = gson.toJson(datosJSONUsuario);
                            salida.println(json);
                            String recepcionServer = entrada.readLine();
                            System.out.println("Recibiendo del Server: " + recepcionServer);
                            //Para conexion de envio botella

                            sk.close();
                            if(recepcionServer.equals("ERROR")) {
                                System.out.println("Error tipo de conexion = " + tipoConnection);
                            }
                            else {
                                connexion_OK=true;
                            }
                        } catch (Exception e) {
                            System.out.println("Error conexion Server............................................" + e.toString());
                        }

                    } catch (Exception e) {
                        System.out.println("Peta en el Run*************************" + e.getMessage());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();



    }
}