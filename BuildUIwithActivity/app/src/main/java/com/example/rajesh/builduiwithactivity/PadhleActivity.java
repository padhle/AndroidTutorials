package com.example.rajesh.builduiwithactivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PadhleActivity extends AppCompatActivity {

    private static final String TAG="PadhleActivity";
    TextView call,next;
    EditText firstName,lastName,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_padhle);
        initialize();

        Log.e(TAG,"On Create Called");


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (ActivityCompat.checkSelfPermission(PadhleActivity.this,
                            Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {

                        Intent callintent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone.getText().toString().trim()));
                        startActivity(callintent);
                    }else {
                        final String[] PERMISSIONS_STORAGE = {Manifest.permission.CALL_PHONE};
                        //Asking request Permissions
                        ActivityCompat.requestPermissions(PadhleActivity.this, PERMISSIONS_STORAGE, 1);
                    }
                }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                explicitIntent();
            }
        });
    }

    public void initialize()
    {
        firstName=findViewById(R.id.firstName);
        lastName=findViewById(R.id.lastName);
        phone=findViewById(R.id.phone);
        call=findViewById(R.id.call);
        next=findViewById(R.id.next);
    }

    public void explicitIntent()
    {
        Intent intent=new Intent(PadhleActivity.this,SecondActivity.class);
        intent.putExtra("firstname",firstName.getText().toString().trim());
        intent.putExtra("lastname",lastName.getText().toString().trim());
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean permissionGranted = false;
        switch(requestCode){
            case 1:
                permissionGranted = grantResults[0]== PackageManager.PERMISSION_GRANTED;
                break;
        }
        if(permissionGranted){
            Intent callintent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone.getText().toString().trim()));
            startActivity(callintent);
        }else {
            Toast.makeText(PadhleActivity.this, "You don't assign permission.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.e(TAG,"On Start Called");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e(TAG,"On Resume Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"On Pause Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"On Stop Called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG,"On Restart Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"On Destroy Called");
    }


}
