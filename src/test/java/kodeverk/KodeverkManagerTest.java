package kodeverk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * Kodeverk for tekster: kodeverditype innholder en map med (kode, Kodeverdi). På samme måte er det med kodeverdier for
 * tall. Hvordan bør strukturen være på et kodeverk på tekster som har språk? Samme struktur men med en map med (kode -
 * språk par, kodeverdi) <br>
 * Struktur i db? La KodeverdiTekst og KodeverdiTall generer?? Ellers: <br>
 * Varchar2 - type; Varchar2 - kode; Varchar2 - verdi, Varchar2 - spraak (type, kode og språk gir unikhet)
 */
public class KodeverkManagerTest {

	private KodeverkManager kodeverkManager;

	/*
	 * Kodeverdimanager innholder flere map med kodeverdier for hver enkelt kodeverditype. (Kodeverdityper kan være av
	 * forskjellige typer - med SELF-TYPE...)
	 */

	@Before
	public void before() {
		// Kodeverdier kodeverdier = KodeverdierString.builder().withKodeverdi("MVA", "MerverdiAvgift")
		// .withKodeverdi("KALLE", "KalleSystemet").build();

		KodeverdierInteger.builder().withKodeverdi("MAT", Integer.valueOf(12)).build();

		kodeverkManager = KodeverkManager
				.builder()
				// .withKodeverdier(Kodeverdityper.BEREGNINGSPROSENT,
				// KodeverdierInteger.builder().withKodeverdi("MVAPROSENT", 25).build())
				.withStringKodeverdier(
						Kodeverditype.KLIENTKONTEKST,
						KodeverdierString.builder().withKodeverdi("MVA", "MerverdiAvgift")
								.withKodeverdi("KALLE", "KalleSystemet") //
								.withKodeverdi("NISSE", "SystemNisse").build())
				.withIntegerKodeverdier(Kodeverditype.MVA_PROSENTER,
						KodeverdierInteger.builder().withKodeverdi("MAT", Integer.valueOf(12)).build()).build();
	}

	// @Test
	// public void skal_hente_kode_klientkontekst() {
	// kodeverkManager.hentKodeverdier(KodeverdierString.class, Kodetype.KLIENTKONTEKST);
	// }

	@Test
	public void skallInnhodleKodeMVA() {
		KodeverdierString klientkontekstKodeverdier = kodeverkManager.hentStringKodeverdier(Kodeverditype.KLIENTKONTEKST);

		assertTrue(klientkontekstKodeverdier.innholderKode("MVA"));
	}

	@Test
	public void skalInnholdeKodeSOFIEmedVerdi() {
		KodeverdiString kodeverdiMVA = kodeverkManager.hentStringKodeverdi(Kodeverditype.KLIENTKONTEKST, "MVA");

		assertEquals("MerverdiAvgift", kodeverdiMVA.verdi());
	}

	@Test
	public void skal_innholde_tallkode_MVA_prosent_for_mat() {
		KodeverdiInteger kodeverdiMatMVA = kodeverkManager.hentHeltallKodeverdi(Kodeverditype.MVA_PROSENTER, "MAT");

		assertNotNull(kodeverdiMatMVA);
		assertEquals(new Integer("12"), kodeverdiMatMVA.verdi());
	}

	@Test(expected = NoSuchElementException.class)
	public void skal_ikke_innholde_denne_kodetype() {
		kodeverkManager.hentHeltallKodeverdier("FINNES_IKKE");
	}

	// @Test
	// public void skal_vaere_en_sortert_liste_med_kontekst() {
	// KodeverdierString kodeverdierString = kodeverkManager.hentStringKodeverdier(Kodetype.KLIENTKONTEKST);
	// List<KodeverdiString> kodeverdiStrings = kodeverdierString.sorterteKodeverdier();
	//
	// assertEquals("SOFIE", kodeverdiStrings.get(0).kode());
	// assertEquals("MVA", kodeverdiStrings.get(1).kode());
	// assertEquals("SL", kodeverdiStrings.get(2).kode());
	// }

	// @Test
	// public void skallIkkeInnhodleKodeIKKE() {
	// Kodeverdier brukerkontekstKodeverdier = kodeverkManager.hentKodeverdier(Kodeverdityper.KLIENTKONTEKST);
	//
	// assertFalse(brukerkontekstKodeverdier.innholderKode("IKKE"));
	// }
	//
	// @Test
	// public void skallHaKodeverdiMVASinVerdi() {
	// Kodeverdier brukerkontekstKodeverdier = kodeverkManager.hentKodeverdier(Kodeverdityper.KLIENTKONTEKST);
	//
	// assertEquals("MerverdiAvgift", brukerkontekstKodeverdier.kodeverdi("MVA").verdi());
	// }
	//
	// @Test
	// public void skallHarKodeverdiMVA() {
	// Kodeverdier beregningsprosentKodeverdier = kodeverkManager.hentKodeverdier(Kodeverdityper.BEREGNINGSPROSENT);
	//
	// assertEquals(25, beregningsprosentKodeverdier.kodeverdi("MVA").verdi());
	// }
	//
	// @Test(expected = NoSuchElementException.class)
	// public void shouldThrowExceptionNoKodeverditype() {
	// kodeverkManager.hentKodeverdier(Kodeverdityper.FINNES_IKKE);
	// }
}
