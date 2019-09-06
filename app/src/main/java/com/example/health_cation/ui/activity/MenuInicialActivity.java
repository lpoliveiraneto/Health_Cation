package com.example.health_cation.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.health_cation.R;
import com.example.health_cation.model.AtividadeFisica;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.login.LoginResult;

import org.json.JSONObject;

public class MenuInicialActivity extends AppCompatActivity {

    private ImageView imageView_batimentos;
    private ImageView imageView_alimentacao;
    private ImageView imagemView_rank;
    private ImageView imageView_medalhas;
    private TextView txtView_name;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);

        configuraCampos();
        configuraButtonBatimentos();
        configuraButtonAlimentação();
        configuraButtonBagdes();
        txtView_name.setText("Oliveira Neto");

    }

    private void configuraButtonAlimentação(){
        imageView_alimentacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamarTela(MenuInicialActivity.this, AlimentacaoActivity.class);
            }
        });
    }

    private void configuraButtonBatimentos() {
        imageView_batimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamarTela(MenuInicialActivity.this, AtividadeFisicaActivity.class);
            }
        });
    }

    private void configuraButtonBagdes(){
        imageView_medalhas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamarTela(MenuInicialActivity.this, BagdeActivity.class);
            }
        });
    }

    private void configuraCampos() {
        imageView_batimentos = findViewById(R.id.atividadeFisica_imgView);
        imageView_alimentacao = findViewById(R.id.alimentacao_imgview);
        imagemView_rank = findViewById(R.id.rank_imgview);
        imageView_medalhas = findViewById(R.id.medalhas_imgview);
        txtView_name = findViewById(R.id.nome_textView);

        //System.out.println("-------------------------"+name);

    }

    private void chamarTela(Context context, Class tela){
        Intent it = new Intent(context, tela);
        startActivity(it);
    }
}
