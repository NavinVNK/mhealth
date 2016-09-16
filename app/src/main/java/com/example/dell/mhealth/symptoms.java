package com.example.dell.mhealth;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;

import java.net.InetAddress;

import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

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


/**
 * Created by DELL on 17-02-2016.
 */
public class symptoms extends AppCompatActivity {
    int sum = 0;
    ProgressDialog pd = null;

    class SendSymptoms extends AsyncTask<String, Void, String> {
        private TextView statusField, roleField;
        private TextView t1 = null;
        private Context context;
        private int byGetOrPost = 0;
        StringBuffer sb = null;

        //flag 0 means get and 1 means post.(By default it is get.)
        public SendSymptoms(Context context) {

            this.context = context;


        }

        protected void onPreExecute() {
            pd = new ProgressDialog(symptoms.this);
            pd.setTitle("Updating...");
            pd.setMessage("Please wait....");
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected String doInBackground(String... arg0) {

            try {
                String username = (String) arg0[0];
                String count = (String) arg0[1];
                String link = "http://tbtrack.org/mobileJson/sendSymptoms.php?user_id=" + username + "&count=" + count;

                URL url = new URL(link);
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

                return sb.toString();
            } catch (Exception e) {
                FragmentManager fm = getSupportFragmentManager();

                InternetCheckDialogFragment iFragment = new InternetCheckDialogFragment();
                // Show DialogFragment
                iFragment.show(fm, "Internet Check");
                return new String("Exception: " + e.getMessage());


            }
        }


        @Override
        protected void onPostExecute(String result) {
            //Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_LONG).show();
            pd.dismiss();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.symtoms_row);
        final CheckBox s1 = (CheckBox) findViewById(R.id.checkBox1);

        final CheckBox s2 = (CheckBox) findViewById(R.id.checkBox2);

        final CheckBox s3 = (CheckBox) findViewById(R.id.checkBox3);

        final CheckBox s4 = (CheckBox) findViewById(R.id.checkBox4);
        final CheckBox s5 = (CheckBox) findViewById(R.id.checkBox5);

        final CheckBox s6 = (CheckBox) findViewById(R.id.checkBox6);

        Button b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                sum = 0;
                if (s1.isChecked()) {
                    sum += 1;
                 //   s1.setChecked(false);
                }


                if (s2.isChecked()) {
                    sum += 2;
                   // s2.setChecked(false);
                }

                if (s3.isChecked()) {
                    sum += 4;
                  //  s3.setChecked(false);
                }

                if (s4.isChecked()) {
                    sum += 8;
                   // s4.setChecked(false);
                }

                if (s5.isChecked()) {
                    sum += 16;
                }

                if (s6.isChecked()) {
                    sum += 32;
                }
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

                new SendSymptoms(symptoms.this).execute(globalVariable.get_userid(), sum + "");
                //Toast.makeText(getApplicationContext(), "" + sum, Toast.LENGTH_LONG).show();
            }


        });


    }
}
