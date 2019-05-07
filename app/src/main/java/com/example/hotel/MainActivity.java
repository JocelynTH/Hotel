package com.example.hotel;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SQLite sqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        inserts();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment frag;
//        if (id == R.id.mReservar) {
//            // Handle the camera action
//            frag = new vtnTipoViaje();
//            FragmentManager fm = getSupportFragmentManager();
//            FragmentTransaction ft = fm.beginTransaction();
//            ft.replace(R.id.contenedor, frag);
//
//            ft.commit();
//        } else if (id == R.id.mModificar) {
//            frag = new vtnModificar();
//            FragmentManager fm = getSupportFragmentManager();
//            FragmentTransaction ft = fm.beginTransaction();
//            ft.replace(R.id.contenedor, frag);
//            ft.commit();
//        } else if (id == R.id.nav_mListar) {
//            frag = new vtnListaReservas();
//            FragmentManager fm = getSupportFragmentManager();
//            FragmentTransaction ft = fm.beginTransaction();
//            ft.replace(R.id.contenedor, frag);
//            ft.commit();
//        } else if (id == R.id.mCancelar) {
//            frag = new vtnEliminar();
//            FragmentManager fm = getSupportFragmentManager();
//            FragmentTransaction ft = fm.beginTransaction();
//            ft.replace(R.id.contenedor, frag);
//
//            ft.commit();
//        } else if (id == R.id.mlistaLineas) {
//            frag = new vtnLineas();
//            FragmentManager fm = getSupportFragmentManager();
//            FragmentTransaction ft = fm.beginTransaction();
//            ft.replace(R.id.con, frag);
//
//            ft.commit();
//        } else if (id == R.id.mCreditos) {
//
//            frag = new vtnCreditos();
//            FragmentManager fm = getSupportFragmentManager();
//            FragmentTransaction ft = fm.beginTransaction();
//            ft.replace(R.id., frag);
//
//            ft.commit();
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void inserts() {
        sqlite = new SQLite(getApplicationContext());
        sqlite.abrir();

        sqlite.addRegLinea(1, "ETN");
        sqlite.addRegLinea(2, "FLECHA ROJA");
        sqlite.addRegLinea(3, "PEGASSO");
        sqlite.addRegLinea(4, "ODM");
        sqlite.addRegLinea(5, "PRIMERA PLUS");

        sqlite.addRegViajeProg(0, " ", " ");
        sqlite.addRegViajeProg(1, "4/4/2019", "12:00");
        sqlite.addRegViajeProg(2, "4/4/2019", "15:00");
        sqlite.addRegViajeProg(3, "4/4/2019", "18:00");
        sqlite.addRegViajeProg(4, "4/4/2019", "20:00");
        sqlite.addRegViajeProg(5, "4/4/2019", "22:00");
        //sqlite.addRegViajeProg(6, "4/4/2019", "15:00");
        //sqlite.addRegViajeProg(7, "4/4/2019", "18:00");
        //sqlite.addRegViajeProg(8, "4/4/2019", "20:00");
        sqlite.addRegViajeProg(9, "5/4/2019", "12:00");
        sqlite.addRegViajeProg(10, "5/4/2019", "15:00");
        sqlite.addRegViajeProg(11, "5/4/2019", "18:00");
        sqlite.addRegViajeProg(12, "5/4/2019", "20:00");
        sqlite.addRegViajeProg(13, "6/4/2019", "12:00");
        sqlite.addRegViajeProg(14, "6/4/2019", "15:00");
        sqlite.addRegViajeProg(15, "6/4/2019", "18:00");
        sqlite.addRegViajeProg(16, "6/4/2019", "20:00");
        sqlite.addRegViajeProg(17, "7/4/2019", "12:00");
        sqlite.addRegViajeProg(18, "7/4/2019", "15:00");
        sqlite.addRegViajeProg(19, "7/4/2019", "18:00");
        sqlite.addRegViajeProg(20, "7/4/2019", "20:00");
        sqlite.addRegViajeProg(21, "8/4/2019", "12:00");
        sqlite.addRegViajeProg(22, "8/4/2019", "15:00");
        sqlite.addRegViajeProg(23, "8/4/2019", "18:00");
        sqlite.addRegViajeProg(24, "8/4/2019", "20:00");
        sqlite.addRegViajeProg(25, "9/4/2019", "12:00");
        sqlite.addRegViajeProg(26, "9/4/2019", "15:00");
        sqlite.addRegViajeProg(27, "9/4/2019", "18:00");
        sqlite.addRegViajeProg(28, "9/4/2019", "20:00");
        sqlite.addRegViajeProg(29, "10/4/2019", "12:00");
        sqlite.addRegViajeProg(30, "10/4/2019", "15:00");
        sqlite.addRegViajeProg(31, "10/4/2019", "18:00");
        sqlite.addRegViajeProg(32, "10/4/2019", "20:00");
        sqlite.addRegViajeProg(33, "11/4/2019", "12:00");
        sqlite.addRegViajeProg(34, "11/4/2019", "15:00");
        sqlite.addRegViajeProg(35, "11/4/2019", "18:00");
        sqlite.addRegViajeProg(36, "11/4/2019", "20:00");


        boolean b=sqlite.addRutas(1, "TOLUCA, EDO. MEXICO", "GUADALAJARA, JALISCO", 1, 1);
        sqlite.addRutas(2, "TOLUCA, EDO. MEXICO", "GUADALAJARA, JALISCO", 1, 2);
        sqlite.addRutas(3, "TOLUCA, EDO. MEXICO", "GUADALAJARA, JALISCO", 1, 3);
        sqlite.addRutas(4, "TOLUCA, EDO. MEXICO", "GUADALAJARA, JALISCO", 1, 4);

        sqlite.addRutas(5, "TOLUCA, EDO. MEXICO", "GUADALAJARA, JALISCO", 1, 13);
        sqlite.addRutas(6, "TOLUCA, EDO. MEXICO", "GUADALAJARA, JALISCO", 1, 14);
        sqlite.addRutas(7, "TOLUCA, EDO. MEXICO", "GUADALAJARA, JALISCO", 5, 15);
        sqlite.addRutas(8, "TOLUCA, EDO. MEXICO", "GUADALAJARA, JALISCO", 5, 16);
        sqlite.addRutas(9, "TOLUCA, EDO. MEXICO", "GUADALAJARA, JALISCO", 5, 17);
        sqlite.addRutas(10, "TOLUCA, EDO. MEXICO", "GUADALAJARA, JALISCO", 5, 18);
        sqlite.addRutas(11, "TOLUCA, EDO. MEXICO", "GUADALAJARA, JALISCO", 5, 19);
        sqlite.addRutas(12, "TOLUCA, EDO. MEXICO", "GUADALAJARA, JALISCO", 5, 20);

        sqlite.addRutas(13, "TOLUCA, EDO. MEXICO", "MORELIA, MICHOACAN", 3, 17);
        sqlite.addRutas(14, "TOLUCA, EDO. MEXICO", "MORELIA, MICHOACAN", 3, 18);
        sqlite.addRutas(15, "TOLUCA, EDO. MEXICO", "MORELIA, MICHOACAN", 3, 19);
        sqlite.addRutas(16, "TOLUCA, EDO. MEXICO", "MORELIA, MICHOACAN", 3, 20);
        sqlite.addRutas(17, "TOLUCA, EDO. MEXICO", "MORELIA, MICHOACAN", 1, 21);
        sqlite.addRutas(18, "TOLUCA, EDO. MEXICO", "MORELIA, MICHOACAN", 1, 22);
        sqlite.addRutas(19, "TOLUCA, EDO. MEXICO", "MORELIA, MICHOACAN", 1, 23);
        sqlite.addRutas(20, "TOLUCA, EDO. MEXICO", "MORELIA, MICHOACAN", 1, 24);

        sqlite.addRutas(21, "TOLUCA, EDO. MEXICO", "HERMOSILLO, SONORA", 2, 18);
        sqlite.addRutas(22, "TOLUCA, EDO. MEXICO", "HERMOSILLO, SONORA", 2, 20);
        sqlite.addRutas(23, "TOLUCA, EDO. MEXICO", "SAN LUIS P., SAN LUIS P", 2, 7);
        sqlite.addRutas(24, "TOLUCA, EDO. MEXICO", "SAN LUIS P., SAN LUIS P", 2, 18);
        sqlite.addRutas(25, "TOLUCA, EDO. MEXICO", "CHIAPAS, CHIAPAS", 3, 17);
        sqlite.addRutas(26, "TOLUCA, EDO. MEXICO", "MEXICALI, BAJA CALIFORNIA", 3, 22);
        sqlite.addRutas(27, "TOLUCA, EDO. MEXICO", "ACAPULCO, GUERRERO", 4, 17);
        sqlite.addRutas(28, "TOLUCA, EDO. MEXICO", "ACAPULCO, GUERRERO", 4, 18);
        sqlite.addRutas(29, "TOLUCA, EDO. MEXICO", "ACAPULCO, GUERRERO", 4, 19);
        sqlite.addRutas(30, "TOLUCA, EDO. MEXICO", "ACAPULCO, GUERRERO", 4, 20);
        sqlite.addRutas(31, "TOLUCA, EDO. MEXICO", "MERIDA, YUCATÁN", 4, 22);
        sqlite.addRutas(32, "TOLUCA, EDO. MEXICO", "MERIDA, YUCATÁN", 4, 23);
        sqlite.addRutas(33, "TOLUCA, EDO. MEXICO", "MERIDA, YUCATÁN", 4, 24);
        sqlite.addRutas(34, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 1, 1);
        sqlite.addRutas(35, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 2, 2);
        sqlite.addRutas(36, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 3, 3);
        sqlite.addRutas(37, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 4, 4);
        sqlite.addRutas(38, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 5, 5);
        //sqlite.addRutas(39, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 1, 6);
        //sqlite.addRutas(40, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 2, 7);
        //sqlite.addRutas(41, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 3, 8);
        sqlite.addRutas(42, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 4, 9);
        sqlite.addRutas(43, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 5, 10);
        sqlite.addRutas(44, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 1, 11);
        sqlite.addRutas(45, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 2, 12);
        sqlite.addRutas(46, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 3, 13);
        sqlite.addRutas(47, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 4, 14);
        sqlite.addRutas(48, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 5, 15);
        sqlite.addRutas(49, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 1, 16);
        sqlite.addRutas(50, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 2, 17);
        sqlite.addRutas(51, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 3, 18);
        sqlite.addRutas(52, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 4, 19);
        sqlite.addRutas(53, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 5, 20);
        sqlite.addRutas(54, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 1, 21);
        sqlite.addRutas(55, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 2, 22);
        sqlite.addRutas(56, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 3, 23);
        sqlite.addRutas(57, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 4, 24);
        sqlite.addRutas(58, "TOLUCA, EDO. MEXICO", "CD. MEXICO, DF", 5, 25);
        sqlite.addRutas(59, "TOLUCA, EDO. MEXICO", "MONTERREY, NUEVO LEON", 5, 18);
        sqlite.addRutas(60, "TOLUCA, EDO. MEXICO", "MONTERREY, NUEVO LEON", 5, 20);
    }
}