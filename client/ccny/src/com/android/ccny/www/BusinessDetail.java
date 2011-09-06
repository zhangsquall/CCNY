package com.android.ccny.www;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.ccny.www.conf.Config;
import com.android.ccny.www.dao.FavoriteService;
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
public class BusinessDetail extends ListActivity {
	protected final static int MENU_SAVE = Menu.FIRST + 3;
	protected final static int MENU_MAP = Menu.FIRST + 4;
	String strClass;
	private String METHOD_NAME = "findBusinessByName";

	private String strBusinessName = null;
	private SoapObject result = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle bundle = this.getIntent().getExtras();
		strBusinessName = bundle.getString("Name");
		result = getObj(strBusinessName);

		MyAdapter adapter = new MyAdapter(this);
		setListAdapter(adapter);

	}

	/**
	 * @param strBusinessName
	 * @return
	 */
	private SoapObject getObj(String strBusinessName) {
		try {
			SoapObject request = new SoapObject(Config.get_NAMESPACE(), METHOD_NAME);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

			request.addProperty("Name", strBusinessName);
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(Config.get_URL());
			androidHttpTransport.call(Config.get_SOAP_ACTION(METHOD_NAME), envelope);
			result = (SoapObject) envelope.getResponse();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * @author qingjiezhao
	 *
	 */
	public final class ViewHolder {
		public TextView txtCompanyName;
		public TextView txtAddress;
		public TextView txtApt;
		public TextView txtCity;
		public TextView txtState;
		public TextView txtZip;
		public TextView txtPhone;
		public TextView txtCoupon;
		public TextView txtHoursOfOperation;
		public TextView txtDeliver;
		public TextView txtMobile;
		public TextView txtFax;
		public TextView txtPaymentAccepted;
		public TextView txtWebSite;
		public TextView txtEmail;
		public TextView txtCountOfCertification;

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
			return 1;
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

				convertView = mInflater.inflate(R.layout.business_detail, null);

				holder.txtCompanyName = (TextView) convertView.findViewById(R.id.nameV);
				holder.txtAddress = (TextView) convertView.findViewById(R.id.addressV);
				holder.txtApt = (TextView) convertView.findViewById(R.id.aptV);
				holder.txtCity = (TextView) convertView.findViewById(R.id.cityV);
				holder.txtState = (TextView) convertView.findViewById(R.id.stateV);
				holder.txtZip = (TextView) convertView.findViewById(R.id.zipV);
				holder.txtPhone = (TextView) convertView.findViewById(R.id.phoneV);
				holder.txtCoupon = (TextView) convertView.findViewById(R.id.couponV);
				holder.txtHoursOfOperation = (TextView) convertView.findViewById(R.id.hoursOfOperationV);
				holder.txtDeliver = (TextView) convertView.findViewById(R.id.deliverV);
				holder.txtMobile = (TextView) convertView.findViewById(R.id.mobileV);
				holder.txtFax = (TextView) convertView.findViewById(R.id.faxV);
				holder.txtPaymentAccepted = (TextView) convertView.findViewById(R.id.paymentAcceptedV);
				holder.txtWebSite = (TextView) convertView.findViewById(R.id.websiteV);
				holder.txtEmail = (TextView) convertView.findViewById(R.id.emailV);
				holder.txtCountOfCertification = (TextView) convertView.findViewById(R.id.countOfCertificationV);

				convertView.setTag(holder);

			} else {

				holder = (ViewHolder) convertView.getTag();
			}

			if (result.getProperty("name").toString().contains("anyType{}")) {
				holder.txtCompanyName.setText(" " + "NULL");
			} else {
				holder.txtCompanyName.setText(" " + result.getProperty("name").toString());
			}
			if (result.getProperty("address").toString().contains("anyType{}")) {
				holder.txtAddress.setText(" " + "NULL");
			} else {
				holder.txtAddress.setText(" " + result.getProperty("address").toString());
			}
			if (result.getProperty("apt").toString().contains("anyType{}")) {
				holder.txtApt.setText(" " + "NULL");
			} else {
				holder.txtApt.setText(" " + result.getProperty("apt").toString());
			}
			if (result.getProperty("city").toString().contains("anyType{}")) {
				holder.txtCity.setText(" " + "NULL");
			} else {
				holder.txtCity.setText(" " + result.getProperty("city").toString());
			}
			if (result.getProperty("state").toString().contains("anyType{}")) {
				holder.txtState.setText(" " + "NULL");
			} else {
				holder.txtState.setText(" " + result.getProperty("state").toString());
			}
			if (result.getProperty("zip").toString().contains("anyType{}")) {
				holder.txtZip.setText(" " + "NULL");
			} else {
				holder.txtZip.setText(" " + result.getProperty("zip").toString());
			}
			if (result.getProperty("phone").toString().contains("anyType{}")) {
				holder.txtPhone.setText(" " + "NULL");
			} else {
				String strPhoneNumber = result.getProperty("phone").toString();
				String formatPhoneNumber = strPhoneNumber.replace("-", "");
				SpannableString ss = new SpannableString(formatPhoneNumber);
				ss.setSpan(new StyleSpan(Typeface.BOLD), 0, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				ss.setSpan(new URLSpan("tel:" + formatPhoneNumber), 0, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				holder.txtPhone.setText(ss);
				holder.txtPhone.setMovementMethod(LinkMovementMethod.getInstance());
			}
			if (result.getProperty("coupon").toString().contains("anyType{}")) {
				holder.txtCoupon.setText(" " + "NULL");
			} else {
				holder.txtCoupon.setText(" " + result.getProperty("coupon").toString());
			}
			if (result.getProperty("hoursOfOperation").toString().contains("anyType{}")) {
				holder.txtHoursOfOperation.setText(" " + "NULL");
			} else {
				holder.txtHoursOfOperation.setText(" " + result.getProperty("hoursOfOperation").toString());
			}
			if (result.getProperty("deliver").toString().contains("anyType{}")) {
				holder.txtDeliver.setText(" " + "NULL");
			} else {
				holder.txtDeliver.setText(" " + result.getProperty("deliver").toString());
			}
			if (result.getProperty("mobile").toString().contains("anyType{}")) {
				holder.txtMobile.setText(" " + "NULL");
			} else {
				holder.txtMobile.setText(" " + result.getProperty("mobile").toString());
			}
			if (result.getProperty("fax").toString().contains("anyType{}")) {
				holder.txtFax.setText(" " + "NULL");
			} else {
				holder.txtFax.setText(" " + result.getProperty("fax").toString());
			}
			if (result.getProperty("paymentAccepted").toString().contains("anyType{}")) {
				holder.txtPaymentAccepted.setText(" " + "NULL");
			} else {
				holder.txtPaymentAccepted.setText(" " + result.getProperty("paymentAccepted").toString());
			}
			if (result.getProperty("website").toString().contains("anyType{}")) {
				holder.txtWebSite.setText(" " + "NULL");

			} else {
				String link = result.getProperty("website").toString();
				holder.txtWebSite.setText(Html.fromHtml("<a href=\"http://" + link + "\">" + link + "</a> "));
				holder.txtWebSite.setMovementMethod(LinkMovementMethod.getInstance());
			}
			if (result.getProperty("email").toString().contains("anyType{}")) {
				holder.txtEmail.setText(" " + "NULL");
			} else {
				holder.txtEmail.setText(" " + result.getProperty("email").toString());
			}
			if (result.getProperty("countOfCertification").toString().contains("anyType{}")) {
				holder.txtCountOfCertification.setText(" " + "NULL");
			} else {
				holder.txtCountOfCertification.setText(" " + result.getProperty("countOfCertification").toString());
			}

			return convertView;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(Menu.NONE, MENU_SAVE, 0, R.string.SAVE);
		menu.add(Menu.NONE, MENU_MAP, 0, R.string.MAP);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case MENU_SAVE:
			operation("save");
			break;
		case MENU_MAP:
			operation("map");
			break;
		default:
			break;
		}
		return true;
	}

	/**
	 * @param cmd
	 */
	private void operation(String cmd) {
		if (cmd == "save") {

			FavoriteService favoriteService = new FavoriteService(getBaseContext());
			if (favoriteService.isExist(result.getProperty("name").toString())) {
				new AlertDialog.Builder(this).setTitle("CCNY").setMessage("The infomation has been saved before.")
						.setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
							}
						}).show();

			} else {
				new AlertDialog.Builder(this).setTitle("CCNY").setMessage("The information is saved Successfully.")
						.setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
							}
						}).show();
				favoriteService.save(result.getProperty("name").toString());
			}

		}
		if (cmd == "map") {
			LocationManager locationManager;
			String context = Context.LOCATION_SERVICE;
			locationManager = (LocationManager) getSystemService(context);

			Criteria criteria = new Criteria();
			criteria.setAccuracy(Criteria.ACCURACY_FINE);
			criteria.setAltitudeRequired(false);
			criteria.setBearingRequired(false);
			criteria.setCostAllowed(true);
			criteria.setPowerRequirement(Criteria.POWER_LOW);
			String provider = locationManager.getBestProvider(criteria, true);

			Location location = locationManager.getLastKnownLocation(provider);
			String source = updateWithNewLocation(location);
			locationManager.requestLocationUpdates(provider, 2000, 10, locationListener);
			String destination = result.getProperty("address").toString();
			launchMap(source, destination);
		}
	}

	/**
	 * @param source
	 * @param destination
	 */
	private void launchMap(String source, String destination) {
		String dest = destination;
		try {
			dest = URLEncoder.encode(destination, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Intent iNavigate = new Intent("android.intent.action.VIEW");
		iNavigate.setData(Uri.parse("http://maps.google.com/maps?myl=saddr" + "&saddr=" + source + "&daddr=" + dest
				+ "&dirflg=b&nav=1"));
		iNavigate.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		iNavigate.setClassName("com.google.android.apps.maps",
				"com.google.android.maps.driveabout.app.NavigationActivity");
		iNavigate.putExtra("CHIME_BEFORE_SPEECH", true);
		startActivity(iNavigate);
	}

	/**
	 * @param location
	 * @return
	 */
	private String updateWithNewLocation(Location location) {
		String latLongString = null;
		// TextView myLocationText;
		String addressString = "No address found";

		if (location != null) {

			double latitude = location.getLatitude();
			double longitude = location.getLongitude();

			Geocoder gc = new Geocoder(this, Locale.getDefault());
			try {
				List<Address> addresses = gc.getFromLocation(latitude, longitude, 1);
				StringBuilder sb = new StringBuilder();
				if (addresses.size() > 0) {
					Address address = addresses.get(0);

					for (int i = 0; i < address.getMaxAddressLineIndex(); i++)
						sb.append(address.getAddressLine(i)).append("\n");

					sb.append(address.getLocality()).append("\n");
					sb.append(address.getPostalCode()).append("\n");
					sb.append(address.getCountryName());
				}
				addressString = sb.toString();
			} catch (IOException e) {
			}
		} else {
			latLongString = "No location found";
		}

		return addressString;
	}

	private final LocationListener locationListener = new LocationListener() {
		public void onLocationChanged(Location location) {
			updateWithNewLocation(location);
		}

		public void onProviderDisabled(String provider) {
			updateWithNewLocation(null);
		}

		public void onProviderEnabled(String provider) {
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
		}
	};

}