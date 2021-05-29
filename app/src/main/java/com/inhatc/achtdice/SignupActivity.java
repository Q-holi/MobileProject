package com.inhatc.achtdice;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {

   private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth=FirebaseAuth.getInstance();

        findViewById(R.id.btn_BDinput).setOnClickListener(onClickListener);

    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_BDinput:
                    signup();
                    break;

            }
        }
    };

    private void signup(){
        String id =((EditText)findViewById(R.id.edit_id)).getText().toString();
        String password =((EditText)findViewById(R.id.edit_Password)).getText().toString();
        String name =((EditText)findViewById(R.id.edit_Name)).getText().toString();
        String email =((EditText)findViewById(R.id.edit_Email)).getText().toString();

        mAuth.createUserWithEmailAndPassword(id,password).addOnCompleteListener(this,new
                OnCompleteListener<AuthResult>(){
            @Override
                    public  void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    Toast.makeText(SignupActivity.this,"회원가입 성공",Toast.LENGTH_SHORT).show();

                }else{
                    if(task.getException().toString()!=null){
                        Toast.makeText(SignupActivity.this,"회원가입 실패",Toast.LENGTH_SHORT).show();
                    }

                }
            }
                });
    }


}