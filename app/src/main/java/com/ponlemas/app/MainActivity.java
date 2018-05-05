package com.ponlemas.app;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, MainActivityDialog.DialogListener {
    Button btn_mostrar, btn_abrir;
    RadioButton main_rb1, main_rb2, main_rb3, main_rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializacion de variables
        btn_mostrar = (Button) findViewById(R.id.main_bt_mostrar);
        btn_abrir = (Button) findViewById(R.id.main_bt_abrir);
        main_rb1 = (RadioButton) findViewById(R.id.main_rb_1);
        main_rb2 = (RadioButton) findViewById(R.id.main_rb_2);
        main_rb3 = (RadioButton) findViewById(R.id.main_rb_3);
        main_rb4 = (RadioButton) findViewById(R.id.main_rb_4);

        //Inicio de consulta de datos

        //Eventos
        /*
        btn_mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (main_rb1.isChecked()) {
                    //Toast
                    Toast.makeText(getApplicationContext(), "Hola Mundo", Toast.LENGTH_SHORT).show();
                } else if (main_rb2.isChecked()) {
                    Dialog dialog = new Dialog(getApplicationContext());
                } else if (main_rb3.isChecked()) {
                    Snackbar.
                } else if (main_rb4.isChecked()) {

                }
            }
        });*/

        btn_mostrar.setOnClickListener(this);
        btn_abrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListadoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (main_rb1.isChecked()) {
            //Toast
            Toast.makeText(getApplicationContext(), "Toast", Toast.LENGTH_SHORT).show();
        } else if (main_rb2.isChecked()) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            MainActivityDialog dialog = new MainActivityDialog();
            dialog.setMensaje("Nuevo mensaje");
            dialog.show(fragmentManager, "mDialogo");
        } else if (main_rb3.isChecked()) {
            Snackbar.make(view, "Snackbar", Snackbar.LENGTH_SHORT).show();
        } else if (main_rb4.isChecked()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

            builder.setSmallIcon(android.R.drawable.ic_media_play) //Icono
                    .setContentTitle("Mi notificacion") //Titulo
                    .setContentText("El contenido de mi notificacion") //Contenido
                    .setStyle(new NotificationCompat.BigTextStyle())//Estilo
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(pendingIntent);

            NotificationManagerCompat notificationManager;
            notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(1, builder.build());
        }
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        Toast.makeText(MainActivity.this, "Presiono aceptar", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Toast.makeText(MainActivity.this, "Presiono cancelar", Toast.LENGTH_SHORT).show();
    }

}
