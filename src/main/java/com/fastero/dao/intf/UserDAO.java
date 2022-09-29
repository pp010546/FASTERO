package com.fastero.dao.intf;

import java.util.List;

import com.fastero.vo.UserVO;

public interface UserDAO {

	public List<UserVO> getAll() throws Exception;

	public List<UserVO> getById(Integer id);
	
	public Integer insert(UserVO vo);
	
	//傳帳號回傳全部資料
	public UserVO getByAccount(String account) throws Exception;

}
