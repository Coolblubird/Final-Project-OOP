//Jordan Ashe

public class PartyMem extends Battler{
	public static void main(String[] args) {
		
	}
	
	private String name = " ";
	private boolean status;
	private String race = " ";
	private String pClass = " ";
	
	
	public PartyMem() {
		
	}

	public PartyMem(String n, String r, String c, int m, int d, int s) {
		this.name = n;
		this.mHP = m;
		this.cHP = m;
		this.race = r;
		this.pClass = c;
		this.dmg = d;
		this.spd = s;
	}

	public String getName() {
		return name;
	}

	public String getPClass() {
		return pClass;
	}

	public void setPClass(String c) {
		this.pClass = c;
	}

	public int getMHP() {
		return mHP;
	}
	
	public String getRace() {
		return race;
	}

	public void setRace(String r) {
		this.race = r;
	}
	
	public void setDMG(int d) {
		this.dmg = d;
	}

	public int getDMG(){
		return this.dmg;
	}
		
	public void setSPD(int s) {
		this.spd = s;
	}

	public int getSPD(){
		return this.spd;
	}
	
	public String toString2() {
		return (name.replaceAll("\\s+", "_") + " " + race.replaceAll("\\s+", "_") + " " + pClass.replaceAll("\\s+", "_") + " " + mHP + " " + dmg + " " + spd);
	}

	@Override
	public String toString() {
		return (name + " " + race + " " + pClass + " " + this.cHP + " " + dmg + " " + spd);
	}
}
