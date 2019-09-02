package com.example.health_cation.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.health_cation.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.AccessToken;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private CallbackManager callbackManager;
    private EditText editText_login;
    private EditText editText_senha;
    private Button btn_login;
    private Button btn_cadastro;
    private AccessToken acessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        configuracoesDeCampo();

        configuraButtonLoginFacebook();

        configuraButtonLogin();

        configuraButtonCadastro();


    }

    private void configuraButtonLoginFacebook() {

        final LoginButton loginButton = findViewById(R.id.btn_facebook);
        callbackManager = CallbackManager.Factory.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {

                        try{
                            String name = object.getString("name");
                            String email = object.getString("email");
                            Toast.makeText(getApplicationContext(), "Name" + name + "Email"+email, Toast.LENGTH_LONG).show();
                        }catch(JSONException e ){
                            e.printStackTrace();
                        }
                    }
                });
                Bundle parameters = new Bundle();
                parameters.putString("fields","id, name, gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();


            }

            @Override
            public void onCancel() {
                Log.i("TAG", "onCancel");

            }

            @Override
            public void onError(FacebookException error) {
                Log.i("TAG", "onError");
            }
        });
    }

    private void configuraButtonLogin() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText_login.getText().length() == 0 || editText_senha.getText().length() == 0){
                    Toast.makeText(getApplication(),
                            "Os campos de Login e de senha são obrigatórios", Toast.LENGTH_LONG).show();
                }else{
                    /*Toast.makeText(getApplication(),
                            "Seja bem vindo "+editText_login.getText().toString()+"!",
                            Toast.LENGTH_LONG).show();*/
                    Intent it = new Intent(MainActivity.this, MenuInicialActivity.class);
                    startActivity(it);
                }
            }
        });
    }

    private void configuraButtonCadastro(){
        btn_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(it);
            }
        });
    }

    private void configuracoesDeCampo() {
        editText_login = (EditText)findViewById(R.id.editText_login);
        editText_senha = (EditText)findViewById(R.id.editText_password);
        btn_login = (Button) findViewById(R
                .id.btn_login);
        btn_cadastro =findViewById(R.id.btn_cadastro);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
       if(!isLoggedIn()){
            Intent it = new Intent(MainActivity.this, MenuInicialActivity.class);
            startActivity(it);
        }
    }

    public boolean isLoggedIn(){
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }
}

