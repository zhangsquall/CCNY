package com.android.ccny.www;

import java.io.Serializable;

/**
 * @author qingjiezhao.
 * @email zhaoqingjie@gmail.com
 * 
 */
public class Business implements Serializable {

	private static final long serialVersionUID = -1828664228316217310L;
	private int Id;
	private int Cat_Id;
	private int Cou_Id;
	private String FirstName;
	private String LastName;
	private String Name;
	private String Address;
	private String Apt;
	private String City;
	private String State;
	private String Zip;
	private String Email;
	private String Phone;
	private String Fax;
	private String Mobile;
	private String Website;
	private String PaymentAccepted;
	private String Deliver;
	private String HoursOfOperation;
	private String Coupon;
	private String Status;
	private String CountOfCertification;

	/**
	 * @return
	 */
	public String getAddress() {
		return Address;
	}

	/**
	 * @return
	 */
	public String getApt() {
		return Apt;
	}

	/**
	 * @return
	 */
	public int getCat_Id() {
		return Cat_Id;
	}

	/**
	 * @return
	 */
	public String getCity() {
		return City;
	}

	/**
	 * @return
	 */
	public int getCou_Id() {
		return Cou_Id;
	}

	/**
	 * @return
	 */
	public String getCountOfCertification() {
		return CountOfCertification;
	}

	/**
	 * @return
	 */
	public String getCoupon() {
		return Coupon;
	}

	/**
	 * @return
	 */
	public String getDeliver() {
		return Deliver;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @return
	 */
	public String getFax() {
		return Fax;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return FirstName;
	}

	/**
	 * @return
	 */
	public String getHoursOfOperation() {
		return HoursOfOperation;
	}

	/**
	 * @return
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return LastName;
	}

	/**
	 * @return
	 */
	public String getMobile() {
		return Mobile;
	}

	/**
	 * @return
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @return
	 */
	public String getPaymentAccepted() {
		return PaymentAccepted;
	}

	/**
	 * @return
	 */
	public String getPhone() {
		return Phone;
	}

	/**
	 * @return
	 */
	public String getState() {
		return State;
	}

	/**
	 * @return
	 */
	public String getStatus() {
		return Status;
	}

	/**
	 * @return
	 */
	public String getWebsite() {
		return Website;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return Zip;
	}

	/**
	 * @param address
	 */
	public void setAddress(String address) {
		Address = address;
	}

	/**
	 * @param apt
	 */
	public void setApt(String apt) {
		Apt = apt;
	}

	/**
	 * @param cat_Id
	 */
	public void setCat_Id(int cat_Id) {
		Cat_Id = cat_Id;
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		City = city;
	}

	/**
	 * @param cou_Id
	 */
	public void setCou_Id(int cou_Id) {
		Cou_Id = cou_Id;
	}

	/**
	 * @param countOfCertificatio
	 */
	public void setCountOfCertification(String countOfCertification) {
		CountOfCertification = countOfCertification;
	}

	/**
	 * @param coupon
	 */
	public void setCoupon(String coupon) {
		Coupon = coupon;
	}

	/**
	 * @param deliver
	 */
	public void setDeliver(String deliver) {
		Deliver = deliver;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * @param fax
	 */
	public void setFax(String fax) {
		Fax = fax;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	/**
	 * @param hoursOfOperation
	 */
	public void setHoursOfOperation(String hoursOfOperation) {
		HoursOfOperation = hoursOfOperation;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	/**
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @param paymentAccepted
	 */
	public void setPaymentAccepted(String paymentAccepted) {
		PaymentAccepted = paymentAccepted;
	}

	/**
	 * @param phone
	 */
	public void setPhone(String phone) {
		Phone = phone;
	}

	/**
	 * @param state
	 */
	public void setState(String state) {
		State = state;
	}

	/**
	 * @param status
	 */
	public void setStatus(String status) {
		Status = status;
	}

	/**
	 * @param website
	 */
	public void setWebsite(String website) {
		Website = website;
	}

	/**
	 * @param zip
	 *            the zip to set
	 */
	public void setZip(String zip) {
		Zip = zip;
	}

}
