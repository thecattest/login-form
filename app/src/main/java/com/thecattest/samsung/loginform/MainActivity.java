package com.thecattest.samsung.loginform;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button submit = findViewById(R.id.bt_submit);
        final Button remind = findViewById(R.id.bt_remind);
        final EditText et_login = findViewById(R.id.et_login);
        final EditText et_password = findViewById(R.id.et_password);

        submit.setOnClickListener(v -> {
            if (et_login.getText().toString().equals("admin")
                    && et_password.getText().toString().equals("12345")) {
                showDialogOk();
            }
            else {
                showDialogError();
            }
            et_login.setText("");
            et_password.setText("");
        });

        remind.setOnClickListener(v -> showReminder());
    }

    private void showReminder() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Correct Login and Password");
        builder.setMessage("Login: admin\nPassword: 12345");
        builder.setPositiveButton("Ok", (dialog, which) -> dialog.dismiss());

        builder.create().show();
    }

    private void showDialogError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error!");
        builder.setMessage("Incorrect Login or Password");
        builder.setPositiveButton("Try again", (dialog, which) -> {dialog.dismiss();});

        builder.create().show();
    }

    private void showDialogOk() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ok");
        builder.setMessage("Login and Password are correct");
        builder.setPositiveButton("Awesome!", (dialog, which) -> dialog.dismiss());

        builder.create().show();
    }
}