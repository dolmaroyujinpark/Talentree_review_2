package org.example.talentree_review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.talentree_review.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // 기본 JpaRepository 메서드 사용
}
