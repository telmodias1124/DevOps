package data;

public class Player {
	
	private String lastName;
	private String firstName;
	private PlayerStatistic playerStatistic;
	private String position;
	private boolean yellowCard;
	private boolean redCard;
	private int nbrAction;
	
	public Player() {
		this.yellowCard = false;
		this.redCard = false;
		this.nbrAction = 0;
	}
	
	public Player(String firstName, String lastName, PlayerStatistic playerStatistic, String position) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.playerStatistic = playerStatistic;
		this.position = position;
		this.yellowCard = false;
		this.redCard = false;
		this.nbrAction = 0;
	}
	
	public Player(String firstName, String lastName, PlayerStatistic playerStatistic, String position, boolean card) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.playerStatistic = playerStatistic;
		this.position = position;
		this.yellowCard = false;
		this.redCard = false;
		this.nbrAction = 0;
	}
	
	public void resetGameStatistique() {
		this.yellowCard = false;
		this.redCard = false;
		this.nbrAction = 0;
	}
	
	public void clonePlayer(Player player) {
		this.lastName = player.getLastName();
		this.firstName = player.getFirstName();
		this.playerStatistic = player.getPlayerStatistic();
		this.position = player.getPosition();
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

	public Boolean getYellowCard() {
		return yellowCard;
	}

	public void setYellowCard(Boolean card) {
		this.yellowCard = card;
	}
	
	public Boolean getRedCard() {
		return redCard;
	}

	public void setRedCard(Boolean card) {
		this.redCard = card;
	}

	public int getNbrAction() {
		return nbrAction;
	}

	public void setNbrAction(int nbrAction) {
		this.nbrAction = nbrAction;
	}
	

}
