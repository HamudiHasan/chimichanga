package com.uiutesseract.nidavellir.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.uiutesseract.nidavellir.R;
import com.uiutesseract.nidavellir.utils.DialogUtils;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";
    private Button btnAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlert = findViewById(R.id.btn_alert);
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlert();
            }
        });

        findViewById(R.id.btn_splash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //splash();
                startActivity(new Intent(MainActivity.this, HTTPActivity.class));
            }
        }
        );
        findViewById(R.id.btn_recycler_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RecycleViewActivity.class));
            }
        }); findViewById(R.id.btn_tab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TabActivity.class));
            }
        });
    }

    private void showAlert() {
        final CharSequence[] items = {"Custom Alert", "Default Dialog",
                "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert Dialog With List!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {

                if (items[item].equals("Custom Alert")) {
                    DialogUtils.showDialog(MainActivity.this);

                } else if (items[item].equals("Default Dialog")) {
                    DialogUtils.defaultDialog(MainActivity.this);
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    public void splash() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "This toast will Appear after 500 millis", Toast.LENGTH_SHORT).show();

            }
        }, 500);
    }

}
