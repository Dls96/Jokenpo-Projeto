package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view) {
        this.opcaoSelecionada("Pedra");
    }

    public void selecionarPapel(View view) {
        this.opcaoSelecionada("Papel");
    }

    public void selecionarTesoura(View view) {
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {
        TextView textoResultado = findViewById(R.id.textResultado);
        TextView placarUsuario = findViewById(R.id.placarUsuario);
        TextView placarCPU = findViewById(R.id.placarCPU);
        textoResultado.setText("Escolha uma opção abaixo");

        int contPlacarUsuario =Integer.valueOf(placarUsuario.getText().toString());
        int contPlacarCPU = Integer.valueOf(placarCPU.getText().toString());

        ImageView imagemResultado = findViewById(R.id.imageResultado);

        String[] jogadas = {"Pedra", "Papel", "Tesoura"};
        int indice = new Random().nextInt(3);

        String escolhaApp = jogadas[indice];

        switch (escolhaApp){
            case "Pedra":
                imagemResultado.setImageResource(R.drawable.rock);
                break;

            case "Papel":
                imagemResultado.setImageResource(R.drawable.paper);
                break;

            case "Tesoura":
                imagemResultado.setImageResource(R.drawable.scissor);
                break;
        }
        //VITORIAS DO USUARIO
        if(escolhaUsuario.equals("Papel") && escolhaApp.equals("Pedra") || escolhaUsuario.equals("Pedra") && escolhaApp.equals("Tesoura") || escolhaUsuario.equals("Tesoura") && escolhaApp.equals("Papel")){
            contPlacarUsuario = contPlacarUsuario + 1;
            placarUsuario.setText(String.valueOf(contPlacarUsuario));
            if(contPlacarUsuario == 9){
                textoResultado.setText("Parabens Você venceu !");
                placarUsuario.setText("0");
                placarCPU.setText("0");
            }
        }else if(escolhaApp.equals(escolhaUsuario)){
            textoResultado.setText("Empate !");
        }
        //VITORIAS DO APP
        else{
            contPlacarCPU = contPlacarCPU + 1;
            placarCPU.setText(String.valueOf(contPlacarCPU));
            if(contPlacarCPU== 9){
                textoResultado.setText("Você perdeu ! ,Tente novamente");
                placarCPU.setText("0");
                placarUsuario.setText("0");
            }
        }
    }
}
