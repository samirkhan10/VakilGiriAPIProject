package com.example.newapiloginbyjamls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HomaActivity extends AppCompatActivity {

    TextView name , email , phone,pincode,car_num;
    ImageView chooseCategoryImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homa);

        name=(TextView)findViewById(R.id.name);
        email=(TextView)findViewById(R.id.email);
        phone=(TextView)findViewById(R.id.phone);
        pincode=(TextView)findViewById(R.id.pincode);
        car_num=(TextView)findViewById(R.id.car_num);
        chooseCategoryImage = findViewById(R.id.selectImage);

        chooseCategoryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallaryIntent = new Intent();
                gallaryIntent.setAction(Intent.ACTION_GET_CONTENT);
                gallaryIntent.setType("image/*");
                startActivityForResult(gallaryIntent, 2);
            }
        });


        String uname = getIntent().getStringExtra("name");
        String uemail = getIntent().getStringExtra("email");
        String uphone = getIntent().getStringExtra("phone");
        String upincode = getIntent().getStringExtra("pincode");
        String ucar_num = getIntent().getStringExtra("car_num");



        name.setText(uname);
        email.setText(uemail);
        phone.setText(uphone);
        pincode.setText(upincode);
        car_num.setText(ucar_num);



    }
}