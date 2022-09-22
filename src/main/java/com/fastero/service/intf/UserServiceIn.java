package com.fastero.service.intf;

import com.fastero.common.Result;
import com.fastero.vo.UserVO;

public interface UserServiceIn {

	public Result getAll() throws Exception;

	public Result getById(Integer id);
	
	public Result insert(UserVO vo);

}
