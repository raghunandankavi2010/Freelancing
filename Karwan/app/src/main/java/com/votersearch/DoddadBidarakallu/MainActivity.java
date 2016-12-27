package com.votersearch.DoddadBidarakallu;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private DataBaseHelper db_helper;
    private EditText cn, cc, pn, mrp, price, ccc, c;
    private Button submit, reset;
    private StringBuffer Sex;
    private AlertDialog.Builder builder;
    private SQLiteDatabase db;
    public static List<Voter> voter;
    private ProgressDialog dialog;
    private String name_search = "", guardian_search = "", part_search = "", address_search = "", area_search = "", acno_search = "";
    int sl_search = 0;
    private Context context;
    private ImageView logout, read;
    //private TextView search_count;
    private SharedPreferences count_pref;
    private SharedPreferences.Editor count_pref_editor;
    private RadioButton male, female, all;
    RadioGroup radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        cn = (EditText) findViewById(R.id.nameid);
        cc = (EditText) findViewById(R.id.fatherid);
        pn = (EditText) findViewById(R.id.guardianid);
        mrp = (EditText) findViewById(R.id.partnoid);
        price = (EditText) findViewById(R.id.slnoid);
        ccc = (EditText) findViewById(R.id.age1);
        c = (EditText) findViewById(R.id.housenoid);

        submit = (Button) findViewById(R.id.submitid);
        reset = (Button) findViewById(R.id.resetid);
        //radio=(RadioGroup)findViewById(R.id.radio);radio.check(R.id.radio_all);
        logout = (ImageView) findViewById(R.id.logoutid);
        //search_count=(TextView)findViewById(R.id.countsearchid);
        //read=(ImageView)findViewById(R.id.readid);
        //male=(RadioButton)findViewById(R.id.radio_male);female=(RadioButton)findViewById(R.id.radio_fmale);all=(RadioButton)findViewById(R.id.radio_all);
        //if(!male.hasFocus()&&!female.hasFocus()){all.setFocusable(true);}
        builder = new AlertDialog.Builder(MainActivity.this);
        db_helper = new DataBaseHelper(getApplicationContext());

        count_pref = getSharedPreferences("count_pref", MODE_WORLD_READABLE);
        count_pref_editor = count_pref.edit();

		/*try {
                              db_helper.createDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        logout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(MainActivity.this, LoginScreen.class));

            }
        });

		/*read.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,HowToUse.class));

			}
		});*/
	/*	area.setOnKeyListener(new OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// If the event is a key-down event on the "enter" button
				if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
						(keyCode == KeyEvent.KEYCODE_ENTER)) {
					// Perform action on key press
					// Toast.makeText(HelloFormStuff.this, edittext.getText(), Toast.LENGTH_SHORT).show();
					return true;
				}
				return false;
			}
		});*/
        submit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog = ProgressDialog.show(context, null, "Please wait...",
                        true);
                if (!TextUtils.isEmpty(cn.getText().toString()) || !TextUtils.isEmpty(cc.getText().toString())
                        || !TextUtils.isEmpty(pn.getText().toString()) || !TextUtils.isEmpty(mrp.getText().toString())
                        || !TextUtils.isEmpty(price.getText().toString()) || !TextUtils.isEmpty(ccc.getText().toString())
                        || !TextUtils.isEmpty(c.getText().toString()) || !TextUtils.isEmpty(cn.getText().toString())

                        ) {


                    //if(!sl.getText().toString().equals("")){


                    //dialog=ProgressDialog.show(MainActivity.this,null, "Please wait...");
                    db = db_helper.getWritableDatabase();
                    voter = new ArrayList<Voter>();

                    final String company_name = cn.getText().toString();
                    final String company_code = cc.getText().toString();

                    final String product_name = pn.getText().toString();
                    final String MRP = mrp.getText().toString();
                    final String p = price.getText().toString();
                    final String content_code = ccc.getText().toString();
                    final String content = c.getText().toString();
                    final String cn_search = cn.getText().toString();


							/*String query="SELECT  * FROM VoterSearch WHERE name LIKE (case when '"+name_search+"'!='' then '%"+name_search+"%' else name end) and polladdress LIKE (case when '"+address_search+"'!='' then '%"+address_search+"%' else polladdress end) and cnname LIKE (case when '"+guardian_search+"'!='' then '%"+guardian_search+"%' else cnname end) and acname LIKE (case when '"+area_search+"'!='' then '%"+area_search+"%' else acname end)"
							+" and sex = (case when '"+Sex+"'!='' then '"+Sex+"' else sex end) and slno = (case when '"+sl_search+"'!='' then '"+sl_search+"' else slno end) and acno = (case when '"+acno_search+"'!='' then '"+acno_search+"' else acno end) and partno = (case when '"+part_search+"'!='' then '"+part_search+"' else partno end)";
							 */
                    Thread back = new Thread() {
                        public void run() {
                            //String testquery = "SELECT  * FROM MyPharma WHERE  Name LIKE '%crocin%'";
                            String query = "SELECT  * FROM MyPharma WHERE Compname LIKE (case when '" + company_name + "'!='' then '%" + company_name + "%' else Compname end) and Code LIKE (case when '" + company_code + "'!='' then '%" + company_code + "%' else Code end) and Name LIKE (case when '" + product_name + "'!='' then '%" + product_name + "%' else Name end) and Pack LIKE (case when '" + price + "'!='' then '%" + price + "%' else Pack end) and Mrp LIKE (case when '" + mrp + "'!='' then '%" + mrp + "%' else Mrp end)"
                                    + " and Contentcode LIKE (case when '" + content_code + "'!='' then '%" + content_code + "%' else Contentcode end)" + " and Content LIKE (case when '" + content + "'!='' then '%" + content + "%' else Content end);";*/
                            //""+" and sex = (case when '"+Sex+"'!='' then '"+Sex+"' else sex end) and slno = (case when '"+sl_search+"'!='' then '"+sl_search+"' else slno end) and acno = (case when '"+acno_search+"'!='' then '"+acno_search+"' else acno end) and partno = (case when '"+part_search+"'!='' then '"+part_search+"' else partno end)"
                            //+" and houseno LIKE (case when '"+house_search+"'!='' then '%"+house_search+"%' else houseno end)"+" and age = (case when '"+age_search+"'!='' then '"+age_search+"' else age end)";

                             //Log.i("query is",""+query);
                            Cursor cursor = db.rawQuery(query, null);

                            if (cursor.moveToFirst()) {

                                while (!cursor.isAfterLast()) {
                                    Voter item = cursorToShoppingItem(cursor);
                                    voter.add(item);
                                    cursor.moveToNext();
                                }
                                // Make sure to close the cursor
                                cursor.close();

                                db_helper.close();
                                handle.sendEmptyMessage(0);
                            } else {
                                Log.i("Something wrong","Check Query!");
                                dialog.dismiss();
                                // Toast.makeText(MainActivity.this,"Wrong Query",Toast.LENGTH_SHORT).show();
                            }
                        }//end of run
                    };
                    back.start();


                } else {
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }
                    showDialog("Please enter any field");
                }

            }
        });


        reset.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                cn.setText("");
                pn.setText("");
                cc.setText("");
                price.setText("");
                mrp.setText("");
                ccc.setText("");
                c.setText("");

            }
        });
    }

    @SuppressLint("HandlerLeak")
    Handler handle = new Handler() {
        public void handleMessage(Message msg) {
            int c = count_pref.getInt("count", 0);
            c++;
            count_pref_editor.putInt("count", c);
            count_pref_editor.commit();

            if (voter.size() > 0) {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
                Intent intent = new Intent(MainActivity.this, IntermideateListScreen.class);
                startActivity(intent);
            } else {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
                Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private Voter cursorToShoppingItem(Cursor cursor) {
        Voter item = new Voter();
        //item.setState(cursor.getString(0));

        item.setCompanyname(cursor.getString(0));
        item.setCompanycode(cursor.getString(1));
        item.setProductname(cursor.getString(2));
        item.setMrp(cursor.getString(3));
        item.setPrice(cursor.getString(4));
        item.setContentcode(cursor.getString(5));
        item.setContent(cursor.getString(6));

        return item;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        Sex = new StringBuffer();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_male:
                if (checked)
                    Sex.append("Male");
                // Pirates are the best
                break;
            case R.id.radio_fmale:
                if (checked)
                    Sex.append("Female");
            case R.id.radio_all:
                if (checked)
                    Sex.append("");
                // Ninjas rule
                break;
        }
    }

    public void showDialog(String msg) {
        builder.setTitle("Alert")
                .setMessage(msg)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        dialog.dismiss();
                    }
                })

                .show();
    }

    public void onPause() {
        super.onPause();
        if (dialog != null) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }

    }

    public void onBackPressed() {
        finish();
    }

}
