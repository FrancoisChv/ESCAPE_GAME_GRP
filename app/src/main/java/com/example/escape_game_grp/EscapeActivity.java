package com.example.escape_game_grp;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;


/* Activite Escape de l'application */

public class EscapeActivity extends Activity {

    private TextView text;      /* Texte principal de l'activite */
    private TextView text2;     /* Texte secondaire de l'activite */

    private Button video;       /* Bouton de lancement de la video */

    private Vibrator vib;       /* Variable permettant de gerer le vibreur sur l'activite */

    @Override
    /* Creation de l'activite */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Suppression de la barre de titre */
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        /* Protocole de securite de l'activite */
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        }

        /* Mis en place du layout de l'activite */
        setContentView(R.layout.activity_escape);

        /* Activite en plein ecran */
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* Jointure des variables au layout de l'activite */
        text = findViewById(R.id.escapePresentation_view);
        text2 = findViewById(R.id.escapeInfo_view);
        video = findViewById(R.id.video_btn);

        /* Mis en place du texte en mode justifie */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            text.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            text2.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        }

        /* Mise en place de la vibration */
        vib = (Vibrator) getSystemService(MainActivity.VIBRATOR_SERVICE);

        /* Si l'activite detecte un changement au niveau du bouton */
        video.setOnClickListener(new View.OnClickListener() {

            @Override
            /* L'utilisateur à cliquer sur le bouton */
            public void onClick(View v) {

                /* Vibration du bouton durant un court laps de temps */
                vib.vibrate(10);

                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                Intent QuestionnaireActivity = new Intent(EscapeActivity.this, QuestionnaireActivity.class);
                startActivity(QuestionnaireActivity);
            }
        });
    }

    /* Blocage du bouton retour */
    public void onBackPressed() {}

}
