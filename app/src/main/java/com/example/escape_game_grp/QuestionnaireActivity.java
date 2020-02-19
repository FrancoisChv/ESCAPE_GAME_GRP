package com.example.escape_game_grp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;

/* Activite questionnaire de l'application */
public class QuestionnaireActivity extends Activity {

    private Button enigme1;     /* Bouton d'acces a l'enigme n°1 */
    private Button enigme2;     /* Bouton d'acces a l'enigme n°2 */
    private Button enigme3;     /* Bouton d'acces a l'enigme n°3 */
    private Button enigme4;     /* Bouton d'acces a l'enigme n°4 */
    private Button enigme5;     /* Bouton d'acces a l'enigme n°5 */
    private Button enigme6;     /* Bouton d'acces a l'enigme n°6 */
    private Button enigme7;     /* Bouton d'acces a l'enigme n°7 */
    private Button enigme8;     /* Bouton d'acces a l'enigme n°8 */
    private Button enigme9;     /* Bouton d'acces a l'enigme n°9 */
    private Button enigme10;    /* Bouton d'acces a l'enigme n°10 */

    private Button suivant;     /* Bouton d'acces au code final */

    private Vibrator vib;       /* Variable permettant de gerer le vibreur sur l'activite */

    @Override
    /* Creation de l'activite */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Suppression de la barre de titre */
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        /* Protocole de securite de l'activite */
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        }

        /* Mis en place du layout de l'activite */
        setContentView(R.layout.activity_questionnaire);

        /* Activite en plein ecran */
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* Mise en relation avec le layout */
        enigme1 = findViewById(R.id.enigme1_btn);
        enigme2 = findViewById(R.id.enigme2_btn);
        enigme3 = findViewById(R.id.enigme3_btn);
        enigme4 = findViewById(R.id.enigme4_btn);
        enigme5 = findViewById(R.id.enigme5_btn);
        enigme6 = findViewById(R.id.enigme6_btn);
        enigme7 = findViewById(R.id.enigme7_btn);
        enigme8 = findViewById(R.id.enigme8_btn);
        enigme9 = findViewById(R.id.enigme9_btn);
        enigme10 = findViewById(R.id.enigme10_btn);
        suivant = findViewById(R.id.suivant_btn);

        /* Mise en place de la vibration */
        vib=(Vibrator)getSystemService(MainActivity.VIBRATOR_SERVICE);

        /* Rotation des boutons des enigmes */
        RotateAnimation rotate = new RotateAnimation(0, 20000, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(800000);
        rotate.setInterpolator(new LinearInterpolator());
        enigme1.startAnimation(rotate);
        enigme2.startAnimation(rotate);
        enigme3.startAnimation(rotate);
        enigme4.startAnimation(rotate);
        enigme5.startAnimation(rotate);
        enigme6.startAnimation(rotate);
        enigme7.startAnimation(rotate);
        enigme8.startAnimation(rotate);
        enigme9.startAnimation(rotate);
        enigme10.startAnimation(rotate);

        /* Si l'activite detecte un changement au niveau du bouton de la 1ere enigme */
        enigme1.setOnClickListener(new View.OnClickListener() {

            @Override
            /* L'utilisateur à cliquer sur le bouton */
            public void onClick(View v) {

                /* Vibration lorsque le bouton est presse */
                vib.vibrate(10);

                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                Intent Enigme1Activity = new Intent(QuestionnaireActivity.this, Enigme1Activity.class);
                startActivity(Enigme1Activity);
            }
        });

        /* Si l'activite detecte un changement au niveau du bouton de la 2eme enigme */
        enigme2.setOnClickListener(new View.OnClickListener() {

            @Override
            /* L'utilisateur à cliquer sur le bouton */
            public void onClick(View v) {

                /* Vibration lorsque le bouton est presse */
                vib.vibrate(10);

                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                Intent Enigme2Activity = new Intent(QuestionnaireActivity.this, Enigme2Activity.class);
                startActivity(Enigme2Activity);
            }
        });

        /* Si l'activite detecte un changement au niveau du bouton de la 3eme enigme */
        enigme3.setOnClickListener(new View.OnClickListener() {

            @Override
            /* L'utilisateur à cliquer sur le bouton */
            public void onClick(View v) {

                /* Vibration lorsque le bouton est presse */
                vib.vibrate(10);

                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                Intent Enigme3Activity = new Intent(QuestionnaireActivity.this, Enigme3Activity.class);
                startActivity(Enigme3Activity);
            }
        });

        /* Si l'activite detecte un changement au niveau du bouton de la 4eme enigme */
        enigme4.setOnClickListener(new View.OnClickListener() {

            @Override
            /* L'utilisateur à cliquer sur le bouton */
            public void onClick(View v) {

                /* Vibration lorsque le bouton est presse */
                vib.vibrate(10);

                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                Intent Enigme4Activity = new Intent(QuestionnaireActivity.this, Enigme4Activity.class);
                startActivity(Enigme4Activity);
            }
        });

        /* Si l'activite detecte un changement au niveau du bouton de la 5eme enigme */
        enigme5.setOnClickListener(new View.OnClickListener() {

            @Override
            /* L'utilisateur à cliquer sur le bouton */
            public void onClick(View v) {

                /* Vibration lorsque le bouton est presse */
                vib.vibrate(10);

                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                Intent Enigme5Activity = new Intent(QuestionnaireActivity.this, Enigme5Activity.class);
                startActivity(Enigme5Activity);
            }
        });

        /* Si l'activite detecte un changement au niveau du bouton de la 6eme enigme */
        enigme6.setOnClickListener(new View.OnClickListener() {

            @Override
            /* L'utilisateur à cliquer sur le bouton */
            public void onClick(View v) {

                /* Vibration lorsque le bouton est presse */
                vib.vibrate(10);

                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                Intent Enigme6Activity = new Intent(QuestionnaireActivity.this, Enigme6Activity.class);
                startActivity(Enigme6Activity);
            }
        });

        /* Si l'activite detecte un changement au niveau du bouton de la 7eme enigme */
        enigme7.setOnClickListener(new View.OnClickListener() {

            @Override
            /* L'utilisateur à cliquer sur le bouton */
            public void onClick(View v) {

                /* Vibration lorsque le bouton est presse */
                vib.vibrate(10);

                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                Intent Enigme7Activity = new Intent(QuestionnaireActivity.this, Enigme7Activity.class);
                startActivity(Enigme7Activity);
            }
        });

        /* Si l'activite detecte un changement au niveau du bouton de la 8eme enigme */
        enigme8.setOnClickListener(new View.OnClickListener() {

            @Override
            /* L'utilisateur à cliquer sur le bouton */
            public void onClick(View v) {

                /* Vibration lorsque le bouton est presse */
                vib.vibrate(10);

                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                Intent Enigme8Activity = new Intent(QuestionnaireActivity.this, Enigme8Activity.class);
                startActivity(Enigme8Activity);
            }
        });

        /* Si l'activite detecte un changement au niveau du bouton de la 9eme enigme */
        enigme9.setOnClickListener(new View.OnClickListener() {

            @Override
            /* L'utilisateur à cliquer sur le bouton */
            public void onClick(View v) {

                /* Vibration lorsque le bouton est presse */
                vib.vibrate(10);

                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                Intent Enigme9Activity = new Intent(QuestionnaireActivity.this, Enigme9Activity.class);
                startActivity(Enigme9Activity);
            }
        });

        /* Si l'activite detecte un changement au niveau du bouton de la 10eme enigme */
        enigme10.setOnClickListener(new View.OnClickListener() {

            @Override
            /* L'utilisateur à cliquer sur le bouton */
            public void onClick(View v) {

                /* Vibration lorsque le bouton est presse */
                vib.vibrate(10);

                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                Intent Enigme10Activity = new Intent(QuestionnaireActivity.this, Enigme10Activity.class);
                startActivity(Enigme10Activity);
            }
        });

        /* Si l'activite detecte un changement au niveau du bouton du code final */
        suivant.setOnClickListener(new View.OnClickListener() {

            @Override
            /* L'utilisateur à cliquer sur le bouton */
            public void onClick(View v) {

                /* Vibration lorsque le bouton est presse */
                vib.vibrate(10);

                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                Intent CoordonneeActivity = new Intent(QuestionnaireActivity.this, CoordonneeActivity.class);
                startActivity(CoordonneeActivity);
            }
        });
    }

    /* Blocage du bouton retour */
    public void onBackPressed() {}
}

