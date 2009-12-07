package com.geobloc;

import com.geobloc.FormList;
import com.geobloc.activities.StaticFormPrototype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * Main Menu class; used to connect parts of the app in development.
 * 
 * @author Jorge Carballo (jelcaf@gmail.com)
 * @author Dinesh Harjani (goldrunner192287@gmail.com)
 *
 */

public class MainMenu extends Activity {
	
	// For result from Activity
	private static final int LIST_FORM = 0;
	
	// Buttons
	private Button mCreateFormButton;
	private Button mTestButton;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Create Form Button
        mCreateFormButton = (Button) findViewById(R.id.ButtonMainMenu1);
        mCreateFormButton.setText(getString(R.string.ButtonMainMenu1));
        mCreateFormButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                
            	Intent i = new Intent (getApplicationContext(), FormList.class);
                //startActivity(i);
                startActivityForResult(i, LIST_FORM);
                
                //startActivity(new Intent (getApplicationContext(), FormList.class));
            	//startActivityForResult(i, LIST_FORM);
            }
            
 
        });
        
     // Create Test Button
        mTestButton = (Button) findViewById(R.id.ButtonMainMenu2);
        mTestButton.setText(getString(R.string.ButtonMainMenu2));
        mTestButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                
            	Intent i = new Intent (getApplicationContext(), QuestionActivity.class);
                startActivity(i);

            }
        });

    }
    
    //@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	
    	
    	if (requestCode == LIST_FORM) {
        	
        	if(resultCode == RESULT_OK){
        		Bundle extras = data.getExtras();
        		String filename = extras.getString (FormList.FILE_NAME);
        		String filepath = extras.getString (FormList.FILE_PATH);
        		Toast.makeText(getApplicationContext(),
        				getString(R.string.selected_file, filepath),
                        Toast.LENGTH_SHORT).show();
        		//TextView tv = (TextView) this.findViewById(R.id.tvResult);
        		//tv.setText(data.getStringExtra("SCAN_RESULT"));
        	}
        	else {
        		Toast.makeText(getApplicationContext(),
                		"Actividad NO devuelve correctamente",
                        Toast.LENGTH_SHORT).show();
        	}
    	}
    	else {
    		Toast.makeText(getApplicationContext(),
            		"Actividad desconocida",
                    Toast.LENGTH_SHORT).show();	
    	}
    	
        

    }
    
    public void staticFormStartButtonOnClickHandler(View target)
    {
    	// start GeoBlocStaticForm Activity here
    	Intent i = new Intent(this, StaticFormPrototype.class);
    	startActivity(i);
    }
}