package com.android.ccny.www;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;

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
public class AddBusiness extends Activity {

	protected final static int MENU_SAVE = Menu.FIRST + 3;

	private String METHOD_NAME = "insertBusiness";

	private EditText strFirstName;
	private EditText strLastName;
	private EditText strCompanyName;
	private EditText strStreet;
	private EditText strApt;
	private EditText strCity;
	private EditText strState;
	private EditText strZip;
	private EditText strCounty;
	private EditText strEmail;
	private EditText strPhone;
	private EditText strFax;
	private EditText strMobile;
	private EditText strWebsite;
	private EditText strPayment;
	private EditText strDeliver;
	private EditText strHoursOfOperation;
	private EditText strCoupon;
	private EditText strCountOfCertification;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND, WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
		setContentView(R.layout.add_business);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(Menu.NONE, MENU_SAVE, 0, R.string.SAVE);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case MENU_SAVE:
			operation("save");
			break;
		default:
			break;
		}
		return true;
	}

	private void showMsg(String strMsg) {
		new AlertDialog.Builder(this).setTitle("CCNY").setMessage(strMsg)
				.setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				}).show();
	}

	/**
	 * @param cmd
	 */
	private void operation(String cmd) {
		if (cmd == "save") {

			strFirstName = (EditText) findViewById(R.id.EditFirstName);
			strLastName = (EditText) findViewById(R.id.EditLastName);
			strCompanyName = (EditText) findViewById(R.id.EditCompanyName);
			strStreet = (EditText) findViewById(R.id.EditStreet);
			strApt = (EditText) findViewById(R.id.EditApt);
			strCity = (EditText) findViewById(R.id.EditCity);
			strState = (EditText) findViewById(R.id.EditState);
			strZip = (EditText) findViewById(R.id.EditZip);

			strCounty = (EditText) findViewById(R.id.EditCounty);
			// System.out.println("-----strCounty-----" +
			// strCounty.getText().toString());

			strEmail = (EditText) findViewById(R.id.EditEmail);
			strPhone = (EditText) findViewById(R.id.EditPhone);
			strFax = (EditText) findViewById(R.id.EditFax);
			strMobile = (EditText) findViewById(R.id.EditMobile);
			strWebsite = (EditText) findViewById(R.id.EditWebsite);
			strPayment = (EditText) findViewById(R.id.EditPayment);
			strDeliver = (EditText) findViewById(R.id.EditDeliver);
			strHoursOfOperation = (EditText) findViewById(R.id.EditHoursOfOperation);
			strCoupon = (EditText) findViewById(R.id.EditCoupon);
			strCountOfCertification = (EditText) findViewById(R.id.EditCountOfCertification);

			try {

				SoapObject request = new SoapObject(Config.get_NAMESPACE(), METHOD_NAME);
				SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

				request.addProperty("Cat_Id", "1");
				request.addProperty("Cou_Id", "1");
				request.addProperty("Status", "0");

				if (strFirstName.getText().toString() != null || strFirstName.getText().toString() != "") {
					request.addProperty("FirstName", strFirstName.getText().toString());
				} else {
					request.addProperty("FirstName", "none");
				}
				if (strLastName.getText().toString() != null || strLastName.getText().toString() != "") {
					request.addProperty("LastName", strLastName.getText().toString());
				} else {
					request.addProperty("LastName", "none");
				}
				if (strCompanyName.getText().toString() != null || strCompanyName.getText().toString() != "") {
					request.addProperty("Name", strCompanyName.getText().toString());
				} else {
					//showMsg("The application need 3 information at least,for example:Company Name,Address and Phone Number.");
					request.addProperty("Name", "none");
				}
				if (strStreet.getText().toString() != null || strStreet.getText().toString() != "") {
					request.addProperty("Address", strStreet.getText().toString());
				} else {
					request.addProperty("Address", "none");
				}
				if (strApt.getText().toString() != null || strApt.getText().toString() != "") {
					request.addProperty("Apt", strApt.getText().toString());
				} else {
					request.addProperty("Apt", "none");
				}
				if (strCity.getText().toString() != null || strCity.getText().toString() != "") {
					request.addProperty("City", strCity.getText().toString());
				} else {
					request.addProperty("City", "none");
				}
				if (strState.getText().toString() != null || strState.getText().toString() != "") {
					request.addProperty("State", strState.getText().toString());
				} else {
					request.addProperty("State", "none");
				}
				if (strZip.getText().toString() != null || strZip.getText().toString() != "") {
					request.addProperty("Zip", strZip.getText().toString());
				} else {
					request.addProperty("Zip", "none");
				}
				if (strEmail.getText().toString() != null || strEmail.getText().toString() != "") {
					request.addProperty("Email", strEmail.getText().toString());
				} else {
					request.addProperty("Email", "none");
				}
				if (strPhone.getText().toString() != null || strPhone.getText().toString() != "") {
					request.addProperty("Phone", strPhone.getText().toString());
				} else {
					request.addProperty("Phone", "none");
				}
				if (strFax.getText().toString() != null || strFax.getText().toString() != "") {
					request.addProperty("Fax", strFax.getText().toString());
				} else {
					request.addProperty("Fax", "none");
				}
				if (strMobile.getText().toString() != null || strMobile.getText().toString() != "") {
					request.addProperty("Mobile", strMobile.getText().toString());
				} else {
					request.addProperty("Mobile", "none");
				}
				if (strWebsite.getText().toString() != null || strWebsite.getText().toString() != "") {
					request.addProperty("Website", strWebsite.getText().toString());
				} else {
					request.addProperty("Website", "none");
				}
				if (strPayment.getText().toString() != null || strPayment.getText().toString() != "") {
					request.addProperty("PaymentAccepted", strPayment.getText().toString());
				} else {
					request.addProperty("PaymentAccepted", "none");
				}
				if (strDeliver.getText().toString() != null || strDeliver.getText().toString() != "") {
					request.addProperty("Deliver", strDeliver.getText().toString());
				} else {
					request.addProperty("Deliver", "none");
				}
				if (strHoursOfOperation.getText().toString() != null || strHoursOfOperation.getText().toString() != "") {
					request.addProperty("HoursOfOperation", strHoursOfOperation.getText().toString());
				} else {
					request.addProperty("HoursOfOperation", "none");
				}
				if (strCoupon.getText().toString() != null || strCoupon.getText().toString() != "") {
					request.addProperty("Coupon", strCoupon.getText().toString());
				} else {
					request.addProperty("Coupon", "none");
				}
				if (strCountOfCertification.getText().toString() != null
						|| strCountOfCertification.getText().toString() != "") {
					request.addProperty("CountOfCertification", strCountOfCertification.getText().toString());
				} else {
					request.addProperty("CountOfCertification", "none");
				}

				envelope.setOutputSoapObject(request);

				HttpTransportSE androidHttpTransport = new HttpTransportSE(Config.get_URL());
				new AlertDialog.Builder(this).setTitle("CCNY").setMessage("Thanks for your information, we need one week to review the information.")
						.setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								finish();
							}
						}).show();
				androidHttpTransport.call(Config.get_SOAP_ACTION(METHOD_NAME), envelope);

			} catch (XmlPullParserException ex) {
				// Log.i(ACTIVITY_SERVICE, "=================================="
				// + ex);
				ex.printStackTrace();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

}