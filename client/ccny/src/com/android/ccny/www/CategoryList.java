package com.android.ccny.www;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

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

import com.android.ccny.www.conf.Config;
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
public class CategoryList extends ListActivity {

	private String METHOD_NAME = "findAllCategory";
	private List<Map<String, Object>> mData;

	/** Called when the activity is first created. */
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
	protected List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			SoapObject request = new SoapObject(Config.get_NAMESPACE(), METHOD_NAME);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(Config.get_URL());

			androidHttpTransport.call(Config.get_SOAP_ACTION(METHOD_NAME), envelope);

			SoapObject result = (SoapObject) envelope.bodyIn;

			for (int i = 0; i < result.getPropertyCount(); i++) {
				SoapObject soap = (SoapObject) result.getProperty(i);
				map = new HashMap<String, Object>();
				map.put("Id", soap.getProperty(0));
				map.put("name", soap.getProperty(1));
				map.put("img", R.drawable.i1);
				list.add(map);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		setTitle(" " + mData.get(position).get("name").toString());
		String strId = mData.get(position).get("Id").toString();
		Intent intent = new Intent();
		intent.setClass(CategoryList.this, BusinessList.class);
		Bundle bundle = new Bundle();
		bundle.putString("Id", strId);
		intent.putExtras(bundle);
		startActivity(intent);
	}

	/**
	 * @author qingjiezhao
	 *
	 */
	public final class ViewHolder {
		public ImageView img;
		public TextView txtId;
		public TextView txtName;
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

				convertView = mInflater.inflate(R.layout.category_list, null);
				holder.img = (ImageView) convertView.findViewById(R.id.img);
				holder.txtId = (TextView) convertView.findViewById(R.id.categoryId);
				holder.txtName = (TextView) convertView.findViewById(R.id.categoryId);

				convertView.setTag(holder);
			} else {

				holder = (ViewHolder) convertView.getTag();
			}

			holder.img.setBackgroundResource((Integer) mData.get(position).get("img"));
			holder.txtId.setText(mData.get(position).get("Id").toString());
			holder.txtName.setText(mData.get(position).get("name").toString());

			return convertView;
		}

	}

}