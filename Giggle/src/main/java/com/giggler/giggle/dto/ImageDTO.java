package com.giggler.giggle.dto;

import org.springframework.stereotype.Component;

@Component("imagaDTO")
public class ImageDTO {
	private int img_no;
	private int post_no;
	private String imagepath;
	private int is_posting;
	private int user_no;
	
	public ImageDTO() {
	}

	public ImageDTO(int post_no, String imagepath, int is_posting, int user_no) {
		this.post_no = post_no;
		this.imagepath = imagepath;
		this.is_posting = is_posting;
		this.user_no = user_no;
	}

	public int getImg_no() {
		return img_no;
	}

	public void setImg_no(int img_no) {
		this.img_no = img_no;
	}

	public int getPost_no() {
		return post_no;
	}

	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public int getIs_posting() {
		return is_posting;
	}

	public void setIs_posting(int is_posting) {
		this.is_posting = is_posting;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	@Override
	public String toString() {
		return "ImageDTO [img_no=" + img_no + ", post_no=" + post_no + ", imagepath=" + imagepath + ", is_posting="
				+ is_posting + ", user_no=" + user_no + "]";
	}
	
	
	
}
