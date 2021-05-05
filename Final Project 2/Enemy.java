public class Enemy extends Battler{
	public static void main(String[] args) {
		
	}
	
	private String name = " ";
	private boolean status;
	
	public Enemy() {
		
	}

	public Enemy(String n, int m, int d, int s) {
		this.name = n;
		this.mHP = m;
		this.cHP = m;
		this.dmg = d;
		this.spd = s;
	}

	public String getName() {
		return name;
	}
	
	public int getDMG(){
		return this.dmg;
	}

	public void setDMG(int newdmg) {
		this.dmg = newdmg;
	}
	
	public int getSPD() {
		return this.spd;
	}

	public void setSPD(int newSPD) {
		this.spd = newSPD;
	}

	public String toString2() {
		return (name.replaceAll("\\s+", "_") + " " + mHP + " " + dmg + " " + spd);
	}

	@Override
	public String toString() {
		return (name + " " + this.cHP + " " + dmg + " " + spd);
	}
}