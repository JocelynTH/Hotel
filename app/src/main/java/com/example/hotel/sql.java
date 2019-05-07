package com.example.hotel;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sql extends SQLiteOpenHelper {

    private static final String DATABASE = "AUTOBUSES";
    private static final int VERSION = 1;
    private final String tViajesP = "CREATE TABLE VIAJES_PROG( ID_VIAJE_PROG INT PRIMARY KEY, FECHA TEXT NOT NULL, HORA TEXT NOT NULL)";
    //private final String tFechaR="CREATE TABLE FECHA_REG( ID_FECHA_REG INTEGER PRIMARY KEY, FECHA DATE NOT NULL, HORA TIME NOT NULL)";

    private final String tLineas = "CREATE TABLE LINEA( ID_LINEA INTEGER PRIMARY KEY," +
            "NOMBRE TEXT NOT NULL)";


    private final String tRuta = "CREATE TABLE RUTAS( ID_RUTA INT PRIMARY KEY," +
            "ORIGEN TEXT NOT NULL," +
            "DESTINO TEXT NOT NULL," +
            "ID_LINEA INTEGER NOT NULL," +
            "ID_VIAJE_PROG INTEGER NOT NULL," +
            "FOREIGN KEY (ID_LINEA) REFERENCES LINEA (ID_LINEA)," +
            "FOREIGN KEY (ID_VIAJE_PROG) REFERENCES VIAJES_PROG (ID_VIAJE_PROG))";

    private final String tReserva = "CREATE TABLE RESERVA( ID_RESERVA INTEGER PRIMARY KEY," +
            "ID_RUTA INTEGER NOT NULL," +
            "ID_LINEA INTEGER NOT NULL," +
            "TIPO_VIAJE TEXT NOT NULL," +
            "ID_FECHA_SALIDA INT NOT NULL," +
            "ID_FECHA_REG INT NOT NULL," +
            "NOMBRE TEXT NOT NULL," +
            "EDAD INTEGER NOT NULL," +
            "FOTO TEXT," +
            "TIPO_BOL TEXT NOT NULL," +
            "TOTAL DOUBLE NOT NULL," +
            "FOREIGN KEY (ID_RUTA) REFERENCES LINEA (ID_RUTA)," +
            "FOREIGN KEY (ID_FECHA_SALIDA) REFERENCES VIAJES_PROG (ID_VIAJE_PROG)," +
            "FOREIGN KEY (ID_FECHA_REG) REFERENCES VIAJES_PROG (ID_VIAJE_PROG)," +
            "FOREIGN KEY (ID_LINEA) REFERENCES LINEA (ID_LINEA))";


    public sql(Context context) {
        super(context, DATABASE, null, VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(tViajesP);
        db.execSQL(tLineas);
        db.execSQL(tRuta);
        db.execSQL(tReserva);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS VIAJES_PROG");
            db.execSQL(tViajesP);
            db.execSQL("DROP TABLE IF EXISTS LINEA");
            db.execSQL(tLineas);
            db.execSQL("DROP TABLE IF EXISTS RUTAS");
            db.execSQL(tRuta);
            db.execSQL("DROP TABLE IF EXISTS RESERVA");
            db.execSQL(tReserva);
        }
    }
}
