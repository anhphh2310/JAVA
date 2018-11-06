package SchoolManagement;

import java.util.ArrayList;
import java.util.List;

public class Comment {

	protected List<String> comments;
	
	public Comment() {
		this.comments = new ArrayList<>();
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	
	public void addComment(String s) {
		comments.add(s);
	}
	public boolean removeComment(String s) {
		for (String string : comments) {
			if(string.equals(s)) {
				comments.remove(string);
				return true;
			}
		}
		return false;
	}
}
