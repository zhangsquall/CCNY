package com.android.ccny.www;

import com.android.ccny.www.dao.FavoriteService;

import android.app.Activity;
import android.app.AlertDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
//***********************************************************************
//* [CCNY]
//* This application was developed by 
//* [Qingjie Zhao][E-mail:zhaoqingjie@gmail.com]
//* [Christopher Sansone][E-mail:chrissansone@hotmail.com]
//* [Casey Trumble][cE-mail:atrumbl@syr.edu]
//* [Jimmy Bell][E-mail:jnbelliv@syr.edu]
//* [SooHyun Jeong][E-mail:sojeon@syr.edu]
//* for New York's Creative Core
//* as part of the final project for the Mobile Application Development
//* course IST 400/600 - Fall 2010 at the school of information Studies
//* of Syracuse University
//***********************************************************************
/**
 * @author qingjiezhao
 *
 */
public class CCNY extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Set up click listeners for all the buttons
		View businessesButton = findViewById(R.id.businesses_button);

		businessesButton.setOnClickListener(this);

		View favoritesButton = findViewById(R.id.favorites_button);
		favoritesButton.setOnClickListener(this);

		View add_businessButton = findViewById(R.id.add_button);
		add_businessButton.setOnClickListener(this);

		View about_businessButton = findViewById(R.id.about_button);
		about_businessButton.setOnClickListener(this);
	}

	
	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	public void onClick(View v) {

		Intent i;

		switch (v.getId()) {
		case R.id.businesses_button:

			i = new Intent(this, CategoryList.class);
			startActivity(i);

			break;

		case R.id.favorites_button:
			FavoriteService favoriteService = new FavoriteService(getBaseContext());
			if (favoriteService.getData().size() == 0) {
				new AlertDialog.Builder(this).setTitle("CCNY").setMessage("You do not have any favorite things.")
						.setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
							}
						}).show();
			} else {
				i = new Intent(this, FavoriteList.class);
				startActivity(i);
			}

			break;
		case R.id.add_button:
			i = new Intent(this, AddBusinessNotice.class);
			startActivity(i);
			break;
		case R.id.about_button:
			i = new Intent(this, About.class);
			startActivity(i);
			break;

		}
	}

	/**
	 * @return
	 */
	public boolean isConnectInternet() {
		ConnectivityManager conManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = conManager.getActiveNetworkInfo();
		if (networkInfo != null) {
			return networkInfo.isAvailable();
		}
		return false;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		finish();
		android.os.Process.killProcess(android.os.Process.myPid());
		System.exit(0);
	}

	// ActivityManager activityMgr= (ActivityManager)
	// this.getSystemService(ACTIVITY_SERVICE );

	// activityMgr.restartPackage(getPackageName());
}
