package cn.yh.st.blog.domain;

import java.util.Date;

import javax.persistence.Column;

import cn.yh.st.base.Entity;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2018-7-2 16:34:03
 */
public class BUserinfo extends Entity {
	private static final long serialVersionUID = 1L;

	@Column(name = "user_account")
	private String userAccount;

	@Column(name = "user_password")
	private String userPassword;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_sex")
	private int userSex;

	@Column(name = "user_birthday")
	private Date userBirthday;

	@Column(name = "user_job")
	private String userJob;

	@Column(name = "user_post")
	private String userPost;

	@Column(name = "user_introduction")
	private String userIntroduction;

	@Column(name = "user_place")
	private int userPlace;

	@Column(name = "user_image")
	private String userImage;

	@Column(name = "user_recent_login_time")
	private Date userRecentLoginTime;

	@Column(name = "user_pv")
	private int userPv;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "state")
	private int state;

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserSex() {
		return this.userSex;
	}

	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}

	public Date getUserBirthday() {
		return this.userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserJob() {
		return this.userJob;
	}

	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}

	public String getUserPost() {
		return this.userPost;
	}

	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}

	public String getUserIntroduction() {
		return this.userIntroduction;
	}

	public void setUserIntroduction(String userIntroduction) {
		this.userIntroduction = userIntroduction;
	}

	public int getUserPlace() {
		return this.userPlace;
	}

	public void setUserPlace(int userPlace) {
		this.userPlace = userPlace;
	}

	public String getUserImage() {
		return this.userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public Date getUserRecentLoginTime() {
		return this.userRecentLoginTime;
	}

	public void setUserRecentLoginTime(Date userRecentLoginTime) {
		this.userRecentLoginTime = userRecentLoginTime;
	}

	public int getUserPv() {
		return this.userPv;
	}

	public void setUserPv(int userPv) {
		this.userPv = userPv;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
