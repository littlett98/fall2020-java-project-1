package movies.importer;

public class Movie {
	private String releaseYear;
	private String movieName;
	private String runtime;
	private String source;
	
	public Movie(String year, String name, String time, String src) {
		this.releaseYear = year;
		this.movieName = name;
		this.runtime = time;
		this.source = src;
	}
	
	public String getReleaseYear() {
		return releaseYear;
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public String getRuntime() {
		return runtime;
	}
	
	public String getSource() {
		return source;
	}
	
	public String toString() {
		return getReleaseYear() + "\t" + getMovieName() + "\t" + getRuntime() + "\t" + getSource();
	}
}