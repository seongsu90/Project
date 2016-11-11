package com.mycompany.ourapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dao.ReviewDao;
import com.mycompany.ourapp.dto.Review;

@Component
public class ReviewService {
	
	public static final int WRITE_SUCCESS = 0;
	public static final int WRITE_FAIL =1;
	
	public static final int DELETE_SUCCESS = 0;
	public static final int DELETE_FAIL = 1;
	
	@Autowired
	private ReviewDao reviewDao;
	
	public int write(Review review) {
		int row = reviewDao.insert(review);
		if(row == 0) {
			return WRITE_FAIL;
		}
		return WRITE_SUCCESS;		
	}

	public int delete(int revno, int revMid) {
		int row = reviewDao.delete(revno, revMid);
		if(row == 0) {
			return DELETE_FAIL;
		}
		return DELETE_SUCCESS;
	}
	
	public Review info(int revno) {
		Review review = reviewDao.selectInfo(revno);
		return review;
	}
}
