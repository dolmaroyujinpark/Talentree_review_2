package org.example.talentree_review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.talentree_review.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
    // 필요시 커스텀 쿼리 메서드 추가 가능
}
