package com.example.newapiloginbyjamls;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class HomaActivity extends AppCompatActivity {

    TextView name , email , phone,pincode,car_num;
    ImageView chooseCategoryImage;
    public static final int PICK_IMAGE=1;
    Uri ImageUri;

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
                startActivityForResult(gallaryIntent, 1);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==PICK_IMAGE && resultCode==RESULT_OK){
            ImageUri=data.getData();
            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),ImageUri);
                chooseCategoryImage.setImageBitmap(bitmap);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}