package com.android.ccny.www.conf;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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
public class DataBaseOpenHelper extends SQLiteOpenHelper {

	private static final String DBNAME = "ccny.db";

	private static final int VERSION = 1;

	public final static String TABLENAME = "favorite";

	/**
	 * @param context
	 */
	public DataBaseOpenHelper(Context context) {

		super(context, DBNAME, null, VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		String sql = "CREATE TABLE favorite(favoriteId INTEGER PRIMARY KEY " +

		"AUTOINCREMENT,name VARCHAR(50))";

		db.execSQL(sql);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		db.execSQL("DROP TABLE IF EXITS favorite");

		onCreate(db);

	}

}