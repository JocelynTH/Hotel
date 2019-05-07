package com.example.hotel;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class vtnTipoViaje extends Fragment {

    Spinner tipoViaje;
    String a = "";
    int op;
    Spinner spinOri;
    Spinner spinDest;
    Spinner spinLinea;
    String orig;
    String dest;
    String lin;
    int id_linea;
    int id_ruta;
    SQLite sqlite;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_vtn_tipo_habitación, container, false);
        tipoViaje = (Spinner) v.findViewById(R.id.spinnerTipoViaje);
        final ArrayAdapter<CharSequence> adapterTV = ArrayAdapter.createFromResource(getContext(), R.array.tipoV, android.R.layout.simple_spinner_item);
        tipoViaje.setAdapter(adapterTV);


        sqlite = new SQLite(getContext());
        sqlite.abrir();
        Cursor cursor = sqlite.getDESTINOS();
        final ArrayList<String> reg = sqlite.getRegDest(cursor);


        tipoViaje.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final String opcion = String.valueOf(tipoViaje.getSelectedItemId());
                int op = Integer.parseInt(opcion);
                if (op == 1) {
                    a = adapterTV.getItem(1).toString();


                } else if (op == 2) {
                    a = adapterTV.getItem(2).toString();
                } else if (op == 0) {
                    a = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinOri = (Spinner) v.findViewById(R.id.spinnerOrigenn);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.Origen, android.R.layout.simple_spinner_item);
        spinOri.setAdapter(adapter);
        spinOri.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String opcion = String.valueOf(spinOri.getSelectedItemId());
                int op = Integer.parseInt(opcion);
                System.out.println(opcion);
                if (op == 0) {

                }
                if (op == 1) {
                    spinDest = (Spinner) v.findViewById(R.id.spinnerDestinos);
                    //final ArrayAdapter<CharSequence> adapterD1 = ArrayAdapter.createFromResource(getContext(), R.array.DestinosF, android.R.layout.simple_spinner_item);
                    final ArrayAdapter<String> adapterD1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, reg);
                    spinDest.setAdapter(adapterD1);
                    orig = adapter.getItem(1).toString();

                    spinDest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            String opcion2 = String.valueOf(spinDest.getSelectedItemId());
                            int op2 = Integer.parseInt(opcion2);
                            System.out.println(opcion2);

                            if (op2 == 0) {
                                spinLinea = (Spinner) v.findViewById(R.id.spinnerLinea);
                                dest = adapterD1.getItem(0).toString();
                                Cursor cursor = sqlite.getLINEASF();
                                final ArrayList<String> regD2 = sqlite.getRegLineasF(cursor);
                                final ArrayAdapter<String> adapterD2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, regD2);
                                //final ArrayAdapter<CharSequence> adapterD2 = ArrayAdapter.createFromResource(getContext(), R.array.DestinosF, android.R.layout.simple_spinner_item);
                                spinLinea.setAdapter(adapterD2);

                                spinLinea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        String opcion3 = String.valueOf(spinLinea.getSelectedItemId());
                                        int op3 = Integer.parseInt(opcion3);

                                        System.out.println(opcion3);
                                        if (op3 == 0) {
                                            lin = "1";
                                        } else if (op3 == 1) {
                                            lin = "5";
                                        } else {
                                            Toast.makeText(getContext(), "NO HAY VIAJES DISPONIBLES", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            } else if (op2 == 1) {
                                spinLinea = (Spinner) v.findViewById(R.id.spinnerLinea);
                                dest = adapterD1.getItem(1).toString();
                                Cursor cursor = sqlite.getLINEASF();
                                final ArrayList<String> regD2 = sqlite.getRegLineasF(cursor);
                                final ArrayAdapter<String> adapterD2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, regD2);
                                //final ArrayAdapter<CharSequence> adapterD2 = ArrayAdapter.createFromResource(getContext(), R.array.DestinosF, android.R.layout.simple_spinner_item);
                                spinLinea.setAdapter(adapterD2);

                                spinLinea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        String opcion3 = String.valueOf(spinDest.getSelectedItemId());
                                        int op3 = Integer.parseInt(opcion3);

                                        System.out.println(opcion3);
                                        if (op3 == 0) {
                                            lin = "1";
                                        } else if (op3 == 2) {
                                            lin = "3";
                                        } else {
                                            Toast.makeText(getContext(), "NO HAY VIAJES DISPONIBLES", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            } else if (op2 == 2) {
                                spinLinea = (Spinner) v.findViewById(R.id.spinnerLinea);
                                dest = adapterD1.getItem(2).toString();
                                Cursor cursor = sqlite.getLINEASF();
                                final ArrayList<String> regD2 = sqlite.getRegLineasF(cursor);
                                final ArrayAdapter<String> adapterD2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, regD2);
                                //final ArrayAdapter<CharSequence> adapterD2 = ArrayAdapter.createFromResource(getContext(), R.array.DestinosF, android.R.layout.simple_spinner_item);
                                spinLinea.setAdapter(adapterD2);

                                spinLinea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        String opcion3 = String.valueOf(spinDest.getSelectedItemId());
                                        int op3 = Integer.parseInt(opcion3);

                                        System.out.println(opcion3);
                                        if (op3 == 3) {
                                            lin = "2";
                                        } else {
                                            Toast.makeText(getContext(), "NO HAY VIAJES DISPONIBLES", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            } else if (op2 == 3) {
                                spinLinea = (Spinner) v.findViewById(R.id.spinnerLinea);
                                dest = adapterD1.getItem(3).toString();
                                Cursor cursor = sqlite.getLINEASF();
                                final ArrayList<String> regD2 = sqlite.getRegLineasF(cursor);
                                final ArrayAdapter<String> adapterD2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, regD2);
                                //final ArrayAdapter<CharSequence> adapterD2 = ArrayAdapter.createFromResource(getContext(), R.array.DestinosF, android.R.layout.simple_spinner_item);
                                spinLinea.setAdapter(adapterD2);

                                spinLinea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        String opcion3 = String.valueOf(spinDest.getSelectedItemId());
                                        int op3 = Integer.parseInt(opcion3);

                                        System.out.println(opcion3);
                                        if (op3 == 3) {
                                            lin = "2";
                                        } else {
                                            Toast.makeText(getContext(), "NO HAY VIAJES DISPONIBLES", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            } else if (op2 == 4) {
                                spinLinea = (Spinner) v.findViewById(R.id.spinnerLinea);
                                dest = adapterD1.getItem(4).toString();
                                Cursor cursor = sqlite.getLINEASF();
                                final ArrayList<String> regD2 = sqlite.getRegLineasF(cursor);
                                final ArrayAdapter<String> adapterD2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, regD2);
                                //final ArrayAdapter<CharSequence> adapterD2 = ArrayAdapter.createFromResource(getContext(), R.array.DestinosF, android.R.layout.simple_spinner_item);
                                spinLinea.setAdapter(adapterD2);

                                spinLinea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        String opcion3 = String.valueOf(spinDest.getSelectedItemId());
                                        int op3 = Integer.parseInt(opcion3);

                                        System.out.println(opcion3);
                                        if (op3 == 2) {
                                            lin = "3";
                                        } else {
                                            Toast.makeText(getContext(), "NO HAY VIAJES DISPONIBLES", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            } else if (op2 == 5) {
                                spinLinea = (Spinner) v.findViewById(R.id.spinnerLinea);
                                dest = adapterD1.getItem(5).toString();
                                Cursor cursor = sqlite.getLINEASF();
                                final ArrayList<String> regD2 = sqlite.getRegLineasF(cursor);
                                final ArrayAdapter<String> adapterD2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, regD2);
                                //final ArrayAdapter<CharSequence> adapterD2 = ArrayAdapter.createFromResource(getContext(), R.array.DestinosF, android.R.layout.simple_spinner_item);
                                spinLinea.setAdapter(adapterD2);

                                spinLinea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        String opcion3 = String.valueOf(spinDest.getSelectedItemId());
                                        int op3 = Integer.parseInt(opcion3);

                                        System.out.println(opcion3);
                                        if (op3 == 2) {
                                            lin = "3";
                                        } else {
                                            Toast.makeText(getContext(), "NO HAY VIAJES DISPONIBLES", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            } else if (op2 == 6) {
                                spinLinea = (Spinner) v.findViewById(R.id.spinnerLinea);
                                dest = adapterD1.getItem(6).toString();
                                Cursor cursor = sqlite.getLINEASF();
                                final ArrayList<String> regD2 = sqlite.getRegLineasF(cursor);
                                final ArrayAdapter<String> adapterD2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, regD2);
                                //final ArrayAdapter<CharSequence> adapterD2 = ArrayAdapter.createFromResource(getContext(), R.array.DestinosF, android.R.layout.simple_spinner_item);
                                spinLinea.setAdapter(adapterD2);

                                spinLinea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        String opcion3 = String.valueOf(spinDest.getSelectedItemId());
                                        int op3 = Integer.parseInt(opcion3);

                                        System.out.println(opcion3);
                                        if (op3 == 4) {
                                            lin = "4";
                                        } else {
                                            Toast.makeText(getContext(), "NO HAY VIAJES DISPONIBLES", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            } else if (op2 == 7) {
                                spinLinea = (Spinner) v.findViewById(R.id.spinnerLinea);
                                dest = adapterD1.getItem(7).toString();
                                Cursor cursor = sqlite.getLINEASF();
                                final ArrayList<String> regD2 = sqlite.getRegLineasF(cursor);
                                final ArrayAdapter<String> adapterD2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, regD2);
                                //final ArrayAdapter<CharSequence> adapterD2 = ArrayAdapter.createFromResource(getContext(), R.array.DestinosF, android.R.layout.simple_spinner_item);
                                spinLinea.setAdapter(adapterD2);

                                spinLinea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        String opcion3 = String.valueOf(spinDest.getSelectedItemId());
                                        int op3 = Integer.parseInt(opcion3);

                                        System.out.println(opcion3);
                                        if (op3 == 4) {
                                            lin = "4";
                                        } else {
                                            Toast.makeText(getContext(), "NO HAY VIAJES DISPONIBLES", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            } else if (op2 == 8) {
                                spinLinea = (Spinner) v.findViewById(R.id.spinnerLinea);
                                dest = adapterD1.getItem(8).toString();
                                Cursor cursor = sqlite.getLINEASF();
                                final ArrayList<String> regD2 = sqlite.getRegLineasF(cursor);
                                final ArrayAdapter<String> adapterD2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, regD2);
                                //final ArrayAdapter<CharSequence> adapterD2 = ArrayAdapter.createFromResource(getContext(), R.array.DestinosF, android.R.layout.simple_spinner_item);
                                spinLinea.setAdapter(adapterD2);

                                spinLinea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        String opcion3 = String.valueOf(spinDest.getSelectedItemId());
                                        int op3 = Integer.parseInt(opcion3);

                                        System.out.println(opcion3);
                                        if (op3 == 0) {
                                            lin = "1";
                                        } else if (op3 == 1) {
                                            lin = "5";
                                        } else if (op3 == 2) {
                                            lin = "3";
                                        } else if (op3 == 3) {
                                            lin = "2";
                                        } else if (op3 == 4) {
                                            lin = "4";
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            } else if (op2 == 9) {
                                spinLinea = (Spinner) v.findViewById(R.id.spinnerLinea);
                                dest = adapterD1.getItem(9).toString();
                                Cursor cursor = sqlite.getLINEASF();
                                final ArrayList<String> regD2 = sqlite.getRegLineasF(cursor);
                                final ArrayAdapter<String> adapterD2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, regD2);
                                //final ArrayAdapter<CharSequence> adapterD2 = ArrayAdapter.createFromResource(getContext(), R.array.DestinosF, android.R.layout.simple_spinner_item);
                                spinLinea.setAdapter(adapterD2);

                                spinLinea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        String opcion3 = String.valueOf(spinDest.getSelectedItemId());
                                        int op3 = Integer.parseInt(opcion3);

                                        System.out.println(opcion3);
                                        if (op3 == 2) {
                                            lin = "5";
                                        } else {
                                            Toast.makeText(getContext(), "NO HAY VIAJES DISPONIBLES", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Button BotonSig = (Button) v.findViewById(R.id.btnSiguiente1);
        BotonSig.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putString("tipoKey", a);
                bundle.putString("id_lineaKey", lin);
                bundle.putString("origenKey", orig);
                bundle.putString("destinoKey", dest);

                if (!a.equals("") && !tipoViaje.equals("")) {
                    vtnReservar frag = new vtnReservar();
                    frag.setArguments(bundle);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.contenedor, frag);
                    ft.addToBackStack(null);
                    ft.commit();
                } else {
                    Toast.makeText(getContext(), "No se pueden dejar campos vacios", Toast.LENGTH_SHORT).show();

                }
            }
        });
        return v;
    }

}
