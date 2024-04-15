package com.example.myapplicationexp6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleLogin();
            }
        });
        // Initialize textViewAlert
        TextView textViewAlert = findViewById(R.id.textViewAlert);
    }

    private void handleLogin() {
        EditText userIdEditText = findViewById(R.id.editTextUserId);
        EditText passwordEditText = findViewById(R.id.editTextPassword);

        String userId = userIdEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (userId.equals("correctUserId") && password.equals("correctPassword")) {
            showAlert("Login successful!");
        } else if (userId.isEmpty() || password.isEmpty()) {
            showAlert("Please enter both User ID and Password.");
        } else {
            showAlert("Login failed. Check User ID and Password.");
        }
    }

    private void showAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Handle OK button click if needed
                        // For example, you can close the activity
                        finish();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}

