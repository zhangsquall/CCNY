package com.android.ccny.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.axis2.context.MessageContext;

/**
 * @author qingjiezhao.
 * @email zhaoqingjie@gmail.com
 */
public class DaoService {

	/**
	 * @return
	 */
	public Business[] findAllBusiness() {
		Connection conn = (Connection) MessageContext
				.getCurrentMessageContext().getProperty(
						DBServiceLifeCycle.DB_CONNECTION);
		if (conn != null) {
			String SQL = "SELECT * FROM Business order by name where status = '1'";
			try {
				PreparedStatement statement = conn.prepareStatement(SQL);
				ResultSet result = statement.executeQuery();
				ArrayList<Business> list = new ArrayList<Business>();
				while (result.next()) {
					Business business = new Business();

					if (result.getInt("ID") == 0) {
						business.setId(0);
					} else {
						business.setId(result.getInt("ID"));
					}
					if (result.getInt("Cou_Id") == 0) {
						business.setCou_Id(0);
					} else {
						business.setCou_Id(result.getInt("Cou_Id"));
					}
					if (result.getInt("Cat_Id") == 0) {
						business.setCat_Id(0);
					} else {
						business.setCat_Id(result.getInt("Cat_Id"));
					}

					if (result.getString("FirstName") == null
							|| result.getString("FirstName") == "") {
						business.setFirstName("It does not have firstname now.");
					} else {
						business.setFirstName(result.getString("FirstName"));
					}
					if (result.getString("LastName") == null
							|| result.getString("LastName") == "") {
						business.setLastName("It does not have lastname now.");
					} else {
						business.setLastName(result.getString("LastName"));
					}
					if (result.getString("Name") == null
							|| result.getString("Name") == "") {
						business.setName("It does not have name now.");
					} else {
						business.setName(result.getString("Name"));
					}
					if (result.getString("Address") == null
							|| result.getString("Address") == "") {
						business.setAddress("It does not have address now.");
					} else {
						business.setAddress(result.getString("Address"));
					}
					if (result.getString("Apt") == null
							|| result.getString("Apt") == "") {
						business.setApt("It does not have Apt now.");
					} else {
						business.setApt(result.getString("Apt"));
					}

					if (result.getString("City") == null
							|| result.getString("City") == "") {
						business.setCity("It does not have city now.");
					} else {
						business.setCity(result.getString("City"));
					}

					if (result.getString("State") == null
							|| result.getString("State") == "") {
						business.setState("It does not have State now.");
					} else {
						business.setState(result.getString("State"));
					}

					if (result.getString("Zip") == null
							|| result.getString("Zip") == "") {
						business.setZip("It does not have zip now.");
					} else {
						business.setZip(result.getString("Zip"));
					}

					if (result.getString("Email") == null
							|| result.getString("Email") == "") {
						business.setEmail("It does not have Email now.");
					} else {
						business.setEmail(result.getString("Email"));
					}

					if (result.getString("Phone") == null
							|| result.getString("Phone") == "") {
						business.setPhone("It does not have phone number.");
					} else {
						business.setPhone(result.getString("Phone"));
					}

					if (result.getString("Fax") == null
							|| result.getString("Fax") == "") {
						business.setFax("It does not have Fax number.");
					} else {
						business.setFax(result.getString("Fax"));
					}
					if (result.getString("Mobile") == null
							|| result.getString("Mobile") == "") {
						business.setMobile("It does not have Mobile number.");
					} else {
						business.setMobile(result.getString("Mobile"));
					}
					if (result.getString("Website") == null
							|| result.getString("Website") == "") {
						business.setWebsite("It does not have website now.");
					} else {
						business.setWebsite(result.getString("Website"));
					}

					if (result.getString("PaymentAccepted") == null
							|| result.getString("PaymentAccepted") == "") {
						business.setPaymentAccepted("It does not have PaymentAccepted now.");
					} else {
						business.setPaymentAccepted(result
								.getString("PaymentAccepted"));
					}

					if (result.getString("Deliver") == null
							|| result.getString("Deliver") == "") {
						business.setDeliver("It does not have Deliver now.");
					} else {
						business.setDeliver(result.getString("Deliver"));
					}

					if (result.getString("HoursOfOperation") == null
							|| result.getString("HoursOfOperation") == "") {
						business.setHoursOfOperation("It does not have HoursOfOperation.");
					} else {
						business.setHoursOfOperation(result
								.getString("HoursOfOperation"));
					}
					if (result.getString("Coupon") == null
							|| result.getString("Coupon") == "") {
						business.setCoupon("It does not have coupon.");
					} else {
						business.setCoupon(result.getString("Coupon"));
					}
					if (result.getString("Status") == null
							|| result.getString("Status") == "") {
						business.setStatus("It does not have status.");
					} else {
						business.setStatus(result.getString("Status"));
					}
					if (result.getString("CountOfCertification") == null
							|| result.getString("CountOfCertification") == "") {
						business.setCountOfCertification("It does not have countOfCertification.");
					} else {
						business.setCountOfCertification(result
								.getString("CountOfCertification"));
					}
					list.add(business);
				}
				result.close();
				statement.close();
				return (Business[]) list.toArray(new Business[list.size()]);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	/**
	 * @return
	 */

	public Category[] findAllCategory() {
		Connection conn = (Connection) MessageContext
				.getCurrentMessageContext().getProperty(
						DBServiceLifeCycle.DB_CONNECTION);
		if (conn != null) {
			String SQL = "SELECT * FROM Category order by name";
			try {
				PreparedStatement statement = conn.prepareStatement(SQL);
				ResultSet result = statement.executeQuery();
				ArrayList<Category> list = new ArrayList<Category>();
				while (result.next()) {
					Category category = new Category();

					if (result.getInt("ID") == 0) {
						category.setId(0);
					} else {
						category.setId(result.getInt("ID"));
					}

					if (result.getString("Name") == null
							|| result.getString("Name") == "") {
						category.setName("It does not have name.");
					} else {
						category.setName(result.getString("Name"));
					}
					list.add(category);
				}
				result.close();
				statement.close();
				return (Category[]) list.toArray(new Category[list.size()]);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * @return
	 */
	public County[] findAllCounty() {
		Connection conn = (Connection) MessageContext
				.getCurrentMessageContext().getProperty(
						DBServiceLifeCycle.DB_CONNECTION);
		if (conn != null) {
			String SQL = "SELECT * FROM County order by name";
			try {
				PreparedStatement statement = conn.prepareStatement(SQL);
				ResultSet result = statement.executeQuery();
				ArrayList<County> list = new ArrayList<County>();
				while (result.next()) {
					County county = new County();

					if (result.getInt("ID") == 0) {
						county.setId(0);
					} else {
						county.setId(result.getInt("ID"));
					}
					if (result.getString("Name") == null
							|| result.getString("Name") == "") {
						county.setName("It does not have name.");
					} else {
						county.setName(result.getString("Name"));
					}

					list.add(county);
				}
				result.close();
				statement.close();
				return (County[]) list.toArray(new County[list.size()]);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * @param Cat_Id
	 * @return
	 */
	public Business[] findBusinessByCategoryId(int Cat_Id) {
		Connection conn = (Connection) MessageContext
				.getCurrentMessageContext().getProperty(
						DBServiceLifeCycle.DB_CONNECTION);
		if (conn != null) {
			String SQL = "SELECT * FROM Business WHERE Cat_Id=? and status = '1' order by name";
			try {
				PreparedStatement statement = conn.prepareStatement(SQL);
				statement.setInt(1, Cat_Id);
				ResultSet result = statement.executeQuery();
				ArrayList<Business> list = new ArrayList<Business>();
				while (result.next()) {
					Business business = new Business();
					if (result.getInt("ID") == 0) {
						business.setId(0);
					} else {
						business.setId(result.getInt("ID"));
					}
					if (result.getInt("Cou_Id") == 0) {
						business.setCou_Id(0);
					} else {
						business.setCou_Id(result.getInt("Cou_Id"));
					}
					if (result.getInt("Cat_Id") == 0) {
						business.setCat_Id(0);
					} else {
						business.setCat_Id(result.getInt("Cat_Id"));
					}
					if (result.getString("FirstName") == null
							|| result.getString("FirstName") == "") {
						business.setFirstName("It does not have firstname now.");
					} else {
						business.setFirstName(result.getString("FirstName"));
					}
					if (result.getString("LastName") == null
							|| result.getString("LastName") == "") {
						business.setLastName("It does not have lastname now.");
					} else {
						business.setLastName(result.getString("LastName"));
					}
					if (result.getString("Name") == null
							|| result.getString("Name") == "") {
						business.setName("It does not have name now.");
					} else {
						business.setName(result.getString("Name"));
					}
					if (result.getString("Address") == null
							|| result.getString("Address") == "") {
						business.setAddress("It does not have address now.");
					} else {
						business.setAddress(result.getString("Address"));
					}
					if (result.getString("Apt") == null
							|| result.getString("Apt") == "") {
						business.setApt("It does not have Apt now.");
					} else {
						business.setApt(result.getString("Apt"));
					}

					if (result.getString("City") == null
							|| result.getString("City") == "") {
						business.setCity("It does not have city now.");
					} else {
						business.setCity(result.getString("City"));
					}

					if (result.getString("State") == null
							|| result.getString("State") == "") {
						business.setState("It does not have State now.");
					} else {
						business.setState(result.getString("State"));
					}

					if (result.getString("Zip") == null
							|| result.getString("Zip") == "") {
						business.setZip("It does not have zip now.");
					} else {
						business.setZip(result.getString("Zip"));
					}

					if (result.getString("Email") == null
							|| result.getString("Email") == "") {
						business.setEmail("It does not have Email now.");
					} else {
						business.setEmail(result.getString("Email"));
					}

					if (result.getString("Phone") == null
							|| result.getString("Phone") == "") {
						business.setPhone("It does not have phone number.");
					} else {
						business.setPhone(result.getString("Phone"));
					}

					if (result.getString("Fax") == null
							|| result.getString("Fax") == "") {
						business.setFax("It does not have Fax number.");
					} else {
						business.setFax(result.getString("Fax"));
					}
					if (result.getString("Mobile") == null
							|| result.getString("Mobile") == "") {
						business.setMobile("It does not have Mobile number.");
					} else {
						business.setMobile(result.getString("Mobile"));
					}
					if (result.getString("Website") == null
							|| result.getString("Website") == "") {
						business.setWebsite("It does not have website now.");
					} else {
						business.setWebsite(result.getString("Website"));
					}

					if (result.getString("PaymentAccepted") == null
							|| result.getString("PaymentAccepted") == "") {
						business.setPaymentAccepted("It does not have PaymentAccepted now.");
					} else {
						business.setPaymentAccepted(result
								.getString("PaymentAccepted"));
					}

					if (result.getString("Deliver") == null
							|| result.getString("Deliver") == "") {
						business.setDeliver("It does not have Deliver now.");
					} else {
						business.setDeliver(result.getString("Deliver"));
					}

					if (result.getString("HoursOfOperation") == null
							|| result.getString("HoursOfOperation") == "") {
						business.setHoursOfOperation("It does not have HoursOfOperation.");
					} else {
						business.setHoursOfOperation(result
								.getString("HoursOfOperation"));
					}
					if (result.getString("Coupon") == null
							|| result.getString("Coupon") == "") {
						business.setCoupon("It does not have coupon.");
					} else {
						business.setCoupon(result.getString("Coupon"));
					}
					if (result.getString("Status") == null
							|| result.getString("Status") == "") {
						business.setStatus("It does not have status.");
					} else {
						business.setStatus(result.getString("Status"));
					}
					if (result.getString("CountOfCertification") == null
							|| result.getString("CountOfCertification") == "") {
						business.setCountOfCertification("It does not have countOfCertification.");
					} else {
						business.setCountOfCertification(result
								.getString("CountOfCertification"));
					}
					list.add(business);
				}
				result.close();
				statement.close();
				return (Business[]) list.toArray(new Business[list.size()]);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	/**
	 * @param Cou_Id
	 * @return
	 */
	public Business[] findBusinessByCountyId(int Cou_Id) {
		Connection conn = (Connection) MessageContext
				.getCurrentMessageContext().getProperty(
						DBServiceLifeCycle.DB_CONNECTION);
		if (conn != null) {
			String SQL = "SELECT * FROM Business WHERE Cou_Id=? and status = '1' order by name";
			try {
				PreparedStatement statement = conn.prepareStatement(SQL);
				statement.setInt(1, Cou_Id);
				ResultSet result = statement.executeQuery();

				ArrayList<Business> list = new ArrayList<Business>();
				while (result.next()) {
					Business business = new Business();

					if (result.getInt("ID") == 0) {
						business.setId(0);
					} else {
						business.setId(result.getInt("ID"));
					}
					if (result.getInt("Cou_Id") == 0) {
						business.setCou_Id(0);
					} else {
						business.setCou_Id(result.getInt("Cou_Id"));
					}
					if (result.getInt("Cat_Id") == 0) {
						business.setCat_Id(0);
					} else {
						business.setCat_Id(result.getInt("Cat_Id"));
					}
					if (result.getString("FirstName") == null
							|| result.getString("FirstName") == "") {
						business.setFirstName("It does not have firstname now.");
					} else {
						business.setFirstName(result.getString("FirstName"));
					}
					if (result.getString("LastName") == null
							|| result.getString("LastName") == "") {
						business.setLastName("It does not have lastname now.");
					} else {
						business.setLastName(result.getString("LastName"));
					}
					if (result.getString("Name") == null
							|| result.getString("Name") == "") {
						business.setName("It does not have name now.");
					} else {
						business.setName(result.getString("Name"));
					}
					if (result.getString("Address") == null
							|| result.getString("Address") == "") {
						business.setAddress("It does not have address now.");
					} else {
						business.setAddress(result.getString("Address"));
					}
					if (result.getString("Apt") == null
							|| result.getString("Apt") == "") {
						business.setApt("It does not have Apt now.");
					} else {
						business.setApt(result.getString("Apt"));
					}

					if (result.getString("City") == null
							|| result.getString("City") == "") {
						business.setCity("It does not have city now.");
					} else {
						business.setCity(result.getString("City"));
					}

					if (result.getString("State") == null
							|| result.getString("State") == "") {
						business.setState("It does not have State now.");
					} else {
						business.setState(result.getString("State"));
					}

					if (result.getString("Zip") == null
							|| result.getString("Zip") == "") {
						business.setZip("It does not have zip now.");
					} else {
						business.setZip(result.getString("Zip"));
					}
					if (result.getString("Email") == null
							|| result.getString("Email") == "") {
						business.setEmail("It does not have Email now.");
					} else {
						business.setEmail(result.getString("Email"));
					}

					if (result.getString("Phone") == null
							|| result.getString("Phone") == "") {
						business.setPhone("It does not have phone number.");
					} else {
						business.setPhone(result.getString("Phone"));
					}

					if (result.getString("Fax") == null
							|| result.getString("Fax") == "") {
						business.setFax("It does not have Fax number.");
					} else {
						business.setFax(result.getString("Fax"));
					}
					if (result.getString("Mobile") == null
							|| result.getString("Mobile") == "") {
						business.setMobile("It does not have Mobile number.");
					} else {
						business.setMobile(result.getString("Mobile"));
					}
					if (result.getString("Website") == null
							|| result.getString("Website") == "") {
						business.setWebsite("It does not have website now.");
					} else {
						business.setWebsite(result.getString("Website"));
					}

					if (result.getString("PaymentAccepted") == null
							|| result.getString("PaymentAccepted") == "") {
						business.setPaymentAccepted("It does not have PaymentAccepted now.");
					} else {
						business.setPaymentAccepted(result
								.getString("PaymentAccepted"));
					}

					if (result.getString("Deliver") == null
							|| result.getString("Deliver") == "") {
						business.setDeliver("It does not have Deliver now.");
					} else {
						business.setDeliver(result.getString("Deliver"));
					}

					if (result.getString("HoursOfOperation") == null
							|| result.getString("HoursOfOperation") == "") {
						business.setHoursOfOperation("It does not have HoursOfOperation.");
					} else {
						business.setHoursOfOperation(result
								.getString("HoursOfOperation"));
					}
					if (result.getString("Coupon") == null
							|| result.getString("Coupon") == "") {
						business.setCoupon("It does not have coupon.");
					} else {
						business.setCoupon(result.getString("Coupon"));
					}
					if (result.getString("Status") == null
							|| result.getString("Status") == "") {
						business.setStatus("It does not have status.");
					} else {
						business.setStatus(result.getString("Status"));
					}
					if (result.getString("CountOfCertification") == null
							|| result.getString("CountOfCertification") == "") {
						business.setCountOfCertification("It does not have countOfCertification.");
					} else {
						business.setCountOfCertification(result
								.getString("CountOfCertification"));
					}
					list.add(business);
				}
				result.close();
				statement.close();
				return (Business[]) list.toArray(new Business[list.size()]);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * @param Cou_Id
	 * @param Cat_Id
	 * @return
	 */
	public Business[] findBusinessByCountyIdAndCategoryId(int Cou_Id, int Cat_Id) {
		Connection conn = (Connection) MessageContext
				.getCurrentMessageContext().getProperty(
						DBServiceLifeCycle.DB_CONNECTION);
		if (conn != null) {
			String SQL = "SELECT * FROM Business WHERE Cou_Id=? and Cat_Id=? and status = '1' order by name";
			try {
				PreparedStatement statement = conn.prepareStatement(SQL);
				statement.setInt(1, Cou_Id);
				statement.setInt(2, Cat_Id);
				ResultSet result = statement.executeQuery();
				ArrayList<Business> list = new ArrayList<Business>();
				while (result.next()) {
					Business business = new Business();
					if (result.getInt("ID") == 0) {
						business.setId(0);
					} else {
						business.setId(result.getInt("ID"));
					}
					if (result.getInt("Cou_Id") == 0) {
						business.setCou_Id(0);
					} else {
						business.setCou_Id(result.getInt("Cou_Id"));
					}
					if (result.getInt("Cat_Id") == 0) {
						business.setCat_Id(0);
					} else {
						business.setCat_Id(result.getInt("Cat_Id"));
					}
					if (result.getString("FirstName") == null
							|| result.getString("FirstName") == "") {
						business.setFirstName("It does not have firstname now.");
					} else {
						business.setFirstName(result.getString("FirstName"));
					}
					if (result.getString("LastName") == null
							|| result.getString("LastName") == "") {
						business.setLastName("It does not have lastname now.");
					} else {
						business.setLastName(result.getString("LastName"));
					}
					if (result.getString("Name") == null
							|| result.getString("Name") == "") {
						business.setName("It does not have name now.");
					} else {
						business.setName(result.getString("Name"));
					}
					if (result.getString("Address") == null
							|| result.getString("Address") == "") {
						business.setAddress("It does not have address now.");
					} else {
						business.setAddress(result.getString("Address"));
					}
					if (result.getString("Apt") == null
							|| result.getString("Apt") == "") {
						business.setApt("It does not have Apt now.");
					} else {
						business.setApt(result.getString("Apt"));
					}

					if (result.getString("City") == null
							|| result.getString("City") == "") {
						business.setCity("It does not have city now.");
					} else {
						business.setCity(result.getString("City"));
					}

					if (result.getString("State") == null
							|| result.getString("State") == "") {
						business.setState("It does not have State now.");
					} else {
						business.setState(result.getString("State"));
					}

					if (result.getString("Zip") == null
							|| result.getString("Zip") == "") {
						business.setZip("It does not have zip now.");
					} else {
						business.setZip(result.getString("Zip"));
					}

					if (result.getString("Email") == null
							|| result.getString("Email") == "") {
						business.setEmail("It does not have Email now.");
					} else {
						business.setEmail(result.getString("Email"));
					}

					if (result.getString("Phone") == null
							|| result.getString("Phone") == "") {
						business.setPhone("It does not have phone number.");
					} else {
						business.setPhone(result.getString("Phone"));
					}

					if (result.getString("Fax") == null
							|| result.getString("Fax") == "") {
						business.setFax("It does not have Fax number.");
					} else {
						business.setFax(result.getString("Fax"));
					}
					if (result.getString("Mobile") == null
							|| result.getString("Mobile") == "") {
						business.setMobile("It does not have Mobile number.");
					} else {
						business.setMobile(result.getString("Mobile"));
					}
					if (result.getString("Website") == null
							|| result.getString("Website") == "") {
						business.setWebsite("It does not have website now.");
					} else {
						business.setWebsite(result.getString("Website"));
					}

					if (result.getString("PaymentAccepted") == null
							|| result.getString("PaymentAccepted") == "") {
						business.setPaymentAccepted("It does not have PaymentAccepted now.");
					} else {
						business.setPaymentAccepted(result
								.getString("PaymentAccepted"));
					}

					if (result.getString("Deliver") == null
							|| result.getString("Deliver") == "") {
						business.setDeliver("It does not have Deliver now.");
					} else {
						business.setDeliver(result.getString("Deliver"));
					}

					if (result.getString("HoursOfOperation") == null
							|| result.getString("HoursOfOperation") == "") {
						business.setHoursOfOperation("It does not have HoursOfOperation.");
					} else {
						business.setHoursOfOperation(result
								.getString("HoursOfOperation"));
					}
					if (result.getString("Coupon") == null
							|| result.getString("Coupon") == "") {
						business.setCoupon("It does not have coupon.");
					} else {
						business.setCoupon(result.getString("Coupon"));
					}
					if (result.getString("Status") == null
							|| result.getString("Status") == "") {
						business.setStatus("It does not have status.");
					} else {
						business.setStatus(result.getString("Status"));
					}
					if (result.getString("CountOfCertification") == null
							|| result.getString("CountOfCertification") == "") {
						business.setCountOfCertification("It does not have countOfCertification.");
					} else {
						business.setCountOfCertification(result
								.getString("CountOfCertification"));
					}
					list.add(business);
				}
				result.close();
				statement.close();
				return (Business[]) list.toArray(new Business[list.size()]);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * @param name
	 * @return
	 */
	public Business[] findBusinessByName(String name) {
		Connection conn = (Connection) MessageContext
				.getCurrentMessageContext().getProperty(
						DBServiceLifeCycle.DB_CONNECTION);
		if (conn != null) {
			String SQL = "SELECT * FROM Business WHERE name=? and status = '1' order by name";
			try {
				PreparedStatement statement = conn.prepareStatement(SQL);
				statement.setString(1, name);
				ResultSet result = statement.executeQuery();
				ArrayList<Business> list = new ArrayList<Business>();
				while (result.next()) {
					Business business = new Business();
					if (result.getInt("ID") == 0) {
						business.setId(0);
					} else {
						business.setId(result.getInt("ID"));
					}
					if (result.getInt("Cou_Id") == 0) {
						business.setCou_Id(0);
					} else {
						business.setCou_Id(result.getInt("Cou_Id"));
					}
					if (result.getInt("Cat_Id") == 0) {
						business.setCat_Id(0);
					} else {
						business.setCat_Id(result.getInt("Cat_Id"));
					}
					if (result.getString("FirstName") == null
							|| result.getString("FirstName") == "") {
						business.setFirstName("It does not have firstname now.");
					} else {
						business.setFirstName(result.getString("FirstName"));
					}
					if (result.getString("LastName") == null
							|| result.getString("LastName") == "") {
						business.setLastName("It does not have lastname now.");
					} else {
						business.setLastName(result.getString("LastName"));
					}
					if (result.getString("Name") == null
							|| result.getString("Name") == "") {
						business.setName("It does not have name now.");
					} else {
						business.setName(result.getString("Name"));
					}
					if (result.getString("Address") == null
							|| result.getString("Address") == "") {
						business.setAddress("It does not have address now.");
					} else {
						business.setAddress(result.getString("Address"));
					}
					if (result.getString("Apt") == null
							|| result.getString("Apt") == "") {
						business.setApt("It does not have Apt now.");
					} else {
						business.setApt(result.getString("Apt"));
					}

					if (result.getString("City") == null
							|| result.getString("City") == "") {
						business.setCity("It does not have city now.");
					} else {
						business.setCity(result.getString("City"));
					}

					if (result.getString("State") == null
							|| result.getString("State") == "") {
						business.setState("It does not have State now.");
					} else {
						business.setState(result.getString("State"));
					}

					if (result.getString("Zip") == null
							|| result.getString("Zip") == "") {
						business.setZip("It does not have zip now.");
					} else {
						business.setZip(result.getString("Zip"));
					}

					if (result.getString("Email") == null
							|| result.getString("Email") == "") {
						business.setEmail("It does not have Email now.");
					} else {
						business.setEmail(result.getString("Email"));
					}

					if (result.getString("Phone") == null
							|| result.getString("Phone") == "") {
						business.setPhone("It does not have phone number.");
					} else {
						business.setPhone(result.getString("Phone"));
					}

					if (result.getString("Fax") == null
							|| result.getString("Fax") == "") {
						business.setFax("It does not have Fax number.");
					} else {
						business.setFax(result.getString("Fax"));
					}
					if (result.getString("Mobile") == null
							|| result.getString("Mobile") == "") {
						business.setMobile("It does not have Mobile number.");
					} else {
						business.setMobile(result.getString("Mobile"));
					}
					if (result.getString("Website") == null
							|| result.getString("Website") == "") {
						business.setWebsite("It does not have website now.");
					} else {
						business.setWebsite(result.getString("Website"));
					}

					if (result.getString("PaymentAccepted") == null
							|| result.getString("PaymentAccepted") == "") {
						business.setPaymentAccepted("It does not have PaymentAccepted now.");
					} else {
						business.setPaymentAccepted(result
								.getString("PaymentAccepted"));
					}

					if (result.getString("Deliver") == null
							|| result.getString("Deliver") == "") {
						business.setDeliver("It does not have Deliver now.");
					} else {
						business.setDeliver(result.getString("Deliver"));
					}

					if (result.getString("HoursOfOperation") == null
							|| result.getString("HoursOfOperation") == "") {
						business.setHoursOfOperation("It does not have HoursOfOperation.");
					} else {
						business.setHoursOfOperation(result
								.getString("HoursOfOperation"));
					}
					if (result.getString("Coupon") == null
							|| result.getString("Coupon") == "") {
						business.setCoupon("It does not have coupon.");
					} else {
						business.setCoupon(result.getString("Coupon"));
					}
					if (result.getString("Status") == null
							|| result.getString("Status") == "") {
						business.setStatus("It does not have status.");
					} else {
						business.setStatus(result.getString("Status"));
					}
					if (result.getString("CountOfCertification") == null
							|| result.getString("CountOfCertification") == "") {
						business.setCountOfCertification("It does not have countOfCertification.");
					} else {
						business.setCountOfCertification(result
								.getString("CountOfCertification"));
					}
					list.add(business);
				}
				result.close();
				statement.close();
				return (Business[]) list.toArray(new Business[list.size()]);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * @param Cat_Id
	 * @param Cou_Id
	 * @param FirstName
	 * @param LastName
	 * @param Name
	 * @param Address
	 * @param Apt
	 * @param City
	 * @param State
	 * @param Zip
	 * @param Email
	 * @param Phone
	 * @param Fax
	 * @param Mobile
	 * @param Website
	 * @param PaymentAccepted
	 * @param Deliver
	 * @param HoursOfOperation
	 * @param Coupon
	 * @param Status
	 * @param CountOfCertification
	 */
	public void insertBusiness(String Cat_Id, String Cou_Id, String FirstName,
			String LastName, String Name, String Address, String Apt,
			String City, String State, String Zip, String Email, String Phone,
			String Fax, String Mobile, String Website, String PaymentAccepted,
			String Deliver, String HoursOfOperation, String Coupon,
			String Status, String CountOfCertification) {
		Connection conn = (Connection) MessageContext
				.getCurrentMessageContext().getProperty(
						DBServiceLifeCycle.DB_CONNECTION);
		Statement statement;
		if (conn != null) {
			String SQL = "insert into Business (Cat_Id,Cou_Id,FirstName,LastName,Name,Address,Apt,City,State,Zip,Email,Phone,Fax,Mobile,Website,PaymentAccepted,Deliver,HoursOfOperation,Coupon,Status,CountOfCertification) values("
					+ Integer.parseInt(Cat_Id)
					+ ","
					+ Integer.parseInt(Cou_Id)
					+ ",'"
					+ FirstName
					+ "','"
					+ LastName
					+ "','"
					+ Name
					+ "','"
					+ Address
					+ "','"
					+ Apt
					+ "','"
					+ City
					+ "','"
					+ State
					+ "','"
					+ Zip
					+ "','"
					+ Email
					+ "','"
					+ Phone
					+ "','"
					+ Fax
					+ "','"
					+ Mobile
					+ "','"
					+ Website
					+ "','"
					+ PaymentAccepted
					+ "','"
					+ Deliver
					+ "','"
					+ HoursOfOperation
					+ "','"
					+ Coupon
					+ "','"
					+ Status
					+ "','" + CountOfCertification + "')";
			try {
				statement = conn.createStatement();
				statement.executeUpdate(SQL);
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
