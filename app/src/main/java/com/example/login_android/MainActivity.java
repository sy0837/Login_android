package com.example.login_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable.ProgressDrawableSize;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b;
    EditText e1;
    EditText e2;
    TextView t;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();
        b=findViewById(R.id.registerbutton);
        e1=findViewById(R.id.username);
        e2=findViewById(R.id.password);
        t=findViewById(R.id.signedin);
        b.setOnClickListener(this);
        t.setOnClickListener(this);



    }


    public  void registeruser(){
        String email=e1.getText().toString().trim();
        String password=e2.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Enter email",Toast.LENGTH_SHORT).show();
        return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Enter password",Toast.LENGTH_SHORT).show();
        return;
        }

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Registerd",Toast.LENGTH_SHORT).show();
                }
               // else
                   // Toast.makeText(MainActivity.this,"Couldnot register",Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v == b){
            registeruser();
        }
        if (v == t){}


    }
}
