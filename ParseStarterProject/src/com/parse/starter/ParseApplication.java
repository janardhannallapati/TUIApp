package com.parse.starter;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

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
		defaultACL.setPublicReadAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);
	}

}
