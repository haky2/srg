package com.srg.domain;

import com.srg.restaurant.entity.Review;
import com.srg.restaurant.repository.ReviewRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewRepositoryTest {
    @Autowired
    ReviewRepository reviewRepository;

    @After
    public void cleanUp() {
        /* test 이후 repository 전체 데이터 삭제 */
//        reviewRepository.deleteAll();
    }

    @Test
    public void saveAndGetReviews() {
        // given
//        reviewRepository.save(Review.builder()
//                .userNo(1)
//                .resNo(1)
//                .score(5)
//                .title("테스트 제목")
//                .content("테스트 내용")
//                .attachment(null)
//                .build()
//        );
//        // when
//        List<Review> reviewList = reviewRepository.findAll();
//        // then
//        Review review = reviewList.get(0);
//        assertThat(review.getScore(), is(5));
//        assertThat(review.getTitle(), is("테스트 제목"));
    }
}
