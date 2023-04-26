package abstract_Art;

public class Sculpture extends Art {

	private String material ;
	
	
	public Sculpture(String title, String author, String description, String paintType,String material) {
		this.setMaterial(material);
	}


	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		
	}


	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}
}
