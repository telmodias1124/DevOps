package data;

public class PlayerStatistic {
	
	private int shoot;
	private int def;
	private int pass;
	private int pace;
	private int dribble;
	private int mental;
	private int physique;
	
	public PlayerStatistic() {
		
	}
	
	public PlayerStatistic(int shoot, int def) {
		this.shoot = shoot;
		this.def = def;
	}
	
	
	public PlayerStatistic(int shoot, int def, int pass, int pace, int dribble, int physique, int mental) {
		super();
		this.shoot = shoot;
		this.def = def;
		this.pass = pass;
		this.pace = pace;
		this.dribble = dribble;
		this.mental = mental;
		this.physique = physique;
	}
	public int getShoot() {
		return shoot;
	}
	public void setShoot(int shoot   ) {
		this.shoot = shoot;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	public int getPace() {
		return pace;
	}
	public void setPace(int pace) {
		this.pace = pace;
	}
	public int getDribble() {
		return dribble;
	}
	public void setDribble(int dribble) {
		this.dribble = dribble;
	}
	public int getMental() {
		return mental;
	}
	public void setMental(int mental) {
		this.mental = mental;
	}
	public int getPhysique() {
		return physique;
	}
	public void setPhysique(int physique) {
		this.physique = physique;
	}
	
	

}
