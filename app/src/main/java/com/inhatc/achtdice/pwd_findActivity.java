package com.inhatc.achtdice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class pwd_findActivity extends AppCompatActivity {

    EditText edit_Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwd_find);

        edit_Email = findViewById(R.id.edit_Email2);

        findViewById(R.id.btn_pwd_email).setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_pwd_email:
                    pwd_email();
                    break;
            }
        }
    };
    private void pwd_email() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAddress = edit_Email.getText().toString();
        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.v("이메일","이메일 전송");
                        }
                    }
                });
    }


}