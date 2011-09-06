package com.android.ccny.www.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.ccny.www.conf.DataBaseOpenHelper;
import com.android.ccny.www.vo.Favorite;
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
public class FavoriteService {

	private DataBaseOpenHelper dbOpenHelper;

	public FavoriteService(Context context) {

		dbOpenHelper = new DataBaseOpenHelper(context);

	}

	/**
	 * @param ids
	 */
	public void delete(Integer[] ids) {

		if (ids.length > 0) {

			StringBuilder sb = new StringBuilder();

			for (Integer id : ids) {

				sb.append('?').append(',');

			}

			sb.deleteCharAt(sb.length() - 1);

			SQLiteDatabase database = dbOpenHelper.getWritableDatabase();

			database.execSQL("DELETE FROM favorite WHERE favoriteId IN(" + sb + ")", (Object[]) ids);
			database.close();
		}

	}

	/**
	 * @param name
	 * @return
	 */
	public Favorite find(String name) {

		SQLiteDatabase database = dbOpenHelper.getWritableDatabase();

		Cursor cursor = database.rawQuery("SELECT * FROM favorite WHERE name=?", new String[] { name });

		if (cursor.moveToNext()) {

			return new Favorite(cursor.getInt(0), cursor.getString(1));

		}

		database.close();
		return null;

	}

	/**
	 * @param name
	 * @return
	 */
	public Favorite delete(String name) {
		SQLiteDatabase database = dbOpenHelper.getWritableDatabase();
		database.execSQL("DELETE FROM favorite WHERE name ='" + name + "'");
		database.close();
		return null;
	}

	/**
	 * @param name
	 * @return
	 */
	public boolean isExist(String name) {
		boolean bool = false;
		SQLiteDatabase database = dbOpenHelper.getWritableDatabase();
		Cursor cursor = database.rawQuery("SELECT * FROM favorite WHERE name=?", new String[] { name });

		while (cursor.moveToNext()) {
			if (cursor.getString(1) == name || cursor.getString(1).equals(name)) {
				bool = true;
			}else{
				bool = false;
			}
		}
		database.close();
		return bool;
	}

	/**
	 * @return
	 */
	public long getcount() {

		SQLiteDatabase database = dbOpenHelper.getWritableDatabase();

		Cursor cursor = database.rawQuery("SELECT COUNT(*) FROM favorite ", null);

		if (cursor.moveToNext()) {

			return cursor.getLong(0);

		}
		database.close();
		return 0;

	}

	/**
	 * @return
	 */
	public List<Favorite> getData() {
		List<Favorite> list = new ArrayList<Favorite>();
		SQLiteDatabase database = dbOpenHelper.getWritableDatabase();
		Cursor cursor = database.query("favorite", null, null, null, null, null, "name");
		while (cursor.moveToNext()) {

			list.add(new Favorite(cursor.getInt(0), cursor.getString(1)));

		}
		database.close();
		return list;

	}

	/**
	 * @param name
	 */
	public void save(String name) {

		SQLiteDatabase database = dbOpenHelper.getWritableDatabase();
		database.execSQL("INSERT INTO favorite (name) values(?)", new Object[] { name });
		database.close();
	}

	/**
	 * @param favorite
	 */
	public void update(Favorite favorite) {

		SQLiteDatabase database = dbOpenHelper.getWritableDatabase();

		database.execSQL("UPDATE favorite SET name=? WHERE favoriteId=?",

		new Object[] { favorite.getName(), favorite.getFavoriteId() });
		database.close();
	}

}