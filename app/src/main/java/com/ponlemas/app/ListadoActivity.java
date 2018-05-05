package com.ponlemas.app;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.Vector;

public class ListadoActivity extends AppCompatActivity {
    Spinner sp_ciudades;
    ListView lv_productos;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.listado_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        sp_ciudades = (Spinner) findViewById(R.id.listado_sp_categoria);
        lv_productos = (ListView) findViewById(R.id.listado_lv_productos);
    }

    public class miAdaptador extends ArrayAdapter {
        Activity contexto;
        LayoutInflater inflater;

        public miAdaptador(Activity contexto) {
            super(contexto, R.layout.activity_listado);
            this.contexto = contexto;
            inflater = LayoutInflater.from(contexto);
        }

        @Override
        public int getCount() {
            //Numero de elementos en la lista
            return super.getCount();
        }

        @Nullable
        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            CheckBox listado_check;
            EditText listado_edit;
            ImageButton listado_imagen;

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.listado_listview, null);
            }

            listado_check = (CheckBox) convertView.findViewById(R.id.listado_listview_check);
            listado_edit = (EditText) convertView.findViewById(R.id.listado_listview_texto);
            listado_imagen = (ImageButton) convertView.findViewById(R.id.listado_listview_button);

            return convertView;
        }
    }
}
