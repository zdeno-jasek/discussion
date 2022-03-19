package sk.posam.discussion.domain.discussion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiscussionMessageTest {
	private DiscussionMessage question;
	private Course course;
	private User user;
	private User student;

	@BeforeEach
	void setUp() throws Exception {
		course = new Course( "software engineering" );
		user = new User( "Alan Turing");
		student = new User( "Student" );
		question = new DiscussionMessage(null, course, user, DiscussionMessageType.QUESTION);
	}

	@Test
	void answerHasQuestionAsParent() {
		DiscussionMessage answer = question.answer("Moja odpoved", "Toto fakt neviem", student );
		assertEquals( question, answer.getParent() );
	}

}
