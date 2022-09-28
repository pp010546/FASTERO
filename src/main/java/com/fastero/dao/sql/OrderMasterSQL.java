package com.fastero.dao.sql;

public class OrderMasterSQL {

	// order_id, user_id, store_id, order_status, order_amount
	// order_time, update_time, order_remark
	public static final String GET_ALL = "SELECT * FROM `FASTERO`.`OrderMaster`";

	public static final String GET_BY_ID = "SELECT * FROM `FASTERO`.`OrderMaster` where order_id = ?";

	public static final String INSERT = "INSERT INTO `FASTERO`.`OrderMaster` (`order_id`, `user_id`, `store_id`, `order_status`, `order_amount`\n"
			+ "	`order_time`, `update_time`, `order_remark`) VALUES ( ? , ? , ? , ? , ? , ? , ? , ?)";

	// public static final String UPDATE_IMG = "UPDATE `FASTERO`.`OrderMaster` SET
	// `EXHIBITION_IMG` = ? WHERE (`EXHIBITION_ID` = ?)";

	public static final String DELETE = "DELETE FROM `FASTERO`.`OrderMaster` WHERE (`order_id` = ?);";

}
