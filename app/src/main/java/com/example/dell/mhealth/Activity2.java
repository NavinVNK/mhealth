package com.example.dell.mhealth;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
//import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import android.graphics.drawable.Drawable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
/**
 * Created by DELL on 13-02-2016.
 */
public class Activity2 extends AppCompatActivity
{
    ProgressDialog pd=null;
    ImageView t1=null;

   ImageView t2=null;
    ImageView t3=null;

    ImageView t4=null;

    ImageView t5=null;
    ImageView t6=null;

    ImageView t7=null;

int count=0;
  public  int sum=0;
    public String leftpad(int count,int x)
    {


        String bin=Integer.toBinaryString(x);
        int len=bin.length();
        System.out.println(len);
        int temp=count-len;
        String binary="";
        for(int i=0;i<temp;i++)
        {
            binary+="0";
        }
        binary=binary+bin;
      //  System.out.println(binary);
return binary;
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity22);
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        sum=globalVariable.getCount();
      count=  globalVariable.getCount();
        Toast.makeText(getApplicationContext(),globalVariable.getName(),Toast.LENGTH_LONG).show();
        StringBuilder a = new StringBuilder();
a.append(leftpad(7,count));
        a.reverse();
        char bin[]=a.toString().toCharArray();


        Button b1=(Button)findViewById(R.id.b1);
t1=(ImageView)findViewById(R.id.t1);
        t1.setClickable(true);

        t2=(ImageView)findViewById(R.id.t2);
        t3=(ImageView)findViewById(R.id.t3);
        t4=(ImageView)findViewById(R.id.t4);
        t5=(ImageView)findViewById(R.id.t5);
        t6=(ImageView)findViewById(R.id.t6);
        t7=(ImageView)findViewById(R.id.t7);
        int i=0;

        Toast.makeText(getApplicationContext(), leftpad(7,count) +""
                , Toast.LENGTH_LONG).show();
        while(i<7)
        {
           // String a= "" +bin[i];
            if(bin[i]=='1')
            {
        switch (i)
        {
            case 0:
                t1.setBackgroundColor(Color.parseColor("#000000"));
                t1.setEnabled(false);

                Drawable myIcon = getResources().getDrawable( R.drawable.tak1); t1.setImageDrawable(myIcon);
              //  t1.setVisibility(View.INVISIBLE);
                break;

            case 1:
                t2.setBackgroundColor(Color.parseColor("#000000"));
                t2.setEnabled(false);
                Drawable myIcon1 = getResources().getDrawable( R.drawable.tak1);t2.setImageDrawable(myIcon1);
             //   t2.setVisibility(View.INVISIBLE);
                break;

            case 2:
             //   t3.setVisibility(View.INVISIBLE);
                t3.setBackgroundColor(Color.parseColor("#000000"));
                t3.setEnabled(false);

                Drawable myIcon2 = getResources().getDrawable( R.drawable.rountak1);
                t3.setImageDrawable(myIcon2);
                break;
            case 3:
                //t4.setVisibility(View.INVISIBLE);
                t4.setBackgroundColor(Color.parseColor("#000000"));
                t4.setEnabled(false);

                Drawable myIcon3 = getResources().getDrawable( R.drawable.rountak1);t4.setImageDrawable(myIcon3);
                break;
            case 4:
             //   t5.setVisibility(View.INVISIBLE);
                t5.setBackgroundColor(Color.parseColor("#000000"));
                t5.setEnabled(false);

                Drawable myIcon4 = getResources().getDrawable( R.drawable.rountak1);t5.setImageDrawable(myIcon4);
                break;
            case 5:
          //      t6.setVisibility(View.INVISIBLE);
                t6.setBackgroundColor(Color.parseColor("#000000"));
                t6.setEnabled(false);

                Drawable myIcon5 = getResources().getDrawable( R.drawable.rountak1);t6.setImageDrawable(myIcon5);
                break;
            case 6:
              //  t7.setVisibility(View.INVISIBLE);
                t7.setBackgroundColor(Color.parseColor("#000000"));
                t7.setEnabled(false);
                Drawable myIcon6 = getResources().getDrawable( R.drawable.tak1);
                t7.setImageDrawable(myIcon6);
                break;

        }
            }
            i++;
        }


        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum+=1;

                t1.setBackgroundColor(Color.parseColor("#000000"));
                t1.setEnabled(false);
                //t1.setVisibility(View.INVISIBLE);
                Drawable myIcon = getResources().getDrawable( R.drawable.tak1); t1.setImageDrawable(myIcon);
                //ColorFilter filter = new LightingColorFilter( Color.BLUE, Color.BLUE );
                // myIcon.setColorFilter(filter);


            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum+=2;
                t2.setBackgroundColor(Color.parseColor("#000000"));
                t2.setEnabled(false);
                Drawable myIcon = getResources().getDrawable( R.drawable.tak1);
                //ColorFilter filter = new LightingColorFilter( Color.BLUE, Color.BLUE );
                // myIcon.setColorFilter(filter);
                t2.setImageDrawable(myIcon);

               // t2.setVisibility(View.INVISIBLE);
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum+=4;
           //    t3.setVisibility(View.INVISIBLE);
              t3.setBackgroundColor(Color.parseColor("#000000"));

                Drawable myIcon = getResources().getDrawable( R.drawable.rountak1); t3.setImageDrawable(myIcon);
                t3.setEnabled(false);

            }
        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum+=8;
                t4.setBackgroundColor(Color.parseColor("#000000"));
            t4.setEnabled(false);

                Drawable myIcon = getResources().getDrawable( R.drawable.rountak1); t4.setImageDrawable(myIcon);
                //t4.setVisibility(View.INVISIBLE);
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum+=16;
                t5.setBackgroundColor(Color.parseColor("#000000"));
            t5.setEnabled(false);

                Drawable myIcon = getResources().getDrawable( R.drawable.rountak1); t5.setImageDrawable(myIcon);
           //     t5.setVisibility(View.INVISIBLE);
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum+=32;
                t6.setBackgroundColor(Color.parseColor("#000000"));
            t6.setEnabled(false);

                Drawable myIcon = getResources().getDrawable( R.drawable.rountak1);

                t6.setImageDrawable(myIcon);
              //  t6.setVisibility(View.INVISIBLE);
            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum+=64;
                t7.setBackgroundColor(Color.parseColor("#000000"));
            t7.setEnabled(false);

                Drawable myIcon = getResources().getDrawable( R.drawable.tak1); t7.setImageDrawable(myIcon);

           //     t7.setVisibility(View.INVISIBLE);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
String s=""+sum;
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

                new MedicineActivity(Activity2.this).execute(globalVariable.get_userid(),s);

            }
        });
     //   TextView v1=(TextView)findViewById(R.id.textView3);
     //   v1.setText(MainActivity.contact_person_id);
    }
    class MedicineActivity extends AsyncTask<String, Void, String> {
        private TextView statusField, roleField;
        private TextView t1 = null;
        private Context context;
        private int byGetOrPost = 0;
        StringBuffer sb = null;

        //flag 0 means get and 1 means post.(By default it is get.)
        public MedicineActivity(Context context) {
            this.context = context;


        }

        protected void onPreExecute() {
            pd=new ProgressDialog(Activity2.this);
            pd.setTitle("Updating...");
            pd.setMessage("Please wait....");
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected String doInBackground(String... arg0) {

            try {
                String username = (String) arg0[0];
                String count=(String) arg0[1];
                String link = "http://tbtrack.org/mobileJson/medice_intake_update_new.php?user_id=" + username + "&medicineCount="+count;

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
                return new String("Exception: " + e.getMessage());
            }
        }


        @Override
        protected void onPostExecute(String result) {
Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_LONG).show();
pd.dismiss();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(Activity2.this, navigation.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
