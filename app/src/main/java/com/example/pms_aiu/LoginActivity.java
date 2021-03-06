package com.example.pms_aiu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pms_aiu.NavigationMenu.HomePageActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private Button mSignInBtn, mCloseBtn;


    private EditText mEmail, mPassword;

    private TextView mVerifyText;
    private FirebaseAuth firebaseAuth;


    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mCloseBtn = findViewById(R.id.closeBtn);
        mCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent welcomeIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(welcomeIntent);
            }
        });



        mEmail = findViewById(R.id.etEmail_login);
        mPassword = findViewById(R.id.etPsw_login);
        mVerifyText = findViewById(R.id.verify_email_text);

        progressBar = findViewById(R.id.progressBar);


        mSignInBtn = findViewById(R.id.signInBtn);

        firebaseAuth = FirebaseAuth.getInstance();
        mSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmail.getText().toString().trim();
                final String psw = mPassword.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(psw)) {
                    mPassword.setError("Password is required");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);


                firebaseAuth.signInWithEmailAndPassword(email, psw).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                progressBar.setVisibility(View.GONE);

                                if (task.isSuccessful()) {

                                    if (firebaseAuth.getCurrentUser().isEmailVerified()) {

                                        if(firebaseAuth.getCurrentUser().getEmail().equals("pmsaiuapp@gmail.com")){
                                            startActivity(new Intent(LoginActivity.this,
                                                    HomePageActivity.class));
                                        }else {
                                            startActivity(new Intent(LoginActivity.this,
                                                    HomePageActivity.class));
                                            finish();
                                        }
                                    } else {
                                        mVerifyText.setVisibility(View.VISIBLE);
                                    }


                                } else {
                                    Toast.makeText(LoginActivity.this, task.getException().getMessage()
                                            , Toast.LENGTH_SHORT).show();
                                }
                            }

                        });

                    }


        });

    }
}
