package data;

public class Player {
	
	private String lastName;
	private String firstName;
	private PlayerStatistic playerStatistic;
	private String position;
	
	public Player() {}
	
	public Player(String lastName, String firstName, PlayerStatistic playerStatistic, String position) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.playerStatistic = playerStatistic;
		this.position = position;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public PlayerStatistic getPlayerStatistic() {
		return playerStatistic;
	}
	public void setPlayerStatistic(PlayerStatistic playerStatistic) {
		this.playerStatistic = playerStatistic;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

}
