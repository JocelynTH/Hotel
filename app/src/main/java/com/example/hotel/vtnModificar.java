package com.example.hotel;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


public class vtnModificar extends Fragment {

    DatePickerDialog.OnDateSetListener mDateListener;
    DatePickerDialog.OnDateSetListener mDateListenerR;
    DatePickerDialog.OnDateSetListener mDateListenerHS;
    String TAG = "vtnReservar";
    String hora = "";
    String dateS = "";
    String dateR = "";
    SQLite sqlite;
    ArrayList<String> reg;
    boolean band = false;
    String s="";
    TextView fechaR;
    TextView fechaS;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_vtn_modificar, container, false);
        fechaR = (TextView) v.findViewById(R.id.lblFechaEntrada);
        fechaS = (TextView) v.findViewById(R.id.lblFechaSalida);
        final TextView edFechaR = (TextView) v.findViewById(R.id.editFechaR);;
        final TextView fechaSal = (TextView) v.findViewById(R.id.editFechaS);
        final EditText edID = (EditText) v.findViewById(R.id.editTextIDM);
        final Button btnBuscar = (Button) v.findViewById(R.id.btnBuscarMod);

        fechaR.setVisibility(View.INVISIBLE);
        fechaS.setVisibility(View.INVISIBLE);
        edFechaR.setVisibility(View.INVISIBLE);
        fechaSal.setVisibility(View.INVISIBLE);
        sqlite = new SQLite(getContext());
        sqlite.abrir();




        edFechaR.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int anio = cal.get(Calendar.YEAR);
                int mes = cal.get(Calendar.MONTH);
                int dia = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateListenerR, anio, mes, dia);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateListenerR = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d(TAG, "onDateSet: dd/mm/yyy: " + dayOfMonth + year + month);
                dateR = dayOfMonth + "/" + (month + 1) + "/" + year;
                edFechaR.setText(dateR);
            }
        };

        btnBuscar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (!edID.getText().toString().equals("")) {
                   Cursor c = sqlite.getTipoV(Integer.parseInt(edID.getText().toString()));
                   s=sqlite.getRegTipoV(c);
                   c = sqlite.getID_LINEA(Integer.parseInt(edID.getText().toString()));
                   int l=sqlite.getRegINT(c);
                   c = sqlite.getID_RUTA(Integer.parseInt(edID.getText().toString()));
                   int r=sqlite.getRegINT(c);
                   c = sqlite.getIDFS(Integer.parseInt(edID.getText().toString()));
                   int fs=sqlite.getRegINT(c);
                   c = sqlite.getIDFR(Integer.parseInt(edID.getText().toString()));
                   int fr=sqlite.getRegINT(c);
                   c = sqlite.getEDAD(Integer.parseInt(edID.getText().toString()));
                   int e=sqlite.getRegINT(c);
                   c = sqlite.getNOM(Integer.parseInt(edID.getText().toString()));
                   String nom=sqlite.getRegCAD(c);
                   c = sqlite.getTIPO_BOL(Integer.parseInt(edID.getText().toString()));
                   String tB=sqlite.getRegCAD(c);
                   c = sqlite.getTIPO_BOL(Integer.parseInt(edID.getText().toString()));
                   double tot=sqlite.getRegDOU(c);

                   if (s.equals("Sencillo")) {

                       fechaS.setVisibility(View.VISIBLE);
                       fechaSal.setVisibility(View.VISIBLE);

                   } else if (s.equals("Redondo")) {

                       fechaS.setVisibility(View.VISIBLE);
                       fechaR.setVisibility(View.VISIBLE);
                       edFechaR.setVisibility(View.VISIBLE);
                       fechaSal.setVisibility(View.VISIBLE);
                   }
               }else
               {
                   Toast.makeText(getContext(), "Ingresa número de boleto", Toast.LENGTH_SHORT).show();
               }
           }
       });





        fechaSal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int anio = cal.get(Calendar.YEAR);
                int mes = cal.get(Calendar.MONTH);
                int dia = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateListener, anio, mes, dia);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }
        });



        mDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d(TAG, "onDateSet: dd/mm/yyy/hh: " + dayOfMonth + year + month);
                dateS = dayOfMonth + "/" + (month + 1) + "/" + year;

                fechaSal.setText(dateS);


            }
        };



        final Button BotonAceptar = (Button) v.findViewById(R.id.btnAceptarR);
        BotonAceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("tipoKey", s);

                bundle.putString("fechaSKey", dateS);
                bundle.putString("fechaRKey", dateR);


            }
        });
        return v;
    }

}
