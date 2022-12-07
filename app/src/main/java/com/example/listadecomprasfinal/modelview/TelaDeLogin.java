package com.example.listadecomprasfinal.modelview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listadecomprasfinal.MainActivity;
import com.example.listadecomprasfinal.R;

public class TelaDeLogin extends AppCompatActivity {


    EditText login_tv, password_tv;
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_login);

        login_tv = (EditText) findViewById(R.id.login);
        password_tv = (EditText) findViewById(R.id.password);

        btnLogin = (Button) findViewById(R.id.button_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = login_tv.getText().toString();
                String password = password_tv.getText().toString();

                if (username.equals("admin") && (password.equals("12345")))
                {
                    Toast.makeText(TelaDeLogin.this, "Login realizado com sucesso", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }else
                {
                    Toast.makeText(TelaDeLogin.this, "Dados incorretos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}