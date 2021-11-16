package com.example.calculadorajava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_0, bt_1, bt_2, bt_3, bt_4, bt_5, bt_6, bt_7, bt_8, bt_9, bt_limp, bt_divisao, bt_mult, bt_subtracao, bt_soma, bt_ponto, bt_del, bt_igual;
    private TextView txt_expres, txt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startcomp();
        getSupportActionBar().hide();

        bt_0.setOnClickListener(this);
        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_4.setOnClickListener(this);
        bt_5.setOnClickListener(this);
        bt_6.setOnClickListener(this);
        bt_7.setOnClickListener(this);
        bt_8.setOnClickListener(this);
        bt_9.setOnClickListener(this);
        bt_ponto.setOnClickListener(this);
        bt_subtracao.setOnClickListener(this);
        bt_divisao.setOnClickListener(this);
        bt_soma.setOnClickListener(this);
        bt_mult.setOnClickListener(this);

        bt_limp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txt_expres.setText("");
                txt_result.setText("");

            }
        });

        bt_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView expres = findViewById(R.id.txt_expres);
                String string = expres.getText().toString();

                if (!string.isEmpty()){

                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtexpres = string.substring(var0,var1);
                    expres.setText(txtexpres);

                }

                txt_result.setText("");

            }
        });

        bt_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Expression express = new ExpressionBuilder(txt_expres.getText().toString()).build();
                    double result = express.evaluate();
                    long longresult = (long) result;

                    if (result == (double) longresult ) {
                        txt_result.setText((CharSequence) String.valueOf(longresult));

                    }else{
                        txt_result.setText((CharSequence) String.valueOf(result));

                    }
                }catch (Exception e){


                }


            }
        });

    }

    private void startcomp() {

        bt_0 = findViewById(R.id.bt_0);
        bt_1 = findViewById(R.id.bt_1);
        bt_2 = findViewById(R.id.bt_2);
        bt_3 = findViewById(R.id.bt_3);
        bt_4 = findViewById(R.id.bt_4);
        bt_5 = findViewById(R.id.bt_5);
        bt_6 = findViewById(R.id.bt_6);
        bt_7 = findViewById(R.id.bt_7);
        bt_8 = findViewById(R.id.bt_8);
        bt_9 = findViewById(R.id.bt_9);
        bt_limp = findViewById(R.id.bt_limp);
        bt_divisao = findViewById(R.id.bt_divisao);
        bt_mult = findViewById(R.id.bt_mult);
        bt_subtracao = findViewById(R.id.bt_subtracao);
        bt_soma = findViewById(R.id.bt_soma);
        bt_ponto = findViewById(R.id.bt_ponto);
        bt_del = findViewById(R.id.bt_del);
        bt_igual = findViewById(R.id.bt_igual);
        txt_expres = findViewById(R.id.txt_expres);
        txt_result = findViewById(R.id.txt_result);

    }

    public void acrescentarExpressao(String string, boolean limpadados) {

        if (txt_result.getText().equals("")) {

            txt_expres.setText(" ");

        }

        if (limpadados) {

            txt_result.setText(" ");
            txt_expres.append(string);

        } else {

            if (!txt_result.getText().equals(" "))
                txt_expres.setText(" ");

            txt_expres.append(txt_result.getText());

            txt_expres.append(string);
            txt_result.setText(" ");


        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.bt_0:
                acrescentarExpressao("0", true);
                break;
            case R.id.bt_1:
                acrescentarExpressao("1",true);
                break;
            case R.id.bt_2:
                acrescentarExpressao("2", true);
                break;
            case R.id.bt_3:
                acrescentarExpressao("3", true);
                break;
            case R.id.bt_4:
                acrescentarExpressao("4", true);
                break;
            case R.id.bt_5:
                acrescentarExpressao("5", true);
                break;
            case R.id.bt_6:
                acrescentarExpressao("6", true);
                break;
            case R.id.bt_7:
                acrescentarExpressao("7", true);
                break;
            case R.id.bt_8:
                acrescentarExpressao("8", true);
                break;
            case R.id.bt_9:
                acrescentarExpressao("9", true);
                break;
            case R.id.bt_ponto:
                acrescentarExpressao(".", true);
                break;
            case R.id.bt_divisao:
                acrescentarExpressao("/", false);
                break;
            case R.id.bt_mult:
                acrescentarExpressao("*", false);
                break;
            case R.id.bt_soma:
                acrescentarExpressao("+", false);
                break;
            case R.id.bt_subtracao:
                acrescentarExpressao("-", false);
                break;

        }
    }

}