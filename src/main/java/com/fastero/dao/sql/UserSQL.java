package com.fastero.dao.sql;

public class UserSQL {

	public static final String GET_ALL = "SELECT * FROM FASTERO.User;";
	public static final String GET_BY_ID = "SELECT * FROM FASTERO.User where user_id = ?;";
	public static final String INSERT = "insert into `User` (user_account, user_password, user_name, user_phone) values (?, ?, ?, ?);";
}
