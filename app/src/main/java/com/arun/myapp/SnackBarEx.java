package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class SnackBarEx extends AppCompatActivity {

    Button button;
    CoordinatorLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar_ex);

        button=(Button) findViewById(R.id.btnSnackbar);
        layout=findViewById(R.id.layout);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SnackBarEx.this, "", Toast.LENGTH_SHORT).show();
                Snackbar snackbar=Snackbar.make(layout,"Message deleted",Snackbar.LENGTH_SHORT).setAction("undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(SnackBarEx.this, "UNDO CLICKED", Toast.LENGTH_SHORT).show();
                    }
                });
                snackbar.show();
            }
        });
    }
}