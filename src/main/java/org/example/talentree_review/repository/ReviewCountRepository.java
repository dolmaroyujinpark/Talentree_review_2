package org.example.talentree_review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.talentree_review.model.ReviewCount;

public interface ReviewCountRepository extends JpaRepository<ReviewCount, Long> {
    ReviewCount findByReviewItem(String reviewItem);
}
