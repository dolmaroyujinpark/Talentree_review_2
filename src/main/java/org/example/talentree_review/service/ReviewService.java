package org.example.talentree_review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.talentree_review.model.Review;
import org.example.talentree_review.model.ReviewCount;
import org.example.talentree_review.repository.ReviewRepository;
import org.example.talentree_review.repository.ReviewCountRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewCountRepository reviewCountRepository;

    // 리뷰 항목의 카운트를 증가시키는 메서드
    public void incrementCount(String selectedOption) {
        ReviewCount reviewCount = reviewCountRepository.findByReviewItem(selectedOption);

        if (reviewCount == null) {
            // 해당 항목이 없으면 새로 생성
            reviewCount = new ReviewCount(selectedOption);
        }
        reviewCount.incrementCount();
        reviewCountRepository.save(reviewCount); // 카운트 업데이트 후 저장
    }

    // 리뷰 항목에 대한 카운트 조회
    public long getCount(String reviewItem) {
        ReviewCount reviewCount = reviewCountRepository.findByReviewItem(reviewItem);
        return reviewCount != null ? reviewCount.getCount() : 0;
    }

    // 리뷰를 저장하는 메서드
    public void saveReview(Review review) {
        reviewRepository.save(review);
    }
}
