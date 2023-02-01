package com.example.lab_1_s5;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etUsername;
    private EditText etPassword;
    private TextView tvNotAccountYet;
    private Button btnSignIn;

    private final String REQUIRE = "Require";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        etUsername = findViewById(R.id.editText1);
        etPassword = findViewById(R.id.editText2);
        tvNotAccountYet = findViewById(R.id.notaccount);
        btnSignIn = findViewById(R.id.button);

        tvNotAccountYet.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    private boolean checkInput(){
        if(TextUtils.isEmpty(etUsername.getText().toString())){
            etUsername.setError(REQUIRE);
            return false;
        }
        return true;
    }

    private void signIn(){
        if(!checkInput()){
            return;
        }
        Intent intent = new Intent( this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    private  void signUpForm(){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                signIn();
                break;
            case R.id.notaccount:
                signUpForm();
                break;
        }
    }
}
