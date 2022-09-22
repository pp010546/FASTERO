package com.fastero.dao.sql;

public class OrderMasterSQL {

	public static final String GET_ALL = "SELECT * FROM FASTERO.OrderMaster";
	public static final String GET_BY_ID = "SELECT * FROM FASTERO.OrderMaster where order_id = ?";
}
