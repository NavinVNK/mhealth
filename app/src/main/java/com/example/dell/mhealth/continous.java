package com.example.dell.mhealth;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

/**
 * Created by DELL on 20-02-2016.
 */
public class continous extends  MainActivity {
    ImageView t1=null;

    ImageView t2=null;
    ImageView t3=null;

    ImageView t4=null;

    ImageView t5=null;
    ImageView t6=null;

    ImageView s=null;


    ImageView t8=null;
    ImageView t9=null;
    ImageView t10=null;
    ImageView t11=null;
    ImageView t12=null;
    ImageView t13=null;
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
        setContentView(R.layout.continous_phase);

        t1=(ImageView)findViewById(R.id.t1);
        t1.setClickable(true);

        t2=(ImageView)findViewById(R.id.t2);
        t3=(ImageView)findViewById(R.id.t3);
        t4=(ImageView)findViewById(R.id.t4);
        t5=(ImageView)findViewById(R.id.t5);
        t6=(ImageView)findViewById(R.id.t6);
        s=(ImageView)findViewById(R.id.t7);

        t8=(ImageView)findViewById(R.id.t8);
        t9=(ImageView)findViewById(R.id.t9);
        t10=(ImageView)findViewById(R.id.t10);
        t11=(ImageView)findViewById(R.id.t11);
        t12=(ImageView)findViewById(R.id.t12);
        t13=(ImageView) findViewById(R.id.t13);

        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        count=globalVariable.getCount() + globalVariable.getTempCount();
        StringBuilder a = new StringBuilder();
        a.append(leftpad(13, count));
        a.reverse();
        char bin[]=a.toString().toCharArray();
        Toast.makeText(getApplicationContext(),leftpad(13, count),Toast.LENGTH_LONG).show();
        int i=0;
        sum =0;
        sum=globalVariable.getCount();
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
sum+=1;
                t1.setBackgroundColor(Color.parseColor("#000000"));
                t1.setEnabled(false);

                Drawable myIcon5 = getResources().getDrawable(R.drawable.tak);
                t1.setImageDrawable(myIcon5);

            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
sum+=2;
                t2.setBackgroundColor(Color.parseColor("#000000"));
                t2.setEnabled(false);

                Drawable myIcon5 = getResources().getDrawable(R.drawable.tak);
                t2.setImageDrawable(myIcon5);

            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
sum+=4;
                t3.setBackgroundColor(Color.parseColor("#000000"));
                t3.setEnabled(false);

                Drawable myIcon5 = getResources().getDrawable(R.drawable.tak);
                t3.setImageDrawable(myIcon5);

            }
        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
sum+=8;
                t4.setBackgroundColor(Color.parseColor("#000000"));
                t4.setEnabled(false);

                Drawable myIcon5 = getResources().getDrawable(R.drawable.tak);
                t4.setImageDrawable(myIcon5);

            }
        });

        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
sum+=16;
                t5.setBackgroundColor(Color.parseColor("#000000"));
                t5.setEnabled(false);

                Drawable myIcon5 = getResources().getDrawable(R.drawable.tak);
                t5.setImageDrawable(myIcon5);

            }
        });

        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
sum+=32;
                t6.setBackgroundColor(Color.parseColor("#000000"));
                t6.setEnabled(false);

                Drawable myIcon5 = getResources().getDrawable(R.drawable.tak);
                t6.setImageDrawable(myIcon5);

            }
        });

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
sum+=64;
                s.setBackgroundColor(Color.parseColor("#000000"));
                s.setEnabled(false);

                Drawable myIcon5 = getResources().getDrawable(R.drawable.tak);
                s.setImageDrawable(myIcon5);

            }
        });

        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
sum+=128;
                t8.setBackgroundColor(Color.parseColor("#000000"));
                t8.setEnabled(false);

                Drawable myIcon5 = getResources().getDrawable(R.drawable.tak);
                t8.setImageDrawable(myIcon5);
            }
        });

        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
sum+=256;
                t9.setBackgroundColor(Color.parseColor("#000000"));
                t9.setEnabled(false);

                Drawable myIcon5 = getResources().getDrawable(R.drawable.tak);
                t9.setImageDrawable(myIcon5);

            }
        });

        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
sum+=512;
                t10.setBackgroundColor(Color.parseColor("#000000"));
                t10.setEnabled(false);

                Drawable myIcon5 = getResources().getDrawable(R.drawable.tak);
                t10.setImageDrawable(myIcon5);

            }
        });

        t11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
sum+=1024;
                t11.setBackgroundColor(Color.parseColor("#000000"));
                t11.setEnabled(false);

                Drawable myIcon5 = getResources().getDrawable(R.drawable.tak);
                t11.setImageDrawable(myIcon5);

            }
        });

        t12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
sum+=2048;
                t12.setBackgroundColor(Color.parseColor("#000000"));
                t12.setEnabled(false);

                Drawable myIcon5 = getResources().getDrawable(R.drawable.tak);
                t12.setImageDrawable(myIcon5);
            }
        });

        t13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
sum+=4096;
                t13.setBackgroundColor(Color.parseColor("#000000"));
                t13.setEnabled(false);

                Drawable myIcon5 = getResources().getDrawable(R.drawable.tak);
                t13.setImageDrawable(myIcon5);
             //   break;
            }
        });
        Button b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=""+sum;
                new MedicineActivity(continous.this).execute(globalVariable.get_userid(),s);
            }
        });
        while(i<13) {
            // String a= "" +bin[i];
           if (bin[i] == '1') {
                switch (i) {
                    case 0:
                        t1.setBackgroundColor(Color.parseColor("#000000"));
                        t1.setEnabled(false);

                        Drawable myIcon = getResources().getDrawable(R.drawable.tak);
                        t1.setImageDrawable(myIcon);
                        //  t1.setVisibility(View.INVISIBLE);
                        break;

                    case 1:
                        t2.setBackgroundColor(Color.parseColor("#000000"));
                        t2.setEnabled(false);
                        Drawable myIcon1 = getResources().getDrawable(R.drawable.tak);
                        t2.setImageDrawable(myIcon1);
                        //   t2.setVisibility(View.INVISIBLE);
                        break;

                    case 2:
                        //   t3.setVisibility(View.INVISIBLE);
                        t3.setBackgroundColor(Color.parseColor("#000000"));
                        t3.setEnabled(false);

                        Drawable myIcon2 = getResources().getDrawable(R.drawable.tak);
                        t3.setImageDrawable(myIcon2);
                        break;
                    case 3:
                        //t4.setVisibility(View.INVISIBLE);
                        t4.setBackgroundColor(Color.parseColor("#000000"));
                        t4.setEnabled(false);

                        Drawable myIcon3 = getResources().getDrawable(R.drawable.tak);
                        t4.setImageDrawable(myIcon3);
                        break;
                    case 4:
                        //   t5.setVisibility(View.INVISIBLE);
                        t5.setBackgroundColor(Color.parseColor("#000000"));
                        t5.setEnabled(false);

                        Drawable myIcon4 = getResources().getDrawable(R.drawable.tak);
                        t5.setImageDrawable(myIcon4);
                        break;
                    case 5:
                        //      t6.setVisibility(View.INVISIBLE);
                        t6.setBackgroundColor(Color.parseColor("#000000"));
                        t6.setEnabled(false);

                        Drawable myIcon5 = getResources().getDrawable(R.drawable.tak);
                        t6.setImageDrawable(myIcon5);
                        break;
                    case 6:
                        //  t7.setVisibility(View.INVISIBLE);
                        s.setBackgroundColor(Color.parseColor("#000000"));
                        s.setEnabled(false);
                        Drawable myIcon6 = getResources().getDrawable(R.drawable.tak);
                        s.setImageDrawable(myIcon6);
                        break;
                    case 7:
                        //  t7.setVisibility(View.INVISIBLE);
                        t8.setBackgroundColor(Color.parseColor("#000000"));
                        t8.setEnabled(false);
                        Drawable myIcon7 = getResources().getDrawable(R.drawable.tak);
                        t8.setImageDrawable(myIcon7);
                        break;
                    case 8:
                        //  t7.setVisibility(View.INVISIBLE);
                        t9.setBackgroundColor(Color.parseColor("#000000"));
                        t9.setEnabled(false);
                        Drawable myIcon8 = getResources().getDrawable(R.drawable.tak);
                        t9.setImageDrawable(myIcon8);
                        break;
                    case 9:
                        //  t7.setVisibility(View.INVISIBLE);
                        t10.setBackgroundColor(Color.parseColor("#000000"));
                        t10.setEnabled(false);
                        Drawable myIcon9 = getResources().getDrawable(R.drawable.tak);
                        t10.setImageDrawable(myIcon9);
                        break;
                    case 10:
                        //  t7.setVisibility(View.INVISIBLE);
                        t11.setBackgroundColor(Color.parseColor("#000000"));
                        t11.setEnabled(false);
                        Drawable myIcon10 = getResources().getDrawable(R.drawable.tak);
                        t11.setImageDrawable(myIcon10);
                        break;
                    case 11:
                        //  t7.setVisibility(View.INVISIBLE);
                        t12.setBackgroundColor(Color.parseColor("#000000"));
                        t12.setEnabled(false);
                        Drawable myIcon11 = getResources().getDrawable(R.drawable.tak);
                        t12.setImageDrawable(myIcon11);
                        break;
                    case 12:
                        //  t7.setVisibility(View.INVISIBLE);
                        t13.setBackgroundColor(Color.parseColor("#000000"));
                        t13.setEnabled(false);
                        Drawable myIcon12 = getResources().getDrawable(R.drawable.tak);
                        t13.setImageDrawable(myIcon12);
                        break;


                    default:
                        break;
                }
            }
        i++;
        }


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
            pd=new ProgressDialog(continous.this);
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

}
