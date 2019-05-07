package com.example.hotel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.util.Log;

import java.util.ArrayList;

public class SQLite {
    private sql sql;
    private SQLiteDatabase db;

    public SQLite(Context context) {

        sql = new sql(context);
    }

    public SQLite() {

    }

    public void abrir() {
        Log.i("SQLite", "Se abre conexion a la base de datos " + sql.getDatabaseName());
        db = sql.getWritableDatabase();

    }

    public void cerrar() {
        Log.i("SQLite", "Se cierra conexion a la base de datos " + sql.getDatabaseName());
        sql.close();
    }

    public boolean addReserva(int id_reserva, int id_RUTAS, int id_linea, String tipoViaje, int id_fechaSalida, int id_fechaReg,
                              String nombre, int edad, String foto, String tipo, double total) {

        ContentValues cv = new ContentValues();
        cv.put("ID_RESERVA", id_reserva);
        cv.put("ID_RUTA", id_RUTAS);
        cv.put("ID_LINEA", id_linea);
        cv.put("TIPO_VIAJE", tipoViaje);
        cv.put("ID_FECHA_SALIDA", id_fechaSalida);
        cv.put("ID_FECHA_REG", id_fechaReg);
        cv.put("NOMBRE", nombre);
        cv.put("EDAD", edad);
        cv.put("FOTO", foto);
        cv.put("TIPO_BOL", tipo);
        cv.put("TOTAL", total);
        return (db.insert("RESERVA", null, cv) != -1) ? true : false;
    }

    public boolean addRegLinea(int id, String nombre) {
        ContentValues cv = new ContentValues();
        cv.put("ID_LINEA", id);
        cv.put("NOMBRE", nombre);
        return (db.insert("LINEA", null, cv) != -1) ? true : false;
    }

    public boolean addRegViajeProg(int id, String fecha, String hora) {
        ContentValues cv = new ContentValues();
        cv.put("ID_VIAJE_PROG", id);
        cv.put("FECHA", fecha);
        cv.put("HORA", hora);
        return (db.insert("VIAJES_PROG", null, cv) != -1) ? true : false;
    }

    public boolean addRutas(int id_RUTA, String origen, String destino, int id_linea, int id_viaje_prog) {
        ContentValues cv = new ContentValues();
        cv.put("ID_RUTA", id_RUTA);
        cv.put("ORIGEN", origen);
        cv.put("DESTINO", destino);
        cv.put("ID_LINEA", id_linea);
        cv.put("ID_VIAJE_PROG", id_viaje_prog);
        return (db.insert("RUTAS", null, cv) != -1) ? true : false;
    }

    public Cursor getRegistrosReserva() {
        return db.rawQuery("SELECT * FROM RESERVA", null);
    }

    public ArrayList<String> getReserva(Cursor cur) {
        ArrayList<String> listData = new ArrayList<String>();
        String item = "";
        if (cur.moveToFirst()) {
            do {
                item += "ID_RESERVA: B" + cur.getInt(0) + "]\r\n";
                item += "ID_RUTA: " + cur.getInt(1) + "\r\n";
                item += "ID_LINEA: " + cur.getInt(2) + "\r\n";
                item += "TIPO_VIAJE: " + cur.getString(3) + "\r\n";
                item += "ID_FECHA_SALIDA: " + cur.getInt(4) + "\r\n";
                item += "ID_FECHA_REG: " + cur.getInt(5) + "\r\n";
                item += "NOMBRE: " + cur.getString(6) + "\r\n";
                item += "EDAD: " + cur.getInt(7) + "\r\n";
                item += "FOTO: " + cur.getString(8) + "\r\n";
                item += "TIPO_BOL: " + cur.getString(9) + "\r\n";
                item += "TOTAL: " + cur.getDouble(10) + "\r\n";
                listData.add(item);
                item = "";
            } while (cur.moveToNext());
        }
        return listData;
    }

    public Cursor getRegLineas() {
        return db.rawQuery("SELECT nombre FROM linea", null);
    }

    public Cursor getDESTINOS() {
        return db.rawQuery("SELECT DISTINCT DESTINO FROM RUTAS ", null);
    }

    public ArrayList<String> getLineas(Cursor cur) {
        ArrayList<String> listData = new ArrayList<String>();
        String item = "";
        if (cur.moveToFirst()) {
            do {
                item += "LINEA: " + cur.getString(0) + "\r\n";
                listData.add(item);
                item = "";
            } while (cur.moveToNext());
        }
        return listData;
    }


    public ArrayList<String> getRegDest(Cursor cur) {
        ArrayList<String> listData = new ArrayList<String>();
        String item = "";
        if (cur.moveToFirst()) {
            do {
                item += "" + cur.getString(0);
                listData.add(item);
                item = "";
            } while (cur.moveToNext());
        }
        return listData;
    }


    public Cursor getLINEASF() {
        return db.rawQuery("SELECT DISTINCT  l.NOMBRE FROM LINEA l INNER JOIN RUTAS r ON l.ID_LINEA=r.ID_LINEA", null);
    }


    public Cursor getHora(String fecha) {
        return db.rawQuery("SELECT HORA FROM VIAJES_PROG WHERE FECHA='" + fecha + "' ", null);
    }
    public Cursor getID_LINEA(int id) {
        return db.rawQuery("SELECT ID_LINEA FROM RESERVA WHERE ID_RESERVA=" + id , null);
    }
    public Cursor getID_RUTA(int id) {
        return db.rawQuery("SELECT ID_RUTA FROM RESERVA WHERE ID_RESERVA=" + id , null);
    }
    public Cursor getIDFS(int id) {
        return db.rawQuery("SELECT ID_FECHA_SALIDA FROM RESERVA WHERE ID_RESERVA=" + id , null);
    }
    public Cursor getIDFR(int id) {
        return db.rawQuery("SELECT ID_FECHA_REG FROM RESERVA WHERE ID_RESERVA=" + id , null);
    }
    public Cursor getNOM(int id) {
        return db.rawQuery("SELECT NOMBRE FROM RESERVA WHERE ID_RESERVA=" + id , null);
    }
    public Cursor getEDAD(int id) {
        return db.rawQuery("SELECT EDAD FROM RESERVA WHERE ID_RESERVA=" + id , null);
    }
    public Cursor getFOTO(int id) {
        return db.rawQuery("SELECT FOTO FROM RESERVA WHERE ID_RESERVA=" + id , null);
    }
    public Cursor getTIPO_BOL(int id) {
        return db.rawQuery("SELECT TIPO_BOL FROM RESERVA WHERE ID_RESERVA=" + id , null);
    }
    public Cursor getTOTAL(int id) {
        return db.rawQuery("SELECT TOTAL FROM RESERVA WHERE ID_RESERVA=" + id , null);
    }
    public Cursor getTipoV(int id) {
        return db.rawQuery("SELECT TIPO_VIAJE FROM RESERVA WHERE ID_RESERVA=" + id , null);
    }

    public Cursor getIdViaje(String fecha, String hora) {
        return db.rawQuery("SELECT ID_VIAJE_PROG FROM VIAJES_PROG WHERE FECHA='" + fecha + "' AND HORA ='" + hora + "'", null);
    }
    public Cursor getIdRuta(String orig, String dest, int id_linea, int id_viaje) {
        return db.rawQuery("SELECT ID_RUTA FROM RUTAS WHERE ORIGEN='"+orig+"' AND DESTINO= '"+dest+"' AND ID_LINEA='" + id_linea + "' AND ID_VIAJE_PROG ='" + id_viaje + "'", null);
    }
 public Cursor getIdMax() {
        return db.rawQuery("SELECT MAX(ID_RESERVA) FROM RESERVA ", null);
    }

    public int getRegINT(Cursor cur) {
        ArrayList<String> listData = new ArrayList<String>();
        int item =0;
        if (cur.moveToFirst()) {
            do {
                item = cur.getInt(0);

            } while (cur.moveToNext());
        }
        return item;
    }

    public String getRegCAD(Cursor cur) {
        ArrayList<String> listData = new ArrayList<String>();
        String item ="";
        if (cur.moveToFirst()) {
            do {
                item = cur.getString(0);


            } while (cur.moveToNext());
        }
        return item;
    }

    public Double getRegDOU(Cursor cur) {
        ArrayList<String> listData = new ArrayList<String>();
        double item =0;
        if (cur.moveToFirst()) {
            do {
                item = cur.getDouble(0);


            } while (cur.moveToNext());
        }
        return item;
    }

    public int getRegViaje(Cursor cur) {
        ArrayList<String> listData = new ArrayList<String>();
        int item =0;
        if (cur.moveToFirst()) {
            do {
                item = cur.getInt(0);


            } while (cur.moveToNext());
        }
        return item;
    }
    public int getRegIdMax(Cursor cur) {
        ArrayList<String> listData = new ArrayList<String>();
        int item =0;
        if (cur.moveToFirst()) {
            do {
                item = cur.getInt(0);


            } while (cur.moveToNext());
        }
        return item;
    }
    public int getRegRuta(Cursor cur) {
        ArrayList<String> listData = new ArrayList<String>();
        int item =0;
        if (cur.moveToFirst()) {
            do {
                item = cur.getInt(0);


            } while (cur.moveToNext());
        }
        return item;
    }
    public String getRegTipoV(Cursor cur) {
        ArrayList<String> listData = new ArrayList<String>();
        String item ="";
        if (cur.moveToFirst()) {
            do {
                item = cur.getString(0);


            } while (cur.moveToNext());
        }
        return item;
    }

    public ArrayList<String> getRegHoras(Cursor cur) {
        ArrayList<String> listData = new ArrayList<String>();
        String item = "";
        if (cur.moveToFirst()) {
            do {
                item = cur.getString(0);
                listData.add(item);
                item = "";
            } while (cur.moveToNext());
        }
        return listData;
    }


    public ArrayList<String> getRegLineasF(Cursor cur) {
        ArrayList<String> listData = new ArrayList<String>();
        String item = "";
        if (cur.moveToFirst()) {
            do {
                item = cur.getString(0);
                listData.add(item);
                item = "";
            } while (cur.moveToNext());
        }
        return listData;
    }

    public ArrayList<String> getID(Cursor cur) {
        ArrayList<String> listData = new ArrayList<String>();
        String item = "";
        if (cur.moveToFirst()) {
            do {
                item += "ID: [" + cur.getInt(0) + "]\r\n";
                item = "";
            } while (cur.moveToNext());
        }
        return listData;
    }


    public String addUpdateReserva(int id_reserva, int id_RUTAS, int id_linea, String tipoViaje, int fechaSalida, int fechaReg,
                                   String nombre, int edad, String foto, String tipo, double total) {

        ContentValues cv = new ContentValues();

        cv.put("ID_RUTAS", id_RUTAS);
        cv.put("ID_LINEA", id_linea);
        cv.put("TIPO_VIAJE", tipoViaje);
        cv.put("ID_FECHA_SALIDA", fechaSalida);
        cv.put("ID_FECHA_REG", fechaReg);
        cv.put("NOMBRE", nombre);
        cv.put("EDAD", edad);
        cv.put("FOTO", foto);
        cv.put("TIPO_BOL", tipo);
        cv.put("TOTAL", total);

        int cant = db.update("RESERVA", cv, "ID_RESERVA=" + id_reserva, null);
        if (cant == 1) {
            return "Usuario Mod";
        } else
            return "Fallo algo";
    }

    public Cursor getCant(int id) {
        return db.rawQuery("SELECT * FROM RESETVA WHERE ID_BOL = " + id, null);
    }

    public Cursor Buscar(int id) {

        return db.rawQuery("SELECT NOMBRE FROM RESERVA WHERE ID_RESERVA = "+ id , null);
    }

    public int Eliminar(Editable id) {

        return db.delete("RESERVA", "ID_RESERVA=" + id, null);
    }
}
