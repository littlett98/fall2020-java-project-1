package movies.importer;

public class Movie {
	private String releaseYear;
	private String name;
	private String runtime;
	private String source;
	
	public Movie(String releaseYear, String name, String runtime, String source) {
		this.releaseYear = releaseYear;
		this.name = name;
		this.runtime = runtime;
		this.source = source;
	}
	
	public String getReleaseYear() {
		return this.releaseYear;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getRuntime() {
		return this.runtime;
	}
	
	public String getSource() {
		return this.source;
	}
	
	@Override
	public String toString() {
		return this.getReleaseYear() + "\t" + getName() + "\t" + getRuntime() + "\t" + getSource();
	}
	
	@Override
	public boolean equals(Object o) {
		
		Movie m = (Movie)o;
		
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
