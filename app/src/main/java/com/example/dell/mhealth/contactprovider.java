package com.example.dell.mhealth;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.net.Uri;
import android.content.Intent;
/**
 * Created by DELL on 04-03-2016.
 */
public class contactprovider extends MainActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactprovider);
        String dot_name;
        final String dot_ph;
        String doc_ph;
        String sts_ph;
        String con_name;
        final String con__contact;
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        dot_name=globalVariable.get_dotname();
       dot_ph=globalVariable.get_dotphone();
        con_name=globalVariable.getContactName();
con__contact=globalVariable.getContact_contact();
        TextView t1=(TextView)findViewById(R.id.t1);
        TextView t2=(TextView)findViewById(R.id.t2);
        TextView t3=(TextView)findViewById(R.id.t3);
        TextView t4=(TextView)findViewById(R.id.t4);
      //  TextView t5=(TextView)findViewById(R.id.t5);
      //  TextView t6=(TextView)findViewById(R.id.t6);
        Button b1=(Button) findViewById(R.id.b1);
        Button b2=(Button) findViewById(R.id.b2);
        Button b3=(Button) findViewById(R.id.b3);
        Button b4=(Button) findViewById(R.id.b4);
      //  Button b5=(Button) findViewById(R.id.b5);
      //  Button b6=(Button) findViewById(R.id.b6);
        t1.setText(t1.getText() + dot_name);
        t2.setText(t2.getText() + dot_ph);
        t3.setText(t3.getText() + con_name);
        t4.setText(t4.getText() + con__contact);
   b2.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent sendIntent = new Intent(Intent.ACTION_VIEW);
           sendIntent.setData(Uri.parse("sms:+91" + dot_ph));
           sendIntent.putExtra("sms_body", "Hi Please help me ...");
           startActivity(sendIntent);
       }
   });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+91"+dot_ph));
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+91"+con__contact));
                startActivity(intent);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {

           Intent sendIntent = new Intent(Intent.ACTION_VIEW);
           sendIntent.setData(Uri.parse("sms:+91"+con__contact));
           sendIntent.putExtra("sms_body", "Hi Please help me ...");
           startActivity(sendIntent);
       }
   });


/*    b6.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.setData(Uri.parse("sms:"));
            sendIntent.putExtra("sms_body", "Hi Please help me ...");
            startActivity(sendIntent);
        }
    });*/


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(contactprovider.this, navigation.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    }
