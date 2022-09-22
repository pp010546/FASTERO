package com.fastero.service.intf;

import com.fastero.common.Result;

public interface OrderMasterService {

	public Result getAll() throws Exception;

	public Result getById(Integer id);
}
