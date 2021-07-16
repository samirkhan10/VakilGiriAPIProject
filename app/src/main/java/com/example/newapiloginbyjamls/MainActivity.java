package com.example.newapiloginbyjamls;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{
    EditText t1,t2,t3,t4,t5;
    TextView tv1;
    Button b1;
    private static final String url="http://192.168.18.132/api/setdata.php";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        t3=(EditText)findViewById(R.id.t3);
        t4=(EditText)findViewById(R.id.t4);
        t5=(EditText)findViewById(R.id.t5);
        tv1=(TextView)findViewById(R.id.tv1);

        b1=(Button)findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processdata(t1.getText().toString(),t2.getText().toString(),t3.getText().toString() , t4.getText().toString(),t5.getText().toString());

            }
        });
    }

    public  void processdata(final String name, final String email ,final String phone ,final String pincode,final String car_num )
    {
        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                String name1 =  t1.getText().toString();
                String email1 =  t2.getText().toString();
                String phone1 =  t3.getText().toString();
                String pincode1 = t4.getText().toString();
                String car_num1 = t5.getText().toString();

                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                tv1.setText(response);

                Toast.makeText(MainActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this , HomaActivity.class);
                intent.putExtra("name",name1);
                intent.putExtra("email",email1);
                intent.putExtra("phone",phone1);
                intent.putExtra("pincode",pincode1);
                intent.putExtra("car_num",car_num1);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                tv1.setText(error.toString());
                tv1.setTextColor(Color.RED);
                tv1.setTextSize(14);
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<String, String>();
                map.put("name",name);
                map.put("email",email);
                map.put("phone",phone);
                map.put("pincode",pincode);
                map.put("car_num",car_num);
                return map;
            }
        };

        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }

}