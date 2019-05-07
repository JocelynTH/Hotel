package com.example.hotel;

import android.app.DatePickerDialog;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


public class vtnReservar extends Fragment {

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View v = inflater.inflate(R.layout.fragment_vtn_reservar, container, false);
        TextView fechaR = (TextView) v.findViewById(R.id.lblFechaEntradaR);
        final TextView edFechaR = (TextView) v.findViewById(R.id.editFechaR);;
        final TextView fechaSal = (TextView) v.findViewById(R.id.editFechaS);


        Bundle b = getArguments();
        final String s = b.getString("tipoKey");
        final String l = b.getString("id_lineaKey");
        final String o = b.getString("origenKey");
        final String d = b.getString("destinoKey");


        sqlite = new SQLite(getContext());
        sqlite.abrir();

        if (s.equals("Sencillo")) {

            fechaR.setVisibility(View.INVISIBLE);
            edFechaR.setVisibility(View.INVISIBLE);

        } else {

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




        }


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
                bundle.putString("id_lineaKey", l);
                bundle.putString("orogenKey", o);
                bundle.putString("destinoKey", d);
                bundle.putString("fechaSKey", dateS);
                bundle.putString("fechaRKey", dateR);

            }
        });
        return v;
    }
}

