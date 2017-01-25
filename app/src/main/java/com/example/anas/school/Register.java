package com.example.anas.school;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    String username,password,confirmpassword,email,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        findViewById(R.id.bt_register_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username = ((EditText) findViewById(R.id.et_username_id)).getText().toString();
                email = ((EditText) findViewById(R.id.et_email_id)).getText().toString();
                phone =  ((EditText) findViewById(R.id.et_password_id)).getText().toString();
                password = ((EditText) findViewById(R.id.et_password_id)).getText().toString();
                confirmpassword = ((EditText) findViewById(R.id.et_confirmpassword_id)).getText().toString();

                if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || confirmpassword.isEmpty()) {
                    Toast.makeText(Register.this, "من فضلك سجل جميع البيانات", Toast.LENGTH_SHORT).show();

                } else {
                    if (username.length() > 2 && email.length() > 2 && phone.length() > 3 && password.length() > 3 && confirmpassword.length() > 3) {
                        Log.e("email valid", isValidEmail(email) + "");

                        if (isValidEmail(email)) {
                            if (password.equals(confirmpassword)) {
//                        SaveData();
                                Toast.makeText(Register.this, "done", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(Register.this, "كلمة السر خاطئة", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Register.this, "البريد الألكترونى خاطى", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Register.this, "البيانات لابد ان تكون اكثر من 3 حروف", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public boolean isValidEmail(CharSequence target) {
        Log.e("email", target + " m");
        if (target == null) {
            return false;
        } else {
            boolean res = android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
            Log.e("email check", res + "");
            return res;
        }
    }
    }

