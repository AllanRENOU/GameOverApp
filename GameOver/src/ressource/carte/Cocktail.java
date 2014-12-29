package ressource.carte;

public class Cocktail {
	
	private int imageId;
	private String name;
	private String desc;
	private boolean checked;
	
	public Cocktail(int imageId, String name, String desc, boolean checked) {
		this.imageId = imageId;
		this.name = name;
		this.desc = desc;
		this.checked = checked;
	}

	public int getImageId() {
		return imageId;
	}

	public String getName() {
		return name;
	}

	public boolean isChecked() {
		return checked;
	}

	public String getDesc() {
		return desc;
	}

}
