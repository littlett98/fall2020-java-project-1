package movies.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import movies.importer.KaggleImporter;
import java.util.*;

class KaggleTests {

	@Test
	void testProcess() {
		ArrayList<String> input = new ArrayList<String>();
		input.add("Cast 1\tCast 2\tCast 3\tCast 4\tCast 5\tCast 6\tDescription\tDirector 1\tDirector 2\tDirector 3\tGenre\tRating\tRelease Date\tRuntime\tStudio\tTitle\tWriter 1\tWriter 2\tWriter 3\tWriter 4\tYear\r\n");
		input.add("Brendan Fraser\tJohn Hannah\tMaria Bello\tMichelle Yeoh\tJet Li\tRussell Wong\t\"The Fast and the Furious director Rob Cohen continues the tale set into motion by director Stephen Sommers with this globe-trotting adventure that finds explorer Rick O'Connell and son attempting to thwart a resurrected emperor's (Jet Li) plan to enslave the entire human race. It's been 2,000 years since China's merciless Emperor Han and his formidable army were entombed in terra cotta clay by a double-dealing sorceress (Michelle Yeoh), but now, after centuries in suspended animation, an ancient curse is about to be broken. Thanks to his childhood adventures alongside father Rick (Brendan Fraser) and mother Evelyn (Maria Bello), dashing young archeologist Alex O'Connell (Luke Ford) is more than familiar with the power of the supernatural. After he is tricked into awakening the dreaded emperor from his eternal slumber, however, the frightened young adventurer is forced to seek out the wisdom of his parents -- both of whom have had their fair share of experience battling the legions of the undead. Should the fierce monarch prove capable of awakening his powerful terra cotta army, his diabolical plan for world domination will finally be set into motion. Of course, the one factor that this emperor mummy failed to consider while solidifying his power-mad plans was the O'Connells, and before this battle is over, the monstrous monarch will be forced to contend with the one family that isn't frightened by a few rickety reanimated corpses. ~ Jason Buchanan, Rovi\"\tRob Cohen\tSimon Duggan\tDirector Not Available\tAction\tPG-13\t7/24/2008\t112 minutes\tUniversal Pictures\tThe Mummy: Tomb of the Dragon Emperor\tAlfred Gough\tMiles Millar\tWriter Not Available\tWriter Not Available\t2008");
		ArrayList<String> output = new ArrayList<String>();
		KaggleImporter k = new KaggleImporter("hello", "hey");
		output = k.process(input);
		assertEquals("2008\tThe Mummy: Tomb of the Dragon Emperor\t112 minutes\tkaggle", output.get(1));
	}
	// get source and get output maybe aka add to kaggle class and then test them here to make sure input and outputs are correct
	// test column number if it is smaller
	/*@Test(expected = ArrayIndexOutOfBoundsException.class)
	void testNotEnoughColumns() {
		ArrayList<String> input = new ArrayList<String>();
		input.add("Cast 1\tCast 2\tCast 3\tCast 4\tCast 5\tCast 6\tDescription\tDirector 1\tDirector 2\tDirector 3\tGenre\tRating\tRelease Date\tRuntime\tStudio\tTitle\tWriter 1\tWriter 2\tWriter 3\tWriter 4\tYear\r\n");
		input.add("Brendan Fraser\tJohn Hannah\tMaria Bello\tMichelle Yeoh\tJet Li\tRussell Wong\t\"The Fast and the Furious director Rob Cohen continues the tale set into motion by director Stephen Sommers with this globe-trotting adventure that finds explorer Rick O'Connell and son attempting to thwart a resurrected emperor's (Jet Li) plan to enslave the entire human race. It's been 2,000 years since China's merciless Emperor Han and his formidable army were entombed in terra cotta clay by a double-dealing sorceress (Michelle Yeoh), but now, after centuries in suspended animation, an ancient curse is about to be broken. Thanks to his childhood adventures alongside father Rick (Brendan Fraser) and mother Evelyn (Maria Bello), dashing young archeologist Alex O'Connell (Luke Ford) is more than familiar with the power of the supernatural. After he is tricked into awakening the dreaded emperor from his eternal slumber, however, the frightened young adventurer is forced to seek out the wisdom of his parents -- both of whom have had their fair share of experience battling the legions of the undead. Should the fierce monarch prove capable of awakening his powerful terra cotta army, his diabolical plan for world domination will finally be set into motion. Of course, the one factor that this emperor mummy failed to consider while solidifying his power-mad plans was the O'Connells, and before this battle is over, the monstrous monarch will be forced to contend with the one family that isn't frightened by a few rickety reanimated corpses. ~ Jason Buchanan, Rovi\"\tRob Cohen\tSimon Duggan\tDirector Not Available\tAction\tPG-13\t7/24/2008\t112 minutes\tUniversal Pictures\tThe Mummy: Tomb of the Dragon Emperor\tAlfred Gough\tMiles Millar\tWriter Not Available\tWriter Not Available");
		ArrayList<String> output = new ArrayList<String>();
		KaggleImporter k = new KaggleImporter("hello", "hey");
		output = k.process(input);
		assertEquals("ArrayIndexOutOfBoundsException", output.get(1));
	}*/
	// test individual strings
	// use movie object to test
}
