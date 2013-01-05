package kodeverk;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;

public class KodeverdierTest {

	@Test
	public void skalHoldeString() {
		KodeverdierString kodeverdier = KodeverdierString.builder().withKodeverdi("MVA", "MerverdiAvgift")
				.withKodeverdi("SOFIE", "SofieSystemet").build();

		assertEquals("SofieSystemet", kodeverdier.kodeverdi("SOFIE").verdi());
	}

	@Test
	public void skalHoldeInteger() {
		KodeverdierInteger kodeverdier = KodeverdierInteger.builder().withKodeverdi("MVAPROSENT", 25)
				.withKodeverdi("SOFIEPROSENT", 14).build();

		assertEquals(new Integer(14), kodeverdier.kodeverdi("SOFIEPROSENT").verdi());
	}

	@Test(expected = NoSuchElementException.class)
	public void skalKasteFeilVedFeilKodeverdi() {
		KodeverdierInteger kodeverdier = KodeverdierInteger.builder().withKodeverdi("MVAPROSENT", 25)
				.withKodeverdi("SOFIEPROSENT", 14).build();

		assertEquals(new Integer(14), kodeverdier.kodeverdi("FEILKODE").verdi());
	}

}
