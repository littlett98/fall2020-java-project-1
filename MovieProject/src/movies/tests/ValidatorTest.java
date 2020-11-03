package movies.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import movies.importer.Validator;

class ValidatorTest {

	@Test
	void testProcess() {
		Validator v = new Validator("idbms", "dest");
		String m1 = "1998\tMy neighbor Totoro\t90\tidbms";
		String m2 = " \tPonyo\t90\tidbms";
		ArrayList<String> list = new ArrayList<String>();
		list.add(m1);
		list.add(m2);
		v.process(list);
	}

}
