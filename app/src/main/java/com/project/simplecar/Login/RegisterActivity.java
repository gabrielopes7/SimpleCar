package com.project.simplecar.Login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.project.simplecar.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText  mNomeCompleto, mEmail, mPassword,mPasswordAgain;
    private Button mBtnRegistrar;
    private TextView mFacaLogin;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mNomeCompleto = findViewById(R.id.edtRegisterNome);
        mEmail = findViewById(R.id.edtRegisterEmail);
        mPassword = findViewById(R.id.edtRegisterPassword);
        mPasswordAgain = findViewById(R.id.edtRegisterPasswordAgain);
        mBtnRegistrar = findViewById(R.id.btnRegistrar);
        mFacaLogin = findViewById(R.id.txtFacaLogin);
        mAuth = FirebaseAuth.getInstance();

        mBtnRegistrar.setOnClickListener(view ->{
            String email = mEmail.getText().toString().trim();
            String password = mPassword.getText().toString().trim();
            String passwordVerify = mPasswordAgain.getText().toString().trim();

            if(!password.equals(passwordVerify))
                Toast.makeText(this, "As senhas não coicidem !", Toast.LENGTH_LONG).show();

        });
    }
}