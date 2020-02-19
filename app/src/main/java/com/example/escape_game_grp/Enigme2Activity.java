package com.example.escape_game_grp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

/* Activite Enigme2 de l'application */
public class Enigme2Activity extends Activity {

    private TextView question;  /* Aperçu de la question de l'enigme n°2 */

    private Button retour;      /* Bouton de retour pour l'activite en cours */

    private Vibrator vib;       /* Variable permettant de gerer le vibreur sur l'activite */

    @Override
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
        setContentView(R.layout.activity_enigme2);

        /* Activite en plein ecran */
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* Mise en relation avec le layout */
        question = findViewById(R.id.enigme2_view);
        retour = findViewById(R.id.retour_btn);

        /* Mise en place de la vibration */
        vib=(Vibrator)getSystemService(MainActivity.VIBRATOR_SERVICE);

        /* Si l'activite detecte un changement au niveau du bouton retour */
        retour.setOnClickListener(new View.OnClickListener() {

            /* L'utilisateur à cliquer sur le bouton */
            public void onClick(View v) {

                /* Vibration lorsque le bouton est presse */
                vib.vibrate(10);

                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                Intent intent = new Intent(Enigme2Activity.this, QuestionnaireActivity.class);
                startActivity(intent);
            }
        });

    }

    /* Blocage du bouton retour */
    public void onBackPressed() {}
}
