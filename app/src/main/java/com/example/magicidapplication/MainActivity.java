package com.example.magicidapplication;

import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText etID;
    Button btnSubmit;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      Lanza la pantalla activity
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);

//      Removemos la vista al iniciar
        tvResults.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View ShowID) {
//              Obtenemos el Id y lo almacenamos en idNumber
                String idNumber = etID.getText().toString().trim();
//              Despues de almacenado en idNumber obtenemos los primeros 6 numeros(que seria el año)
                String dob = idNumber.substring(0, 6);

//              Obtenemos los siguientes 4 digitos(idNumber.CartAt), los pasamos como string()(Character.toString) y se convierten a entero (Integer.parseInt())
                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));
//              Preguntamos si es hombre o mujer segun el numero < a 5 sera mujer y > a 5 sera hombre
                String sGender;
                if (gender < 5)
                    sGender = getString(R.string.Female);
                else
                    sGender = getString(R.string.Male);

//              Obtenemos la desima pocision para verificar la nacionalidad, si es 0 es ciudadano permanente y de ser mayo es ciudadano
                int Nacionality = Integer.parseInt(Character.toString(idNumber.charAt(10)));
//              preguntamos que nacionalidad tiene
                String sNacionality;
                if(Nacionality == 0)
                    sNacionality = getString(R.string.Citizen);
                else
                    sNacionality = getString(R.string.Permanent);

//              Mostramos los datos e importamos el texto a mostrar desde el archivo string desde su id.
                String textView = getString(R.string.dob) + dob + "\n" +
                        getString(R.string.Gender) + sGender +  "\n" +
                        getString(R.string.Nacionality) + sNacionality;

//              Pasamos los datos a tv results para mostrarlos.
                tvResults.setText(textView);

//              Traemos la vista de regreso para mostrar los resultados
                tvResults.setVisibility(View.VISIBLE);
            }
        });
    }
}