package com.android.ccny.www;

import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.ccny.www.dao.FavoriteService;
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
public class FavoriteList extends ListActivity {

	private List<Favorite> mData;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FavoriteService favoriteService = new FavoriteService(getBaseContext());
			mData = favoriteService.getData();
			MyAdapter adapter = new MyAdapter(this);
			setListAdapter(adapter);

}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		setTitle(" " + mData.get(position).getName());
		String strBusinessName = (String) mData.get(position).getName();
		Intent intent = new Intent();
		intent.setClass(FavoriteList.this, FavoriteDetail.class);
		Bundle bundle = new Bundle();
		bundle.putString("Name", strBusinessName);
		intent.putExtras(bundle);
		startActivity(intent);
		finish();
	}

	/**
	 * @author qingjiezhao
	 *
	 */
	public final class ViewHolder {
		public ImageView img;
		public TextView txtName;
	}

	public class MyAdapter extends BaseAdapter {

		private LayoutInflater mInflater;

		public MyAdapter(Context context) {
			this.mInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {

			return mData.size();
		}

		@Override
		public Object getItem(int arg0) {
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder = null;
			if (convertView == null) {

				holder = new ViewHolder();

				convertView = mInflater.inflate(R.layout.favorite_list, null);
				holder.img = (ImageView) convertView.findViewById(R.id.img);

				holder.txtName = (TextView) convertView.findViewById(R.id.favorite_name);

				convertView.setTag(holder);
			} else {

				holder = (ViewHolder) convertView.getTag();
			}
			// System.out.println("--------------mData.get(position).getFavoriteId(-----"+mData.get(position).getFavoriteId());
			// holder.img.setBackgroundResource(mData.get(position).getFavoriteId());
			holder.txtName.setText(mData.get(position).getName());

			return convertView;
		}

	}

}