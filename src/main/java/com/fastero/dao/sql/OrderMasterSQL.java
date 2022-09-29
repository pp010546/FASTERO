package com.fastero.dao.sql;

public class OrderMasterSQL {

	public static final String GET_ALL = "SELECT * FROM FASTERO.OrderMaster";
	public static final String GET_BY_ID = "SELECT * FROM FASTERO.OrderMaster where order_id = ?";
	public static final String GET_BY_STORE_ID = "SELECT m.order_id, m.user_id, m.store_id, m.order_status, m.order_amount, m.order_time, m.update_time, m.order_remark, s.store_name "
											   + "FROM OrderMaster m inner join Store s "
											   + "on s.store_id = m.store_id "
											   + "where store_id = ?;";
	public static final String GET_BY_USER_ID = "SELECT m.order_id, m.user_id, m.store_id, m.order_status, m.order_amount, m.order_time, m.update_time, m.order_remark, s.store_name "
											  + "FROM OrderMaster m inner join Store s "
											  + "on s.store_id = m.store_id "
											  + "where user_id = ?;";
	public static final String GET_WITH_STORE_NAME_BY_ID = "SELECT m.order_id, m.user_id, m.store_id, m.order_status, m.order_amount, m.order_time, m.update_time, m.order_remark, s.store_name "
															  + "FROM OrderMaster m inner join Store s "
															  + "on s.store_id = m.store_id "
															  + "where order_id = ?;";
}
