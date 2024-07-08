package com.example.lab71;

import static android.widget.Toast.makeText;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSION_CODE = 10;
    private static final int REQUEST_CALL_PHONE = 11;
    private static final int REQUEST_SEND_SMS = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatButton btnRequestPermission = findViewById(R.id.button_request_permission);
        AppCompatButton btnOpenSettingsPermission = findViewById(R.id.button_open_setting);
        ImageView imgMessage = findViewById(R.id.imageView2);
        ImageView imgCall = findViewById(R.id.imageView);

        btnRequestPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickRequestPermission();
            }
        });

        imgMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SEND_SMS);
                } else {
                    sendSMS();
                }
            }
        });

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE);
                } else {
                    makeCall();
                }
            }
        });
    }

    private void sendSMS() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + "0782582404"));
        intent.putExtra("sms_body", "Chào bạn...");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void makeCall() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + "0782582404"));
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(intent);
        }
    }

    private void clickRequestPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            makeText(MainActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        } else {
            String permission = Manifest.permission.ACCESS_FINE_LOCATION;
            requestPermissions(new String[]{permission}, REQUEST_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makeText(MainActivity.this, "Location Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                makeText(MainActivity.this, "Location Permission Denied", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == REQUEST_CALL_PHONE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makeCall();
            } else {
                makeText(MainActivity.this, "Call Permission Denied", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == REQUEST_SEND_SMS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                sendSMS();
            } else {
                makeText(MainActivity.this, "SMS Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
