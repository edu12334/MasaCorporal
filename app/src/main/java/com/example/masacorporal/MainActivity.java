package com.example.masacorporal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText etNombre, etTalla, etPeso;
    TextView txtResultado, txtResultado1;
    RadioButton rbVaron, rbMujer;
    Button btnCalcular, btnLimpiar, btnSalir, btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre = findViewById(R.id.etNombre);
        etTalla = findViewById(R.id.etTalla);
        etPeso = findViewById(R.id.etPeso);
        txtResultado = findViewById(R.id.txtResultado);
        txtResultado1 = findViewById(R.id.txtResultado1);
        //rbVaron = findViewById(R.id.rbVaron);
        //rbMujer = findViewById(R.id.rbMujer);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnSalir = findViewById(R.id.btnSalir);
        btnConsultar = findViewById(R.id.btnConsultar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double calcular, talla, peso;
                String mensaje = null;
                talla = Double.parseDouble(etTalla.getText().toString());
                peso = Double.parseDouble(etPeso.getText().toString());
                calcular = peso / Math.pow(talla, 2);
                if (calcular < 16.00 )
                    mensaje = String.valueOf("Peso Muy Grave");
                else if (calcular < 16.99)
                    mensaje = String.valueOf("Peso Grave");
                else if (calcular < 18.49)
                    mensaje = String.valueOf("Bajo Peso");
                else if (calcular < 24.99)
                    mensaje = String.valueOf("Peso Normal");
                else if (calcular < 29.99)
                    mensaje = String.valueOf("Sobre Peso");
                else if (calcular < 34.99)
                    mensaje = String.valueOf("Obesidad Grado 1");
                else if (calcular < 39.99)
                    mensaje = String.valueOf("Obesidad Grado II");
                else if (calcular > 40.00)
                    mensaje = String.valueOf("Obesidad Grado III");

                txtResultado.setText(etNombre.getText() + " Su IMC con respecto a su peso " + etPeso.getText() + " es de " + String.format("%.2f", calcular));
                txtResultado1.setText("Categoria de IMC " + mensaje.toString());
            }

        });
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent. ACTION_VIEW,
                        Uri.parse ("https://www.google.com/search?q=categorias+de+indice+de+masa+corporal&oq=categorias+de+Indice+&aqs=chrome.1.69i57j0j0i22i30l3.16527j0j4&sourceid=chrome&ie=UTF-8"));
                startActivity(intent);
            }
        });
    }

    public void salir(View view) {
        finish();
    }

}