package com.example.rajesh.builduiwithactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView fullname,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initialize();

        String firstname=getIntent().getStringExtra("firstname");
        String lastname=getIntent().getStringExtra("lastname");

        fullname.setText("Welcome "+firstname+" "+lastname);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public  void initialize()
    {
        fullname=findViewById(R.id.fullname);
        back=findViewById(R.id.back);
    }

}
