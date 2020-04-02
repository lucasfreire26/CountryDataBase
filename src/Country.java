// this is the class country which I created following 
// what we saw in class for the builder design pattern.
// this is also called creational pattern because 
// it is one of the best ways to create objects in modern programming.
// this pattern creates a builder that is independent of other objetcs,
// giving the program persistency in terms of error or crashing down,
// because it accesses an object created by the builder, instead of accessing the 
// constructor or the object directly.
// for that we need an interface, that I have created following the DAO pattern.
// in this project this interface is called countryDAO


public class Country {
	

	//attributes of the object country
	private String code;
	private String name;
	private Continent continent;
	private float surfaceArea;
	private String headOfState;
	
	//initializing my attributes
	Country(BuilderCountry builder) {
		this.code = builder.code;
		this.name = builder.name;
		this.surfaceArea = builder.surfaceArea;
		this.headOfState = builder.headOfState;
		this.continent = builder.continent;
	}
	
	@Override
	public String toString() {
		return "Code: " + code + " Name: " + name + " Continent: " 
	+ continent + " Surface: " + surfaceArea + " Head of State: " 
				+ headOfState;
	}
	
	//getters
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Continent getContinent() {
		return continent;
	
	}
	public double getSurfaceArea() {
		return surfaceArea;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	//this class is actually going to build my object
	public static class BuilderCountry{
		
	private String code;
	private String name;
	private Continent continent;
	private float surfaceArea;
	private String headOfState;

	//more specifically, this is my constructor
	public BuilderCountry(String code, String name, Continent continent, float surfaceArea2, String headOfState) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.surfaceArea = surfaceArea2;
		this.headOfState = headOfState;
	}
	
	//here I call my method to build my object, return a new country
	//that is not directly acessed, only by this
	//by using 'country' that is going to return a representation of my object
	//being initialized afterwards
	public Country build() {
		return new Country(this);
		}
	}
}

