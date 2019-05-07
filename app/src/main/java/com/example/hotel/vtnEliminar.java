package com.example.hotel;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class vtnEliminar extends Fragment {

    SQLite sqlite;
    String s;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_vtn_eliminar, container, false);

        final EditText edID = (EditText) v.findViewById(R.id.editTextIDEli);
        final Button btnBuscar = (Button) v.findViewById(R.id.btnEliminar);

        sqlite = new SQLite(getContext());
        sqlite.abrir();


        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edID.getText().toString().equals("")) {
                    Cursor c = sqlite.getTipoV(Integer.parseInt(edID.getText().toString()));
                    s = sqlite.getRegTipoV(c);
                    Cursor c1 = sqlite.Buscar(Integer.parseInt(edID.getText().toString()));
                    String bus = sqlite.getRegTipoV(c);

                    if (bus.equals("")) {
                        sqlite.Eliminar(edID.getText());
                        Toast.makeText(getContext(), "Registro Eliminado", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Ingresa número de boleto", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }
}
