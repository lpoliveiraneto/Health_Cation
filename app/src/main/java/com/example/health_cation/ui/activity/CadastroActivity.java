package com.example.health_cation.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.health_cation.R;
import com.example.health_cation.database.DaoUsuario;
import com.example.health_cation.model.User;

public class CadastroActivity extends AppCompatActivity {

    private EditText campoNome;
    private EditText campoIdade;
    private EditText campoEmail;
    private EditText campoSenha;
    private EditText campoAltura;
    private EditText campoPeso;
    private EditText campoParente;
    private EditText campoContatoParente;
    private Button botaoSalvar;
    private final DaoUsuario dao = new DaoUsuario();
    private User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        inicializaCampo();
        //preencheUser();
        configuraBotaoSalvar();
    }

    private void inicializaCampo() {
        campoNome =findViewById(R.id.nome_edttxt);
        campoIdade =findViewById(R.id.idade_edttxt);
        campoEmail =findViewById(R.id.email_edttxt);
        campoSenha =findViewById(R.id.senha_edttxt);
        campoAltura =findViewById(R.id.altura_edittxt);
        campoPeso =findViewById(R.id.peso_edttxt);
        campoParente = findViewById(R.id.parente_edittxt);
        campoContatoParente = findViewById(R.id.contatoParente_edittxt);
    }

    private void configuraBotaoSalvar(){
        Button botaoSalvar = findViewById(R.id.enviarCadastro_button);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finalizaCadastro();

            }
        });
    }

    private void finalizaCadastro() {
        preencheUser();
        if(user.temIdValido()){
            dao.edita(user);
        }else{
            dao.salvar(user);
        }
       // Toast.makeText(getApplication(), "usuário Salvo com sucesso", Toast.LENGTH_SHORT).show();
    }

    private void preencheUser(){
        String nome = campoNome.getText().toString();
        Integer idade = Integer.valueOf(campoIdade.getText().toString());
        String email = campoEmail.getText().toString();
        String senha = campoSenha.getText().toString();
        Float altura = Float.valueOf(campoAltura.getText().toString());
        Float peso = Float.valueOf(campoPeso.getText().toString());
        String parente = campoParente.getText().toString();
        String contatoParente = campoParente.getText().toString();

        user.setNome(nome);
        user.setIdade(idade);
        user.setEmail(email);
        user.setSenha(senha);
        user.setAltura(altura);
        user.setPeso(peso);
        user.setParente(parente);
        user.setContato_parente(contatoParente);

    }
}
