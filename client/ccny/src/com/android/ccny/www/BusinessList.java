package com.android.ccny.www;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.android.ccny.www.conf.Config;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
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
public class BusinessList extends ListActivity {
	private List<Map<String, Object>> mData;
	private String METHOD_NAME = "findBusinessByCategoryId";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mData = getData();
		MyAdapter adapter = new MyAdapter(this);
		setListAdapter(adapter);	
			
	}

	/**
	 * @return
	 */
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			SoapObject request = new SoapObject(Config.get_NAMESPACE(), METHOD_NAME);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

			Bundle bundle = this.getIntent().getExtras();
			String Id = bundle.getString("Id");
			int cat_Id = Integer.parseInt(Id);

			request.addProperty("Cat_Id", cat_Id);
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(Config.get_URL());

			androidHttpTransport.call(Config.get_SOAP_ACTION(METHOD_NAME), envelope);
			SoapObject result = (SoapObject) envelope.bodyIn;
			for (int i = 0; i < result.getPropertyCount(); i++) {
				SoapObject soap = (SoapObject) result.getProperty(i);
				map = new HashMap<String, Object>();
				map.put("title", soap.getProperty(15).toString());
				map.put("info", soap.getProperty(3).toString());
				map.put("img", R.drawable.i1);
				list.add(map);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		
	}

	/* (non-Javadoc)
	 * @see android.app.ListActivity#onListItemClick(android.widget.ListView, android.view.View, int, long)
	 */
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		setTitle(" " + mData.get(position).get("title"));
		String strBusinessName = (String) mData.get(position).get("title");
		Intent intent = new Intent();
		intent.setClass(BusinessList.this, BusinessDetail.class);
		Bundle bundle = new Bundle();
		bundle.putString("Name", strBusinessName);
		intent.putExtras(bundle);
		startActivity(intent);

	}

	/**
	 * @author qingjiezhao
	 *
	 */
	public final class ViewHolder {
		public ImageView img;
		public TextView title;
		public TextView info;
	}

	/**
	 * @author qingjiezhao
	 *
	 */
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

				convertView = mInflater.inflate(R.layout.business_list, null);
				holder.img = (ImageView) convertView.findViewById(R.id.img);
				holder.title = (TextView) convertView.findViewById(R.id.businessName);
				holder.info = (TextView) convertView.findViewById(R.id.businessId);

				convertView.setTag(holder);

			} else {

				holder = (ViewHolder) convertView.getTag();
			}
			holder.img.setBackgroundResource((Integer) mData.get(position).get("img"));
			if(mData.get(position).get("title").toString().contains("anyType{}")){
				holder.title.setText("NULL");
			}else{
				holder.title.setText(mData.get(position).get("title").toString());
			}
			if(mData.get(position).get("info").toString().contains("anyType{}")){
				holder.info.setText("NULL");
			}else{
				holder.info.setText(mData.get(position).get("info").toString());
			}
			
			

			return convertView;
		}

	}

}