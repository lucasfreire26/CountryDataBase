
public class Country {
	

	private int code;
	private String name;
	private Continent continent;
	private double surfaceArea;
	private String headOfState;
	
	private Country(BuilderCountry builder) {
		this.code = builder.code;
		this.name = builder.name;
		this.surfaceArea = builder.surfaceArea;
		this.headOfState = builder.headOfState;
		this.continent = builder.continent;
	}
	
	@Override
	public String toString() {
		return "Code: " + code + " Name: " + name + " Continent: " + continent + " Surface: " + surfaceArea + "Head of State: " + headOfState;
	}
	
	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Enum getContinent() {
		return continent;
	
	}
	public double getSurfaceArea() {
		return surfaceArea;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	
	public static class BuilderCountry{
		
	private int code;
	private String name;
	private Continent continent;
	private double surfaceArea;
	private String headOfState;

	public BuilderCountry(int code, String name, Continent continent, double surfaceArea2, String headOfState) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.surfaceArea = surfaceArea2;
		this.headOfState = headOfState;
	}
	
	public Country build() {
		return new Country(this);
		}
	}
}

