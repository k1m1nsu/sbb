package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.sbb.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter // 일반적으로는 엔티티를 만들 때에는 Setter 메서드를 사용하지 않기를 권한다. 생성자로만 데이터 집어넣음
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 200)
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;
	
	// 엔티티의 속성은 @Column 애너테이션을 사용하지 않더라도 테이블의 열로 인식한다. 
	// 테이블의 열로 인식하고 싶지 않다면 @Transient 애너테이션을 사용한다.
	// @Transient 애너테이션은 엔티티의 속성을 테이블의 열로 만들지 않고 클래스의 속성 기능으로만 사용하고자 할 때 쓴다.

}
