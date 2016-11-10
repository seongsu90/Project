package com.mycompany.ourapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.ourapp.dao.ReviewDao;
import com.mycompany.ourapp.dto.Review;

public class ReviewService {
	
	@Autowired
	private ReviewDao reviewDao;
	
	public int write(Review review) {
		int row = reviewDao.insert(review);
		return row;
	}

	public int delete(int revno, int revMid) {
		int row = reviewDao.delete(revno, revMid);
		return row;
	}
	
	public Review info(int revno) {
		Review review = reviewDao.selectInfo(revno);
		return review;
	}
}
