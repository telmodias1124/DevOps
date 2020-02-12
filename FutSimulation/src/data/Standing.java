package data;

import java.util.HashMap;

public class Standing {

	private Team first, second, third, fourth;
	
	private HashMap<Team, Integer> hm;
	
	public Standing() {
		this.hm =  new HashMap<Team, Integer>();
	}

	public Standing(Team first, Team second, Team third, Team fourth, HashMap<Team, Integer> hm) {
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.hm = hm;
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
	
	
	public HashMap<Team, Integer> getHm() {
		return hm;
	}

	public void setHm(HashMap<Team, Integer> hm) {
		this.hm = hm;
	}

	
	
	
}
