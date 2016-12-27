package idss.bank.demo;

import android.app.Activity;
import android.util.Log ; 
import android.view.View ; 
import android.widget.Button ; 
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public  class MailSenderActivity  extends  Activity  { 

     /** Called when the activity is first created. */ 
    @Override 
     public  void onCreate(Bundle savedInstanceState )  { 
         super .onCreate (savedInstanceState ) ; 
        setContentView (R . layout .mail ) ; 
        
        final TextView tv1 = (TextView) findViewById(R.id.toText);
        final TextView tv2 = (TextView) findViewById(R.id.subText);
        final TextView tv3 = (TextView) findViewById(R.id.contentText);

         final  Button  send  =  ( Button )  this .findViewById (R.id.button1) ; 
         send .setOnClickListener ( new  View.OnClickListener ( )  { 

             public  void onClick ( View v )  { 
                 // TODO Auto-generated method stub 


                 try  {  
                    GMailSender sender  =  new GMailSender ( "urusername","urpassword");
                    		
                    sender .sendMail ( tv2.getText().toString(),  
                             tv3.getText().toString() ,  
                             tv1.getText().toString() ,  
                             tv1.getText().toString() ) ; 
                    
                    System.out.println("=========MAIL SEND SUCCESSFULLY=========");
                    finish();
                    Toast
					.makeText(MailSenderActivity.this, "Mail sent successfully....",
										4000)
					.show();
                    
                    
                    
                 }  catch  ( Exception e )  {  
                     Log .e ( "SendMail" , e . getMessage ( ) , e ) ;  
                 }  

             } 
         } ) ; 

     } 
}



