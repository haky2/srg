package com.srg.restaurant.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "reviews")
public class Reviews {
    // 리뷰 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_no", columnDefinition = "int(11) unsigned")
    private int reviewNo;

    // 회원 번호
    @NotNull
    @Column(nullable = false, columnDefinition = "int(11) unsigned")
    private int userNo;

    // 식당 번호
    @NotNull
    @Column(nullable = false, columnDefinition = "int(11) unsigned")
    private int resNo;
    // 별점 (부동소수점 오차 회피 위해 정수 타입 사용)
    @NotNull
    @Column(nullable = false, columnDefinition = "int(11) unsigned")
    private int score;
    // 제목
    @NotNull
    @Column(nullable = false, columnDefinition = "varchar(100)")
    @Length(max = 100)
    private String title;
    // 내용
    @NotNull
    @Column(nullable = false, columnDefinition = "text")
    private String content;
    // 첨부파일
    private String attachment;
    // 작성일
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime writtenYmdt;
    // 마지막 수정일
    @UpdateTimestamp
    private LocalDateTime updatedYmdt;

    @Builder
    public Reviews(int userNo, int resNo, int score, String title, String content, String attachment) {
        this.userNo = userNo;
        this.resNo = resNo;
        this.score = score;
        this.title = title;
        this.content = content;
        this.attachment = attachment;
    }
}
