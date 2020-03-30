package data;

public class Player {
	
	private String lastName;
	private String firstName;
	private PlayerStatistic playerStatistic;
	private String position;
	private boolean card;
	
	public Player() {
		this.card = false;
	}
	
	public Player(String firstName, String lastName, PlayerStatistic playerStatistic, String position) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.playerStatistic = playerStatistic;
		this.position = position;
		this.card = false;
	}
	
	public Player(String firstName, String lastName, PlayerStatistic playerStatistic, String position, boolean card) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.playerStatistic = playerStatistic;
		this.position = position;
		this.card = false;
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

	public Boolean getCard() {
		return card;
	}

	public void setCard(Boolean card) {
		this.card = card;
	}
	

}
