package data;

public class PlayerStatistic {
	
	private int att;
	private int def;
	private int endurance;
	private int vitesse;
	private int lvlTech;
	private int mental;
	private int physique;
	
	public PlayerStatistic() {
		
	}
	
	public PlayerStatistic(int att, int def) {
		this.att = att;
		this.def = def;
	}
	
	
	public PlayerStatistic(int att, int def, int endurance, int vitesse, int lvlTech, int mental, int physique) {
		super();
		this.att = att;
		this.def = def;
		this.endurance = endurance;
		this.vitesse = vitesse;
		this.lvlTech = lvlTech;
		this.mental = mental;
		this.physique = physique;
	}
	public int getAtt() {
		return att;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getEndurance() {
		return endurance;
	}
	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}
	public int getVitesse() {
		return vitesse;
	}
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	public int getLvlTech() {
		return lvlTech;
	}
	public void setLvlTech(int lvlTech) {
		this.lvlTech = lvlTech;
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
