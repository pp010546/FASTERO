package com.fastero.dao.intf;

import java.util.List;

import com.fastero.model.ReviewVO;



//
public interface ReviewDAOIntf {
	public void insert(ReviewVO reviewVO);
    public void update(ReviewVO reviewVO);
    public void delete(Integer review_id);
    public ReviewVO findByPrimaryKey(Integer user_id);
    public List<ReviewVO> getAll();
	public ReviewVO findReviewid(Integer review_id);
	
	
}