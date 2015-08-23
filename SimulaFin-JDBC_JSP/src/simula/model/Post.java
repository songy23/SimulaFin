package simula.model;

import java.util.Date;

public class Post {
	
	protected int Post_id;
	protected String Headline;
	protected String Content;
	protected User Author;
	protected Date Timestamp;
	protected String Center_Name;
	
	
	
	
	public int getPost_id() {
		return Post_id;
	}
	public void setPost_id(int post_id) {
		Post_id = post_id;
	}
	public String getHeadline() {
		return Headline;
	}
	public void setHeadline(String headline) {
		Headline = headline;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public User getAuthor() {
		return Author;
	}
	public void setAuthor(User author) {
		Author = author;
	}
	public Date getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(Date timestamp) {
		Timestamp = timestamp;
	}
	public String getCenter_Name() {
		return Center_Name;
	}
	public void setCenter_Name(String center_Name) {
		Center_Name = center_Name;
	}
	
	

}
