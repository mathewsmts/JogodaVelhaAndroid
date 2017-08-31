package com.example.mathews.jogodavelha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String jogador1 = "O";
    private final String jogador2 = "X";
    private int jogada = 1;
    Button[] botoes;
    TextView TextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView = (TextView) findViewById(R.id.txtView);

        botoes = new Button[10];
        botoes[1] = (Button) findViewById(R.id.btn1);
        botoes[2] = (Button) findViewById(R.id.btn2);
        botoes[3] = (Button) findViewById(R.id.btn3);
        botoes[4] = (Button) findViewById(R.id.btn4);
        botoes[5] = (Button) findViewById(R.id.btn5);
        botoes[6] = (Button) findViewById(R.id.btn6);
        botoes[7] = (Button) findViewById(R.id.btn7);
        botoes[8] = (Button) findViewById(R.id.btn8);
        botoes[9] = (Button) findViewById(R.id.btn9);


        for (int i = 1; i < 10; i++) {//inicia um click no botão e verifica se o botão já foi jogado, se não foi, ele continua com as jogadas
            final int finalI = i;
            botoes[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!verificarPossibilidades(true) ||!verificarVelha()) {
                        if (botoes[finalI].getText().toString().equals("")) {
                            if (jogada % 2 == 1) {
                                TextView.setText("VEZ DO JOGADOR - X");
                                botoes[finalI].setText(jogador1);

                            } else {
                                botoes[finalI].setText(jogador2);
                                TextView.setText("VEZ DO JOGADOR - O");

                                // Toast.makeText(getBaseContext(), botoes[finalI].getText().toString(), Toast.LENGTH_SHORT).show();
                            }
                            verificarVelha();
                        }else{
                            verificarCampo();
                        }
                        verificarGanhador();
                        jogada++;
                        //Toast.makeText(getBaseContext(), "jogada: " + String.valueOf(jogada), Toast.LENGTH_SHORT).show();
                    }
                }

            });
            }
    }

    public boolean verificarPossibilidades(boolean b) {//verifica as possibilidades de ganhar o jogo
        String q1 = botoes[1].getText().toString();
        String q2 = botoes[2].getText().toString();
        String q3 = botoes[3].getText().toString();
        String q4 = botoes[4].getText().toString();
        String q5 = botoes[5].getText().toString();
        String q6 = botoes[6].getText().toString();
        String q7 = botoes[7].getText().toString();
        String q8 = botoes[8].getText().toString();
        String q9 = botoes[9].getText().toString();
        if ((q1 != "") && (q2 != "") && (q3 != "") && (q1 == q2) && (q2 == q3) ||
                (q4 != "") && (q5 != "") && (q6 != "") && (q4 == q5) && (q5 == q6) ||
                (q7 != "") && (q8 != "") && (q9 != "") && (q7 == q8) && (q8 == q9) ||
                (q1 != "") && (q5 != "") && (q9 != "") && (q1 == q5) && (q5 == q9) ||
                (q3 != "") && (q6 != "") && (q9 != "") && (q3 == q6) && (q6 == q9) ||
                (q1 != "") && (q4 != "") && (q7 != "") && (q1 == q4) && (q4 == q7) ||
                (q2 != "") && (q5 != "") && (q8 != "") && (q2 == q5) && (q5 == q8) ||
                (q3 != "") && (q5 != "") && (q7 != "") && (q3 == q5) && (q5 == q7)) {
            return b;
        }
        return false;
    }

    public void jogarBtn(View v) {
        for (int i = 1; i < 10; i++) {
            botoes[i].setText("");
            botoes[i].setEnabled(true);
            if (jogada % 2 == 1) {
                TextView.setText("VEZ DO JOGADOR - O");
            } else {
                TextView.setText("VEZ DO JOGADOR - X");
            }
            jogada = 1;
        }
    }

    public void verificarGanhador() {//se as possibilidades deu verdadeiro ele exibe o ganhador
        if(verificarPossibilidades(true)){
        if (jogada % 2 == 1) {
            Toast.makeText(getBaseContext(),"VENCEDOR: JOGADOR - O",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getBaseContext(),"VENCEDOR: JOGADOR - X",Toast.LENGTH_SHORT).show();
        }

      }
    }

    public boolean verificarVelha() {
        if (jogada == 9) {
            Toast.makeText(getBaseContext(), "Deu Velha!", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

        public void verificarCampo() {//verifica se o campo já foi jogado
                Toast.makeText(getBaseContext(), "Campo já jogado, tente outro!", Toast.LENGTH_SHORT).show();
                if (jogada % 2 == 1) {
                    TextView.setText("VEZ DO JOGADOR - O");
                } else {
                    TextView.setText("VEZ DO JOGADOR - X");
                }
                jogada--;
        }
    }







