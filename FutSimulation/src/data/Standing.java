package data;

import java.util.HashMap;

public class Standing {

	private Team first, second, third, fourth;
	
	
	public Standing() {
	}

	public Standing(Team first, Team second, Team third, Team fourth) {
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
	}

	public Team getFirst() {
		return first;
	}

	public void setFirst(Team first) {
		this.first = first;
	}

	public Team getSecond() {
		return second;
	}

	public void setSecond(Team second) {
		this.second = second;
	}

	public Team getThird() {
		return third;
	}

	public void setThird(Team third) {
		this.third = third;
	}

	public Team getFourth() {
		return fourth;
	}

	public void setFourth(Team fourth) {
		this.fourth = fourth;
	}

	public void setTeams(Team first, Team second, Team third, Team fourth) {
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
	}	
	
}
