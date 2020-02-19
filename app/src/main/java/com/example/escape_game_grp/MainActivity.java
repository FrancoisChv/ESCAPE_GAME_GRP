package com.example.escape_game_grp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/* Activite principal de l'application */
public class MainActivity extends AppCompatActivity {

    private Button escape;          /* Bouton permettant de se connecter à l'application */

    private EditText codeEscape;    /* Code nécessaire à la connexion à l'application */

    private TextView titre;         /* Aperçu du titre de l'application */

    private int code;               /* code d'acces à l'application */

    private String codeToString;    /*Permettant de changer le code en une chaine de caracteres */
    private String test;            /* Chaine de caractères permettant de tester le code d'acces */

    private Vibrator vib;           /* Variable permettant de gerer le vibreur sur l'activite */

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
        setContentView(R.layout.activity_main);

        /* Activite en plein ecran */
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* code d'acces et transformation */
        code = 6789;
        codeToString = codeToString.valueOf(code);

        /* Mise en relation avec le layout */
        escape = findViewById(R.id.escape_btn);
        codeEscape = findViewById(R.id.escape_txt);
        titre = findViewById(R.id.titre_txt);

        /* Rotation du bouton principal */
        RotateAnimation rotate = new RotateAnimation(0, 20000, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(800000);
        rotate.setInterpolator(new LinearInterpolator());
        escape.startAnimation(rotate);

        /* Desactivation du bouton */
        escape.setEnabled(false);

        /* Mise en place de la vibration */
        vib = (Vibrator) getSystemService(MainActivity.VIBRATOR_SERVICE);

        /* Lorsque l'activite detecte du texte dans le champs de saisie */
        codeEscape.addTextChangedListener(new TextWatcher() {

            @Override
            /* Avant que le texte n'ait change */
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            /* Lorsque le champ de saisie est modifie */

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                escape.setEnabled(s.toString().length() != 0);
                test = s.toString();

                /* Test du code */
                if (test.compareTo(codeToString) != 0) {
                    test = "Veuillez saisir le bon code.";
                } else if (test.compareTo(codeToString) == 0) {
                    test = "Code accepté";
                }
            }

            @Override
            /* Après que le champ de saisie ait ete modifie */
            public void afterTextChanged(Editable s) {
            }
        });

        /* Si l'activite detecte un changement au niveau du bouton */
        escape.setOnClickListener(new View.OnClickListener() {

            /* Si on clique sur le bouton */
            public void onClick(View v) {

                /* Vibration lorsque le bouton est presse */
                vib.vibrate(10);

                /* Si le code est correct, l'utilisateur est redirige vers une autre activite */
                if (test.contains("accepté")) {

                    /* Changement d'activite */
                    Intent EscapeActivity = new Intent(MainActivity.this, EscapeActivity.class);
                    startActivity(EscapeActivity);
                } else {

                    /* Si le code est incorrrecte, nettoyage du champ de saisie */
                    codeEscape.getText().clear();
                }
            }
        });
    }
}