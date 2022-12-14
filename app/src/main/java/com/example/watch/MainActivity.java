package com.example.watch;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.watch.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private TextView mTextView;
    private ActivityMainBinding binding;

    Button btn;

    EditText email;
    EditText password;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        btn = findViewById(R.id.button);

        Toast toastNoEmail = Toast.makeText(getApplicationContext(),
                "Вы не ввели почту", Toast.LENGTH_SHORT);
        Toast toastNoPassword = Toast.makeText(getApplicationContext(),
                "Вы не ввели почту", Toast.LENGTH_SHORT);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailValue = email.getText().toString();
                String passValue = password.getText().toString();

                if (emailValue.matches("")) {
                    toastNoEmail.show();
                    return;
                }
                if (passValue.matches("")) {
                    toastNoPassword.show();
                    return;
                }
                if (!emailValue.matches("") && !passValue.matches("")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Ошибка сервера. Вход в режиме гостя...")
                            .setTitle("Server error");
                    AlertDialog dialog = builder.create();
                    dialog.show();

                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            startActivity(intent);
                            finish();
                        }
                    };

                    new Handler().postDelayed(r, 3000);

                }
            }
        });


    }
}