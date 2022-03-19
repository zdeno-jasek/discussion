package sk.posam.discussion.domain.discussion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DiscussionMessage {
	
	private String name;
	private String message;
	private final LocalDateTime created;
	
	/** Answers and replies. */
	private final List<DiscussionMessage> children;
	private final DiscussionMessage parent;
	
	/** Should be objects */
	private final Course course;
	private final User user;
	private final Attachments attachments;
	private final DiscussionMessageType type;
	
	public DiscussionMessage(DiscussionMessage parent, Course course, User user, DiscussionMessageType type) {
		this.parent = parent;
		this.course = course;
		this.user = user;
		this.attachments = new Attachments();
		this.type = type;
		this.children = new ArrayList();
		this.created = LocalDateTime.now();
	}
	
	public DiscussionMessage answer( String name, String message, User user ) {
		DiscussionMessage answer = new DiscussionMessage(this, this.course, user, DiscussionMessageType.ANSWER );
		children.add(answer);
		return answer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<DiscussionMessage> getChildren() {
		return children;
	}

	public DiscussionMessage getParent() {
		return parent;
	}

	public Course getCourse() {
		return course;
	}

	public DiscussionMessageType getType() {
		return type;
	}
	
}
