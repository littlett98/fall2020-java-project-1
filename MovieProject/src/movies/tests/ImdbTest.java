/**
 * This class was written by
 * @author Jessie Rambeloson
 */
package movies.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import movies.importer.ImdbImporter;

class ImdbTest {

	@Test
	void testProcess() {
		ArrayList<String> input = new ArrayList<String>();
		String l1 = "tt0000009\tMiss Jerry\tMiss Jerry\t1894\t1894-10-09\tRomance\t45\tUSA\tNone\tAlexander Black\tAlexander Black\tAlexander Black Photoplays\t\"Blanche Bayliss, William Courtenay, Chauncey Depew\"\tThe adventures of a female reporter in the 1890s.\t5.9\t154\t1\t2";
		String l2 = "tt0000574\tThe Story of the Kelly Gang\tThe Story of the Kelly Gang\t1906\t12/26/1906\t\"Biography, Crime, Drama\"\t70\tAustralia\tNone\tCharles Tait\tCharles Tait\tJ. and N. Tait\t\"Elizabeth Tait, John Tait, Norman Campbell, Bella Cola, Will Coyne, Sam Crewes, Jack Ennis, John Forde, Vera Linden, Mr. Marshall, Mr. McKenzie, Frank Mills, Ollie Wilson\"\tTrue story of notorious Australian outlaw Ned Kelly (1855-80).\t6.1\t589\t\"$2,250 \"\t7\t7";
		
		input.add(l1);
		input.add(l2);
		
		ImdbImporter importer = new ImdbImporter("source", "destination");
		input = importer.process(input);
	}
}
