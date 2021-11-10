package jardin;
import jardin.flore.Vegetal;

public class Emplacement {

	private Vegetal veg;
	
	public Vegetal getVeg() {
		return veg;
	}
	
	public Emplacement(Vegetal veg) {
		this.veg = veg;
	}	
	
	@Override
	public String toString() {
		return veg.toString();
	}
	
}
