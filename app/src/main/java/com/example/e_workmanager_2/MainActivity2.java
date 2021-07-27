package com.example.e_workmanager_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import static com.example.e_workmanager_2.ConnectionServer.connetionServer2;


public class MainActivity2 extends AppCompatActivity {

    Button buttonConexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttonConexion = (Button)findViewById(R.id.buttonConexion);
    }

    public void ConectarServer(View view) {
        MainActivity.conectar();
        }

    class Hilo1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(50);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Pasamos por el hilo*********************************************");
                        //
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}