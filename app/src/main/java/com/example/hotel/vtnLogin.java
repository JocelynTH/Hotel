package com.example.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class vtnLogin extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Button BotonLogin;
        Button BotonCancel;
        View v = inflater.inflate(R.layout.fragment_vtn_login, container, false);
        final EditText UsuarioText=(EditText)v.findViewById(R.id.editTextUsuario);
        final EditText PassText=(EditText)v.findViewById(R.id.editTextContraseña);
        BotonLogin=(Button) v.findViewById(R.id.btnContinuar);
        BotonCancel=(Button) v.findViewById(R.id.btnSalir);

        BotonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String V_User = UsuarioText.getText().toString();
                String V_Pass = PassText.getText().toString();

                if (V_User.equals("AnJosVi") && V_Pass.equals("DesMovil2p")) {

                    Toast.makeText(getContext(), "Has iniciado sesión ", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getContext(), "Usuario o contraseña no valido", Toast.LENGTH_SHORT).show();
                }
            }
        });

        BotonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSa = new Intent(Intent.ACTION_MAIN);
                intentSa.addCategory(Intent.CATEGORY_HOME);
                intentSa.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Toast.makeText(getContext(), "Vuelve Pronto", Toast.LENGTH_SHORT).show();
                startActivity(intentSa);
            }
        });


        return v;
    }
}

