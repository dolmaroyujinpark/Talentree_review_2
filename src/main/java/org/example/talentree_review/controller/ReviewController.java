package org.example.talentree_review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.example.talentree_review.service.ReviewService;
import org.example.talentree_review.model.Review;

import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviewResult")
    public String reviewResult(Model model) {
        model.addAttribute("newSkillCount", reviewService.getCount("새로운 능력을 얻었어요"));
        model.addAttribute("kindTransactionCount", reviewService.getCount("친절한 거래"));
        model.addAttribute("fastResponseCount", reviewService.getCount("채팅 답변이 빨라요"));
        model.addAttribute("lifeImprovementCount", reviewService.getCount("생활의 질 향상"));
        model.addAttribute("hobbyIncreaseCount", reviewService.getCount("취미를 늘릴 수 있었어요"));

        return "reviewResult";
    }

    @PostMapping("/submitReview")
    public String submitReview(@RequestParam("selectedOptions") List<String> selectedOptions) {
        Review review = new Review();
        review.setSelectedOptions(selectedOptions);

        // 각 선택된 항목의 카운트를 증가
        for (String option : selectedOptions) {
            reviewService.incrementCount(option);
        }

        // 리뷰 저장
        reviewService.saveReview(review);

        return "redirect:/reviewResult";
    }

    @GetMapping("/testReview")
    public String testReview() {
        return "testReview"; // testReview.html로 이동
    }
}
