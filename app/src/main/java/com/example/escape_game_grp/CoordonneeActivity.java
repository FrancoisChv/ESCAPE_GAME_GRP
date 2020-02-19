package com.example.escape_game_grp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/* Activite questionnaire de l'application */

public class CoordonneeActivity extends Activity {

    private Button retour;  /* Bouton de retour pour l'activite en cours */

    private Vibrator vib;   /* Variable permettant de gerer le vibreur sur l'activite */

    /* Creation de l'activite */
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        /* Suppression de la barre de titre */
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        /* Protocole de securite de l'activite */
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        }

        /* Mis en place du layout de l'activite */
        setContentView(R.layout.activity_coordonnee);

        /* Activite en plein ecran */
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* Mise en place de la vibration */
        vib=(Vibrator)getSystemService(MainActivity.VIBRATOR_SERVICE);

        /* Mise en relation avec le layout */
        retour = findViewById(R.id.retour_btn);

        /* Si l'activite detecte un changement au niveau du bouton retour */
        retour.setOnClickListener(new View.OnClickListener() {

            /* L'utilisateur à cliquer sur le bouton */
            public void onClick(View v) {

                /* Vibration lorsque le bouton est presse */
                vib.vibrate(10);

                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                Intent retour_menu = new Intent(CoordonneeActivity.this, QuestionnaireActivity.class);
                startActivity(retour_menu);
            }
        });

    }

    /* Blocage du bouton retour */
    public void onBackPressed() {}

}
