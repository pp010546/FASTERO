package com.fastero.dao.intf;

import java.sql.SQLException;
import java.util.List;

import com.fastero.vo.UserVO;

public interface UserDAO {

	public List<UserVO> getAll() throws Exception;

	public UserVO getById(Integer id) throws SQLException;
	
	public Integer insert(UserVO vo);
	
	//傳帳號回傳全部資料
	public UserVO getByAccount(String account) throws Exception;
	
	public Integer update(UserVO vo) throws SQLException;
	
	public Integer updateNoPassword(UserVO vo) throws SQLException;

}
