package com.example.dell.mhealth;

import android.os.Bundle;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by DELL on 11-03-2016.
 */
public class coursesummary extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coursesummary);
        TextView t1=(TextView)findViewById(R.id.t1);
        TextView t2=(TextView)findViewById(R.id.t2);
        ProgressBar progress=(ProgressBar) findViewById(R.id.p1);
        ProgressBar progress2=(ProgressBar) findViewById(R.id.p2);
        ProgressBar progress3=(ProgressBar) findViewById(R.id.p3);
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

       String coursesummary=globalVariable.get_coursesummary();
      //  Toast.makeText(getApplicationContext(), " " + count,Toast.LENGTH_LONG).show();
        String temp[]=coursesummary.toString().split(",");

        Log.v("med_check.php",coursesummary);
        int day=Integer.parseInt(temp[3].toString());

        if(day  <=56 )
        {
progress.setMax(56);
            progress.setProgress(Integer.parseInt(temp[1].toString()));

        }
        else if(day > 56 && temp[4].equals("1") && day<=84)

        {

            progress.setMax(56);
            progress.setProgress(56);
            progress2.setMax(28);
            progress2.setProgress(Integer.parseInt(temp[1].toString()));
        }
        else 
        {
            progress.setMax(56);
            progress.setProgress(56);
            progress2.setMax(28);
            progress2.setProgress(28);

            progress3.setMax(112);
            progress3.setProgress(Integer.parseInt(temp[1].toString()));
        }
        t1.setText(t1.getText() + " "+temp[0]);
        t2.setText(t2.getText()+ " " + temp[1]);
//Toast.makeText(getApplicationContext(),coursesummary,Toast.LENGTH_LONG).show();

    }

}
