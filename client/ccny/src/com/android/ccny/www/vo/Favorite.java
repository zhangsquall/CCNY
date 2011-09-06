package com.android.ccny.www.vo;
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
public class Favorite {

	private int favoriteId;
	private String name;

	/**
	 * @param favoriteId
	 * @param name
	 */
	public Favorite(int favoriteId, String name) {
		this.favoriteId = favoriteId;
		this.name = name;
	}

	/**
	 * @param name
	 */
	public Favorite(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public int getFavoriteId() {
		return favoriteId;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param favoriteId
	 */
	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Favorite [favoriteId=" + favoriteId + ", name=" + name + "]";
	}

}
