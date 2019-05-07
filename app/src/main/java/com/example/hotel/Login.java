package com.example.hotel;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.style.Theme_DeviceDefault_Light_Dialog;

public class Login extends AppCompatActivity {


    EditText UsuarioText, PassText;
    Button BotonLogin;
    Button BotonCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_vtn_login);

        UsuarioText=(EditText)findViewById(R.id.editTextUsuario);
        PassText=(EditText)findViewById(R.id.editTextContraseña);
        BotonLogin=(Button) findViewById(R.id.btnContinuar);
        BotonCancel=(Button) findViewById(R.id.btnSalir);

        BotonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String V_User = UsuarioText.getText().toString();
                String V_Pass = PassText.getText().toString();

               if (V_User.equals("AnJosVi") && V_Pass.equals("DesMovil2p"))
                //if (V_User.equals("") && V_Pass.equals(""))
                {
                    Intent intent1 = new Intent(Login.this, MainActivity.class);
                    final ProgressDialog progressDialog = new ProgressDialog(Login.this, Theme_DeviceDefault_Light_Dialog);
                    progressDialog.setIndeterminate(true);
                    progressDialog.setMessage("Iniciando...");
                    progressDialog.show();
                   // Toast.makeText(getApplicationContext(), "Hola, Buen día", Toast.LENGTH_SHORT).show();
                    startActivity(intent1);
                }else
                {
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña no valido", Toast.LENGTH_SHORT).show();
                }
            }
        });

        BotonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSa = new Intent(Intent.ACTION_MAIN);
                intentSa.addCategory(Intent.CATEGORY_HOME);
                intentSa.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Toast.makeText(getApplicationContext(), "Vuelve Pronto", Toast.LENGTH_SHORT).show();
                startActivity(intentSa);
            }
        });
    }
}
