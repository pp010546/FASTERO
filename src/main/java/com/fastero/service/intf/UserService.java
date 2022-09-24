package com.fastero.service.intf;

import com.fastero.common.Result;
import com.fastero.vo.UserVO;

public interface UserService {

	public Result getAll() throws Exception;

	public Result getById(Integer id);
	
	public Result register(UserVO vo);
	
	public Result login(String account, String password);

}
