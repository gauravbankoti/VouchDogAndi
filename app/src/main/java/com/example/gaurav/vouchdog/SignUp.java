package com.example.gaurav.vouchdog;

import android.content.Intent;
import android.os.AsyncTask;
import android.preference.PreferenceActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;

import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends AppCompatActivity {

    TextView tv7;
    EditText ed1, ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        tv7=(TextView)findViewById(R.id.textView7);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.vouch2);


        Button Login = (Button) findViewById(R.id.button3);
        Button reset=(Button)findViewById(R.id.button2);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = ed1.getEditableText().toString();
                String s2 = ed2.getEditableText().toString();
             //  new ExecuteTask().execute(s1,s2);
                //temp code written below
                Intent intent = new Intent(getApplicationContext(), Home.class);

                startActivity(intent);





            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        TextView tv6 = (TextView) findViewById(R.id.textView6);
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignActivity.class);

                startActivity(intent);
            }
        });


    }
    class ExecuteTask extends AsyncTask<String, Integer, String>
    {

        @Override
        protected String doInBackground(String... params) {

            String res=PostData(params);

            return res;
        }

        @Override
        protected void onPostExecute(String result) {

           Toast.makeText(getApplicationContext(),"login successful", Toast.LENGTH_LONG).show();

            JSONObject mainObject = null;
            String firstname=null;
            try {
                mainObject = new JSONObject(result);
                String id=mainObject.getString("vouchdogid");
                tv7.append(id);
                firstname=mainObject.getString("firstName");
                tv7.append(firstname);
                String lastname=mainObject.getString("lastName");
                tv7.append(lastname);


                Intent intent=new Intent(getApplicationContext(),Home.class);
                intent.putExtra("Name",firstname);
                intent.putExtra("Lastname",lastname);
                intent.putExtra("Vouch",id);
                startActivity(intent);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    public String PostData(String[] values) {
        String s="";
        try
        {

            HttpClient httpClient=new DefaultHttpClient();
            HttpPost httpPost=new HttpPost("http://54.201.57.57:8080/api/login");

            List<NameValuePair> list=new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("username", values[0]));
            list.add(new BasicNameValuePair("password",values[1]));
            httpPost.setEntity(new UrlEncodedFormEntity(list));
            HttpResponse httpResponse=  httpClient.execute(httpPost);



            HttpEntity httpEntity=httpResponse.getEntity();
            s= readResponse(httpResponse);


        }
        catch(Exception exception)  {}
        return s;


    }
    public String readResponse(HttpResponse res) {
        InputStream is=null;
        String return_text="";
        try {
            is=res.getEntity().getContent();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is));
            String line="";
            StringBuffer sb=new StringBuffer();
            while ((line=bufferedReader.readLine())!=null)
            {
                sb.append(line);
            }
            return_text=sb.toString();
        } catch (Exception e)
        {

        }
        return return_text;

    }

}






