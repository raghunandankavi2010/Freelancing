package com.idss.sportsworld;

import java.util.ArrayList;

/** Contains getter and setter method for varialbles  */
public class SitesList {

	/** Variables */
/*	private ArrayList<String> name = new ArrayList<String>();
	private ArrayList<String> website = new ArrayList<String>();
	private ArrayList<String> category = new ArrayList<String>();*/

	private ArrayList<String> title = new ArrayList<String>();
	private ArrayList<String> link = new ArrayList<String>();
	private ArrayList<String> pubdate = new ArrayList<String>();
	private ArrayList<String> description = new ArrayList<String>();

	/** In Setter method default it will return arraylist 
	 *  change that to add  */
	
/*	public ArrayList<String> getName() {
		return name;
	}

	public void setName(String name) {
		this.name.add(name);
	}

	public ArrayList<String> getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website.add(website);
	}

	public ArrayList<String> getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category.add(category);
	}*/

	
	
	
	public ArrayList<String> getTitle() {
		return title;
	}

	public void setTitle(String title1) {
		this.title.add(title1);
	}

	public ArrayList<String> getLink() {
		return link;
	}

	public void setLink(String link1) {
		this.link.add(link1);
	}

	public ArrayList<String> getPubDate() {
		return pubdate;
	}

	public void setPubDate(String pubdate1) {
		this.pubdate.add(pubdate1);
	}

	public ArrayList<String> getDescription() {
		return description;
	}

	public void setDescription(String category) {
		this.description.add(category);
	}

}
