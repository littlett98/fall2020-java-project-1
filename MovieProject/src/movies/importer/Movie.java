package movies.importer;

/**
 * A class to create a movie objects.
 */
public class Movie {
	private String releaseYear;
	private String name;
	private String runtime;
	private String source;
	
	/** Constructor method to create a new Movie
	 * @author Trevor McCubbin
	 * @param releaseYear A String representing the year that a movie was released.
	 * @param name A String representing the name of a movie.
	 * @param runtime A String representing the runtime of the movie (length in minutes).
	 * @param source A String representing the source of the file, in this case being kaggle.
	 */
	public Movie(String releaseYear, String name, String runtime, String source) {
		this.releaseYear = releaseYear;
		this.name = name;
		this.runtime = runtime;
		this.source = source;
	}
	
	/**
	 * This method gets and returns the value of the private variable releaseYear
	 * @author Trevor McCubbin
	 * @return Returns a String of the release year of the movie
	 */
	public String getReleaseYear() {
		return this.releaseYear;
	}
	
	/**
	 * This method gets and returns the value of the private variable name
	 * @author Trevor McCubbin
	 * @return Returns a String of the name of the movie
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * This method gets and returns the value of the private variable runtime
	 * @author Trevor McCubbin
	 * @return Returns a String of the runtime of the movie in minutes
	 */
	public String getRuntime() {
		return this.runtime;
	}
	
	/**
	 * This method gets and returns the value of the private variable source
	 * @author Trevor McCubbin
	 * @return Returns a String of the source of where the movie was created
	 */
	public String getSource() {
		return this.source;
	}
	
	/**
	 * Overrides the default toString method with a custom output for this movie
	 * @author Trevor McCubbin
	 * @return Returns a String representing this movie and all it's info
	 */
	@Override
	public String toString() {
		return this.getReleaseYear() + "\t" + getName() + "\t" + getRuntime() + "\t" + getSource();
	}
	
	/**
	 * Overrides the default equals method to calculate whether 2 object are identical or not
	 * @author Jessie Rambeloson
	 * @author Trevor McCubbin
	 * @return Returns a boolean representing whether both object are the same or not
	 */
	@Override
	public boolean equals(Object o) {
		// instance of operator powerpoint, if it isnt a movie should return false
		// 
		Movie m = (Movie)o;
		if (!(m instanceof Movie)) {
			return false;
		}
		if (getName().equals(m.getName()) && getReleaseYear().equals(m.getReleaseYear())){
			int m1Runtime = Integer.parseInt(getRuntime());
			int m2Runtime = Integer.parseInt(m.getRuntime());
			int difference = m2Runtime - m1Runtime;
			if (difference <= 5 && difference >= -5) {
				return true;
			}
		}
		return false;
	}
}
