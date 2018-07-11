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
	private Integer userSex;

	@Column(name = "user_birthday")
	private Date userBirthday;

	@Column(name = "user_job")
	private String userJob;

	@Column(name = "user_post")
	private String userPost;

	@Column(name = "user_introduction")
	private String userIntroduction;

	@Column(name = "user_place")
	private Integer userPlace;

	@Column(name = "user_image")
	private String userImage;

	@Column(name = "user_recent_login_time")
	private Date userRecentLogIntegerime;

	@Column(name = "user_pv")
	private Integer userPv;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "state")
	private Integer state;

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserSex() {
		return userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserJob() {
		return userJob;
	}

	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}

	public String getUserPost() {
		return userPost;
	}

	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}

	public String getUserIntroduction() {
		return userIntroduction;
	}

	public void setUserIntroduction(String userIntroduction) {
		this.userIntroduction = userIntroduction;
	}

	public Integer getUserPlace() {
		return userPlace;
	}

	public void setUserPlace(Integer userPlace) {
		this.userPlace = userPlace;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public Date getUserRecentLogIntegerime() {
		return userRecentLogIntegerime;
	}

	public void setUserRecentLogIntegerime(Date userRecentLogIntegerime) {
		this.userRecentLogIntegerime = userRecentLogIntegerime;
	}

	public Integer getUserPv() {
		return userPv;
	}

	public void setUserPv(Integer userPv) {
		this.userPv = userPv;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
