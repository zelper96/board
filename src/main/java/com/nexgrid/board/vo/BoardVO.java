package com.nexgrid.board.vo;

import com.nexgrid.board.dataControl.Pageging;

public class BoardVO extends Pageging {

	private int room_idx;
	private String user_name;
	private String title;
	private String content_text;
	private String first_date;
	private String upload_date;
	private int click_idx;

	@Override
	public String toString() {
		return "BoardVO{" +
				"room_idx=" + room_idx +
				", user_name='" + user_name + '\'' +
				", title='" + title + '\'' +
				", content_text='" + content_text + '\'' +
				", first_date='" + first_date + '\'' +
				", upload_date='" + upload_date + '\'' +
				", click_idx=" + click_idx +
				'}';
	}

	public int getRoom_idx() {
		return room_idx;
	}

	public void setRoom_idx(int room_idx) {
		this.room_idx = room_idx;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent_text() {
		return content_text;
	}

	public void setContent_text(String content_text) {
		this.content_text = content_text;
	}

	public String getFirst_date() {
		return first_date;
	}

	public void setFirst_date(String first_date) {
		this.first_date = first_date;
	}

	public String getUpload_date() {
		return upload_date;
	}

	public void setUpload_date(String upload_date) {
		this.upload_date = upload_date;
	}

	public int getClick_idx() {
		return click_idx;
	}

	public void setClick_idx(int click_idx) {
		this.click_idx = click_idx;
	}

}
