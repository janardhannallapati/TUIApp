package com.inoss.tuiapp;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ParseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
        //TODO remove hardcoding

        Parse.initialize(this, "GfHv7S0Fmuj4SrgJAasJrM13TwZBWBIKM4qr1qeJ", "gBvZhOKXkDxfQkl0fyFuelHwhUXcRIR3v102CHh4");

		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
	    
		// If you would like all objects to be private by default, remove this line.
		//defaultACL.setPublicReadAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);

        ParseObject object = new ParseObject("TestObject");
        object.put("name","sharathkumar");
        object.put("job","actor");
        object.saveInBackground();
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("TestObject");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                if (e != null) {
                    Log.d("ParseApplication", "Exception in retrieving:" + e);
                } else {
                    Toast.makeText(ParseApplication.this, String.format("Done %d",parseObjects.size()), Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}
