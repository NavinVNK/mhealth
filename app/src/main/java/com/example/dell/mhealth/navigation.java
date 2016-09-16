package com.example.dell.mhealth;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.app.Dialog;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.AlertDialog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

/**
 * Created by DELL on 18-02-2016.
 */

public class navigation extends AppCompatActivity {
    ProgressDialog pd = null;
    String user;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;

    class IntakeCount extends AsyncTask<String, Void, String> {
        private TextView statusField, roleField;
        private TextView t1 = null;
        private Context context;
        private int byGetOrPost = 0;
        StringBuffer sb = null;

        //flag 0 means get and 1 means post.(By default it is get.)
        public IntakeCount(Context context) {
            this.context = context;


        }

        protected void onPreExecute() {
            pd = new ProgressDialog(navigation.this);
            pd.setTitle("Navigating...");
            pd.setMessage("Please wait....");
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected String doInBackground(String... arg0) {

            try {
                String username = (String) arg0[0];

                String link = "http://www.tbtrack.org/mobileJson/med_check_medicine.php?user_id=" + username;

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
            pd.dismiss();
            try {
                String temp[] = sb.toString().split(",");
                int count = Integer.parseInt(temp[2]);//medicine taken count

                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                globalVariable.setCount(count);
                //globalVariable.setCount(count);
                int day = Integer.parseInt(temp[1]);//days count
                int res = Integer.parseInt(temp[3]);//sputum result
                if (day <= 56) {
                    if (count <127) {
                        if (temp[0].equals("Monday") || temp[0].equals("Wednesday") || temp[0].equals("Friday")||true)// || temp[1].equals())
                        {

                            //     Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(navigation.this, Activity2.class);
                            startActivity(intent);
                            // finish();
                            //   pd.dismiss();

                        } else {
    //                pd.dismiss();
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                            builder1.setMessage("Today is " + temp[0] + ". No medicines today ....!!!!!");
                            builder1.setCancelable(true);

                            builder1.setPositiveButton(
                                    "Cancel",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });

                            builder1.setNegativeButton(
                                    "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });


                            AlertDialog alert11 = builder1.create();
                            alert11.show();
                            //  Toast.makeText(getApplicationContext(),"Not valid",Toast.LENGTH_LONG).show();
                        }
                    } else {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                        builder1.setMessage("You have already taken the medicines...!!!!!");
                        builder1.setCancelable(true);

                        builder1.setPositiveButton(
                                "Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        builder1.setNegativeButton(
                                "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });


                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }
                } else if (day > 56 && day <= 84 && res == 1) {

                    if (temp[0].equals("Monday") || temp[0].equals("Thursday") || temp[0].equals("Friday")||true)// || temp[1].equals())
                    {

                        //     Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(navigation.this, prolongation.class);
                        startActivity(intent);
                        // finish();
                        //   pd.dismiss();

                    } else {
    //                pd.dismiss();
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                        builder1.setMessage("Today is " + temp[0] + ". No medicines today ....!!!!!");
                        builder1.setCancelable(true);

                        builder1.setPositiveButton(
                                "Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        builder1.setNegativeButton(
                                "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });


                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                        //  Toast.makeText(getApplicationContext(),"Not valid",Toast.LENGTH_LONG).show();
                    }


    //oast.makeText(getApplicationContext(),"Prolongation phase",Toast.LENGTH_LONG).show();
                } else {
                    //     if(temp[0].equals("Monday"))
                    if (temp[4].equals("cat1")) {

                        if (temp[0].equalsIgnoreCase("Monday"))
                            globalVariable.setTempCount(7038);
                        else if (temp[0].equalsIgnoreCase("Tuesday"))
                            globalVariable.setTempCount(8183);
                        else if (temp[0].equalsIgnoreCase("Wednesday"))
                            globalVariable.setTempCount(5885);
                        else if (temp[0].equalsIgnoreCase("Thursday"))
                            globalVariable.setTempCount(8175);
                        else if (temp[0].equalsIgnoreCase("Friday"))
                            globalVariable.setTempCount(3579);
                        else if (temp[0].equalsIgnoreCase("Saturday"))
                            globalVariable.setTempCount(8159);
                        else if (temp[0].equalsIgnoreCase("Sunday"))
                            globalVariable.setTempCount(8127);
                        Toast.makeText(getApplicationContext(),"In continiation phase",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(navigation.this, continous.class);
                        startActivity(intent);
                    } else  {
                        globalVariable.set_day(temp[0]);
                        Intent intent = new Intent(navigation.this, cat2.class);
                        startActivity(intent);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                FragmentManager fm = getSupportFragmentManager();

                InternetCheckDialogFragment iFragment = new InternetCheckDialogFragment();
                // Show DialogFragment
                iFragment.show(fm, "Internet Check");
            } finally {
            }
        }


    }

    class course extends AsyncTask<String, Void, String> {
        private TextView statusField, roleField;
        private TextView t1 = null;
        private Context context;
        private int byGetOrPost = 0;
        StringBuffer sb = null;
        String userid;

        //flag 0 means get and 1 means post.(By default it is get.)
        public course(Context context) {
            this.context = context;


        }

        protected void onPreExecute() {
            pd = new ProgressDialog(navigation.this);
            pd.setTitle("Navigating...");
            pd.setMessage("Please wait....");
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected String doInBackground(String... arg0) {

            try {
                userid = (String) arg0[0];
//userid="SUB00001";
                String link = "http://www.tbtrack.org/mobileJson/course.php?user_id=" + userid;

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

//String temp[]=sb.toString().split(",");

            try {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                globalVariable.set_coursesummary(sb.toString());
                Toast.makeText(getApplicationContext(), sb.toString()
                        , Toast.LENGTH_LONG).show();

                Intent intent = new Intent(navigation.this, coursesummary.class);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                FragmentManager fm = getSupportFragmentManager();

                InternetCheckDialogFragment iFragment = new InternetCheckDialogFragment();
                // Show DialogFragment
                iFragment.show(fm, "Internet Check");
            } finally {
                pd.dismiss();
            }

        }
    }

    class getcontact extends AsyncTask<String, Void, String> {
        private TextView statusField, roleField;
        private TextView t1 = null;
        private Context context;
        private int byGetOrPost = 0;
        StringBuffer sb = null;

        //flag 0 means get and 1 means post.(By default it is get.)
        public getcontact(Context context) {
            this.context = context;


        }

        protected void onPreExecute() {
            pd = new ProgressDialog(navigation.this);
            pd.setTitle("Navigating...");
            pd.setMessage("Please wait....");
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected String doInBackground(String... arg0) {

            try {
                String username = (String) arg0[0];
               String link = "http://tbtrack.org/mobileJson/getcontact.php?user_id=" + username;
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
            try {
                String temp[] = sb.toString().split(",");
                final GlobalClass g1 = (GlobalClass) getApplicationContext();
//            Toast.makeText(getApplicationContext(),"" + temp[0] + temp[1],Toast.LENGTH_LONG).show();
                g1.set_dotname(temp[0]);
                g1.set_dotphone(temp[1]);
                g1.setContactName(temp[2]);
                g1.setContact_contact(temp[3]);

                Intent intent = new Intent(navigation.this, contactprovider.class);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                FragmentManager fm = getSupportFragmentManager();

                InternetCheckDialogFragment iFragment = new InternetCheckDialogFragment();
                // Show DialogFragment
                iFragment.show(fm, "Internet Check");
            } finally {
                pd.dismiss();
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_img);
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        user = globalVariable.get_userid();

        editor.putString("sub_id", user);
        editor.commit();
        ImageView b1 = (ImageView) findViewById(R.id.b1);
        ImageView b2 = (ImageView) findViewById(R.id.b2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new IntakeCount(navigation.this).execute(user);

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(navigation.this, symptoms.class);
                startActivity(intent);
            }
        });
        ImageView b3 = (ImageView) findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new getcontact(navigation.this).execute(user);
            }
        });
        ImageView b4 = (ImageView) findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      new course(navigation.this).execute(user);
                                  }
                              }
        );
    }
}
