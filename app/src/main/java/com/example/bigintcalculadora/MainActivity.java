package com.example.bigintcalculadora;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    Button soma;
    Button multiplicacao;
    EditText PrimeiroValor;
    EditText SegundoValor;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soma = findViewById(R.id.somar);
        multiplicacao = findViewById(R.id.multiplicar);
        PrimeiroValor = findViewById(R.id.Valor_Primeiro);
        SegundoValor = findViewById(R.id.Valor_Segundo);
        txtResultado = findViewById(R.id.txtResultado);
    }

    @SuppressLint("SetTextI18n")
    public void somar (View view){
        List<String> resultado = new ArrayList<String>();
        int operacao1[];
        operacao1 = new int[30];
        int operacao2[];
        operacao2 = new int[30];
        String a1 = PrimeiroValor.getText().toString();
        String b2 = SegundoValor.getText().toString();
        String a = new StringBuilder(a1).reverse().toString();
        String b = new StringBuilder(b2).reverse().toString();
        int i=0;
        for (i=0; i<a.length(); i++){
            operacao1[i] = Integer.parseInt(valueOf(a.charAt(i)));
        }
        for (i=0; i<b.length(); i++){
            operacao2[i] = Integer.parseInt(valueOf(b.charAt(i)));
        }
        for (i=b.length(); i<30; i++){
            operacao2[i] = -1;
        }
        for (i=a.length(); i<30; i++){
            operacao1[i] = -1;
        }

        for (i=0; i<=29; i++){
            if (operacao1[i] == -1 && operacao2[i] != -1){
                resultado.add(valueOf(operacao2[i]));
            }
            if (operacao2[i] == -1 && operacao1[i] != -1){
                resultado.add(valueOf(operacao1[i]));
            }
            if (operacao1[i] != -1 && operacao2[i] != -1){
                if (operacao1[i] + operacao2[i] >= 10) {
                    if (i < 29) {
                        if (operacao1[i + 1] == -1) {
                            operacao1[i + 1] = operacao1[i + 1] + 2;
                            resultado.add(valueOf(operacao1[i] + operacao2[i] - 10));
                        } else {
                            operacao1[i + 1] = operacao1[i + 1] + 1;
                            resultado.add(valueOf(operacao1[i] + operacao2[i] - 10));
                        }
                    } else {
                        resultado.add(valueOf(operacao1[i] + operacao2[i]));

                    }
                } else {
                    resultado.add(valueOf(operacao1[i] + operacao2[i]));
                }
            }
        }

        Collections.reverse(resultado);
        String list = Arrays.toString(resultado.toArray()).replace("[", "").replace(",", "").replace(" ", "").replace("]", "");

        txtResultado.setText("" + list);
    }





    public void multiplicar (View view){

        //    List<String> resultado = new ArrayList<String>();
        //   int operacao1[];
        //   operacao1 = new int[30];
        //   int operacao2[];
        //   operacao2 = new int[30];
        //  String a1 = PrimeiroValor.getText().toString();
        //  String b2 = SegundoValor.getText().toString();
        //    String a = new StringBuilder(a1).reverse().toString();
        //     String b = new StringBuilder(b2).reverse().toString();
        //   int i=0;
        //    for (i=0; i<a.length(); i++){
            //       operacao1[i] = Integer.parseInt(valueOf(a.charAt(i)));
            //   }
        //   for (i=0; i<b.length(); i++){
            //       operacao2[i] = Integer.parseInt(valueOf(b.charAt(i)));
            //   }
        //  for (i=b.length(); i<30; i++){
            //      operacao2[i] = -1;
            //  }
        //  for (i=a.length(); i<30; i++){
        //   operacao1[i] = -1;
            // }
        // int aux = 0;
        //   if (a1.length() > b2.length()){
        //     for (i=0; i<b2.length(); i++){
        //         for (int j=0; j<a1.length(); j++){
        //            if (operacao1[j] * operacao2[i] + aux > 10){
        //                resultado.add(valueOf(valueOf(operacao1[j] * operacao2[i] + aux).charAt(0)));
        //                aux = valueOf(operacao1[j] * operacao2[i]).charAt(1);
        //       }else{
        //            resultado.add(valueOf(operacao1[j] * operacao2[i] + aux));
        //     }

        //       resultado.add(valueOf(operacao1[i]*operacao2[i]));
        // }
        // }
        //  }

        //   if (b2.length() > a1.length()){
            //   for (i=0; i<b2.length(); i++){
                //     for (int j=0; j<a1.length(); j++){
                    //      if (operacao1[j] * operacao2[i] + aux > 10){
                        //         resultado.add(valueOf(valueOf(operacao1[j] * operacao2[i] + aux).charAt(0)));
                        //         aux = valueOf(operacao1[j] * operacao2[i]).charAt(1);
                        //       }else{
                        //            resultado.add(valueOf(operacao1[j] * operacao2[i] + aux));
                        //        }

                    //       resultado.add(valueOf(operacao1[i]*operacao2[i]));
                    //  }
                // }
            // }
        int resultado1 = Integer.parseInt(PrimeiroValor.getText().toString());
        int resultado2 = Integer.parseInt(SegundoValor.getText().toString());


        //String list = Arrays.toString(resultado.toArray()).replace("[", "").replace(",", "").replace(" ", "").replace("]", "");

        txtResultado.setText("" + resultado1 * resultado2);
    }

}