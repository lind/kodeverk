package kodeverk;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PairTest {

	@Test
	public void test() {
		Pair<String, Integer> strIntPair = Pair.of("h", Integer.valueOf(12));

		assertEquals("h", strIntPair.first);
		assertEquals(Integer.valueOf(12), strIntPair.second);
	}
}
