package com.fastero.service.impl;

import java.util.List;

import com.fastero.dao.impl.ReviewDAO;
import com.fastero.dao.intf.ReviewDAOIntf;
import com.fastero.model.ReviewVO;
//
public class ReviewService {
	private ReviewDAOIntf dao;

	public ReviewService() {
		dao = new ReviewDAO();
		}

	public ReviewVO addReview(ReviewVO reviewVO) {

//		ReviewVO reviewVO = new ReviewVO();
//
//		reviewVO.setUser_id(user_id);
//		reviewVO.setStore_id(store_id);
//		reviewVO.setReview_point(review_point);
//		reviewVO.setReview_text(review_text);
		dao.insert(reviewVO);

		return reviewVO;
	}

	public ReviewVO updateReview(ReviewVO reviewVO) {
	    dao.update(reviewVO);
	    return reviewVO;
    }
	
	public ReviewVO updateReview(Integer review_id, Integer user_id, Integer store_id,
			Integer review_point, String review_text) {

		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setReview_id(review_id);
		reviewVO.setUser_id(user_id);
		reviewVO.setStore_id(store_id);
		reviewVO.setReview_point(review_point);
		reviewVO.setReview_text(review_text);
		dao.update(reviewVO);

		return reviewVO;
	}
	
	public void deleteReview(Integer review_id) {
		dao.delete(review_id);	
	}
	
	public List<ReviewVO> getOneReview() {	    
	    try {
	        return dao.findByPrimaryKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}

	public List<ReviewVO> getAll() {
		return dao.getAll();
	}

	public ReviewVO getOneReviewforupdate(Integer review_id) {
		return dao.findReviewid(review_id);
	}
	public List<ReviewVO> getById(){
	    try {
            return dao.getById();
        } catch (Exception e) {
            e.printStackTrace();
        }
	    return null;
	}

    public ReviewVO getOne(Integer user_id) {
        return null;
    }

    public ReviewVO getByReviewId() {
        return dao.getByReviewId();
    }
    
}
