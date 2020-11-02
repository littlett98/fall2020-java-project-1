package movies.tests;

import static org.junit.jupiter.api.Assertions.*;
import movies.importer.Movie;

import org.junit.jupiter.api.Test;

class MovieTests {

	@Test
	void testGetMethods() {
		Movie m = new Movie("1994", "The Lion King", "1h 58m", "The Internet");
		assertEquals("1994", m.getReleaseYear());
		assertEquals("The Lion King", m.getMovieName());
		assertEquals("1h 58m", m.getRuntime());
		assertEquals("The Internet", m.getSource());
	}
	
	@Test
	void testToStringMethod() {
		Movie m = new Movie("1994", "The Lion King", "1h 58m", "The Internet");
		assertEquals("1994	The Lion King	1h 58m	The Internet", m.toString());
	}

}
