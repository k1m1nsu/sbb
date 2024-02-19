package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

@SpringBootTest
class SbbApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	
//	@Autowired
//	private AnswerRepository answerRepository;

	@org.springframework.transaction.annotation.Transactional
	@Test
	void testJpa() {
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(2, all.size());
//		
//		Question q = all.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());
//		
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()) {
//			Question q2 = oq.get();
//			assertEquals("sbb가 무엇인가요?", q2.getSubject());
//		}
//		
//		Question q3 = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//		assertEquals(1, q3.getId());
//		
//		Question q4 = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//		assertEquals(1, q4.getId());
//		
//		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//		Question q5 = qList.get(0);
//		assertEquals("sbb가 무엇인가요?", q5.getSubject());
//		
//		List<Question> qList2 = this.questionRepository.findBySubjectContainingIgnoreCase("Sbb");
//		Question q6 = qList2.get(0);
//		assertEquals("sbb가 무엇인가요?", q6.getSubject());
//		
//		Optional<Question> oq2 = this.questionRepository.findById(1);
//		assertTrue(oq2.isPresent());
//		Question q7 = oq2.get();
//		q7.setSubject("수정된 제목");
//		this.questionRepository.save(q7);
//		
//		assertEquals(2, this.questionRepository.count());
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		assertEquals(1, this.questionRepository.count());
		
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		Answer a = new Answer();
//		a.setContent("네 자동으로 생성됩니다.");
//		a.setQuestion(q);
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);
//		
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(1, a.getQuestion().getId());
		
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		/*
		 * 이렇게 데이터를 필요한 시점에 가져오는 방식을 지연(Lazy) 방식이라고 한다.
		 * 이와 반대로 q 객체를 조회할 때 미리 answer 리스트를 모두 가져오는 방식은 즉시(Eager) 방식이라고 한다.
		 * @OneToMany, @ManyToOne 애너테이션의 옵션으로 fetch=FetchType.LAZY 또는 fetch=FetchType.EAGER처럼 가져오는 방식을 설정할 수 있는데,
		 * 이 책에서는 따로 지정하지 않고 항상 기본값(디폴트값)을 사용한다.
		 * junit에서 간단히 해결하려면 @Transactional 어노테이션을 붙히자.
		 * */
		// 아래 메소드를 실행하는 시점에 새로 조회함
		List<Answer> answerList = q.getAnswerList();
		
		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
		
		
		

	}

}
