package com.example.dell.mhealth;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import org.apache.http.HttpConnection;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONTokener;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.net.URI;

import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    EditText e1 = null;
    TextView res;
    boolean flag;
    ProgressDialog pd = null;
    public static final String MyPREFERENCES = "MyPrefs" ;

    public boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("https://www.google.com"); //You can replace it with your name

            if (ipAddr.equals("")) {
                return false;
            } else {
                return true;
            }

        } catch (Exception e) {
            return false;
        }

    }

    String user_id = "";
    String sno = "";
    String sub_address = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
       // obj = this;
        SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        String restoredText = prefs.getString("sub_id", "");
        e1 = (EditText) findViewById(R.id.email);
        e1.setText(restoredText);
        e1.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {

                if(flag)
                {
                    res.setText("");
                    flag=false;
                }


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {


            }
        });

        res=(TextView)findViewById(R.id.result);
        Button b1 = (Button) findViewById(R.id.login);
        pd = new ProgressDialog(MainActivity.this);
        Toast.makeText(getApplicationContext(), "" + isInternetAvailable(), Toast.LENGTH_LONG).show();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String username = e1.getText().toString().trim();
                    //             Intent intent = new Intent(MainActivity.this, coursesummary.class);
                    //                startActivity(intent);
                    new SigninTask(MainActivity.this).execute(username);


                } catch (Exception e) {

                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void display(String avi) {

        Toast.makeText(getApplicationContext(), avi, Toast.LENGTH_LONG).show();
    }

    class SigninTask extends AsyncTask<String, Void, String> {

        private Context context;
        private int byGetOrPost = 0;
       // StringBuffer sb = null;

        //flag 0 means get and 1 means post.(By default it is get.)
        public SigninTask(Context context) {
            this.context = context;

        }

        protected void onPreExecute() {
            super.onPreExecute();

            pd.setTitle("Connecting...");
            pd.setMessage("Please wait....");
            pd.setCancelable(false);
            pd.show();

        }

        @Override
        protected String doInBackground(String... arg0) {
            HttpURLConnection conn=null;

            try {
                String username = (String) arg0[0];

                String link = "http://tbtrack.org/mobileJson/subscriber.php";//?user_id=" + username;
                String urlParameters="user_id=" + username;

                URL url = new URL(link);
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("USER-AGENT", "Mozilla/5.0");
                conn.setRequestProperty("ACCEPT-LANGUAGE", "en-US,en;0.5");
                conn.setReadTimeout(5000);
                conn.setConnectTimeout(5000);
                conn.setDoInput(true);
                DataOutputStream dStream = new DataOutputStream(conn.getOutputStream());
                dStream.writeBytes(urlParameters);
                dStream.flush();
                dStream.close();

                //conn.connect();
                String response="";
                int reqresponseCode = conn.getResponseCode();
                if (reqresponseCode == HttpsURLConnection.HTTP_OK) {
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    response=sb.toString();
                } else {
                    response = "";
                }
               /* int reqresponseCode = conn.getResponseCode();
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();

                request.setURI(new URI(link));


                HttpResponse response = client.execute(request);
                BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                sb = new StringBuffer("");
                String line = "";

                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    break;
                }


                return sb.toString();*/
                return response;
            } catch (Exception e) {
                return null;
                // return new String("Exception: " + e.getMessage());
            }
            finally {
                conn.disconnect();
            }

        }


        @Override
        protected void onPostExecute(String result) {
            if (null != result && !result.isEmpty()) {

                if (!result.equals("null")) {
                    try {
                        JSONObject json = new JSONObject(result);
                        sno = json.getString("sno");
                        user_id = json.getString("user_id");
                        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                        globalVariable.set_userid(user_id);
      /*  contact_person_id = json.getString("contact_person_id");
        dot_id = json.getString("dot_id");
        doc_id = json.getString("doc_id");
        TB_no = json.getString("TB_no");
        TB_unit = json.getString("TB_unit");
        Nikshay_no = json.getString("Nikshay_no");
        Name_phi = json.getString("Name_phi");
        HIV = json.getString("HIV");
        image_path = json.getString("image_path");
        disease_serial_no = json.getString("disease_serial_no");
        sub_sex = json.getString("sub_sex");
        sub_DOB = json.getString("sub_DOB");
        sub_occupation = json.getString("sub_occupation");*/

                        sub_address = json.getString("sub_address");
 /*   sub_city = (String) json.get("sub_city");
    sub_state = (String) json.get("sub_state");
    sub_email = (String) json.get("sub_email");
    sub_blood_group = (String) json.get("sub_blood_group");
    sub_type = (String) json.get("sub_type");
                sub_contact = (String) json.get("sub_contact");*/


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (!user_id.equals("")) {
                        //  new IntakeCount(MainActivity.this).execute(MainActivity.user_id);
                        Intent intent = new Intent(MainActivity.this, navigation.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(getApplicationContext(), "User invalid", Toast.LENGTH_SHORT).show();
                        res.setText("Invalid User");
                        flag=true;
                        pd.dismiss();
                    }
                } else {
                    pd.dismiss();
                    Toast.makeText(getApplicationContext(), "User invalid", Toast.LENGTH_SHORT).show();
                    res.setText("Invalid User");
                    flag=true;
                }
//            Toast.makeText(getApplicationContext(), data.toString(), Toast.LENGTH_LONG).show();


            } else {
                pd.dismiss();
                FragmentManager fm = getSupportFragmentManager();

                InternetCheckDialogFragment iFragment = new InternetCheckDialogFragment();
                // Show DialogFragment
                iFragment.show(fm, "Internet Check");
                //Toast.makeText(getApplicationContext(), "Check your Internet connection!!!", Toast.LENGTH_SHORT).show();
            }


        }
    }
}