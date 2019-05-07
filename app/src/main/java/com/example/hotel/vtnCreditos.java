package com.example.hotel;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

public class vtnCreditos extends Fragment {
    boolean click = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_vtn_creditos, container, false);
        final PopupWindow pop = new PopupWindow(getContext());

        final TextView txtInf = new TextView(getContext());
        txtInf.setText("INSTITUTO TECNOLÓGICO DE TOLUCA \n" +
                "ASIGNATURA: DESARROLLO MOVIL\n" +
                "PROFESORA: ROCÍO ELIZABETH PULIDO ALBA\n" +
                "ALUMNOS: \n"+
                "DAYLI JOCELYN TORRES HERNÁNDEZ\n"+
                "MARÍA DE LOS ANGELES SÁNCHEZ CUEVAS\n"+
                "VICTOR HUGO CUEVAS ROSAS\n");
        txtInf.setTextColor(Color.WHITE);
        txtInf.setTextSize(14);
        txtInf.setGravity(Gravity.CENTER);
        txtInf.setBackgroundColor(Color.rgb(102,178,255));


        final ImageButton BotonAcer = (ImageButton) v.findViewById(R.id.btnA);

        BotonAcer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (click==false) {
                    pop.setContentView(txtInf);
                    pop.showAsDropDown(view);
                    pop.setAnimationStyle(9);
                    pop.setHeight(665);
                    pop.setWidth(480);
                    click=true;
                }else
                {
                    pop.dismiss();
                    pop.setHeight(665);
                    pop.setWidth(480);
                    click = false;
                }
            }
        });
        return v;
    }


}
