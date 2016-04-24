package com.hamzahrmalik.handover.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText urlInput, textInput;

	// Constants
	final String URL = "**URL**=";
	final String CLIP = "**CLP**=";
	final String OPEN = "**OPN**=";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Init views
		urlInput = (EditText) findViewById(R.id.url_input);
		textInput = (EditText) findViewById(R.id.text_input);
	}

	// Called when send url button is pressed
	public void sendURL(View v) {
		send(URL, urlInput.getText().toString());
	}

	// Called when send text button is pressed
	public void sendClip(View v) {
		send(CLIP, textInput.getText().toString());
	}

	/**
	 * Sends the data
	 * 
	 * @param tag
	 *            Type of data. Either **URL**= or **CLP**=
	 * @param data
	 *            The data. The URL/ text. Make sure tag corresponds
	 */
	public void send(String tag, String data) {
		// Create Intent
		Intent i = new Intent("com.hamzahrmalik.handover.android.SEND");
		// Put the data using the tag
		i.putExtra(tag, data);
		// Send broadcast
		sendBroadcast(i);
	}
}
