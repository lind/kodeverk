package kodeverk;

import java.util.NoSuchElementException;

/**
 * Håndterer kodeverk. <br>
 * Begreper innenfor kodeverkhåndtering:
 * <nl>
 * <li>Kodeverdi - En kodeverdi som består av en kode og en verdi av en gitt type</li>
 * <li>Kodeverditype - En gruppering av kodeverdier som hører sammen</li>
 * <li>Kodeverdier - En samling med kodeverdier innenfor en gruppe</li>
 * </nl>
 * <br>
 * Kodeverdier bør brukes i så kort scope som mulig fordi kodeverdiene kan bli oppdatert hvis en cache KodeverkManager
 * brukes.
 */
public class KodeverkManager {

	private final KodeverdiAttributes kodeverdiAttributes = new KodeverdiAttributes();

	public KodeverkManager() {
		kodeverdiAttributes.putAttribute(KodeverdierMapString.class, new KodeverdierMapString());
		kodeverdiAttributes.putAttribute(KodeverdierMapInteger.class, new KodeverdierMapInteger());
	}

	// private final Map<String, Pair<Class, Kodeverdi>> map = new HashMap<String, Pair<Class, Kodeverdi>>();

	// protected Map<Kodeverdier, KodeverdierMap<ELEMENT_TYPE>> kodeverketMap = new HashMap<KodeverditypePair,
	// Kodeverdier>();
	//
	// protected Map<Kodeverdityper, Kodeverdier> kodeverkMap = new HashMap<Kodeverdityper, Kodeverdier>();

	public <ELEMENT_TYPE extends Kodeverdier<ELEMENT_TYPE, VERDI_TYPE>, VERDI_TYPE> Kodeverdier<ELEMENT_TYPE, VERDI_TYPE> hentKodeverdier(
			Class<ELEMENT_TYPE> elementType, String kodetype) {
		// KodeverdierMap<ELEMENT_TYPE> element = kodeverdiAttributes.getAttribute(elementType);
		return elementType.cast(kodeverdiAttributes.getAttribute(elementType));
	}

	public KodeverdierString hentStringKodeverdier(String kodetype) {
		KodeverdierMap<KodeverdierString> element = kodeverdiAttributes.getAttribute(KodeverdierMapString.class);
		return element.map.get(kodetype);
	}

	public KodeverdiString hentStringKodeverdi(String kodetype, String kode) {
		KodeverdierMap<KodeverdierString> element = kodeverdiAttributes.getAttribute(KodeverdierMapString.class);
		return (KodeverdiString) element.map.get(kodetype).kodeverdi(kode);
	}

	public KodeverdierInteger hentHeltallKodeverdier(String kodetype) {
		KodeverdierMap<KodeverdierInteger> element = kodeverdiAttributes.getAttribute(KodeverdierMapInteger.class);
		KodeverdierInteger kodeverdierInteger = element.map.get(kodetype);
		if (kodeverdierInteger == null) {
			throw new NoSuchElementException("Ingen kodetype " + kodetype + " finnes!");
		}
		return kodeverdierInteger;
	}

	public KodeverdiInteger hentHeltallKodeverdi(String kodetype, String kode) {
		KodeverdierMap<KodeverdierInteger> element = kodeverdiAttributes.getAttribute(KodeverdierMapInteger.class);
		return (KodeverdiInteger) element.map.get(kodetype).kodeverdi(kode);
	}

	/**
	 * Returner en konkret kodeverdi for typen
	 */
	// hentKodeverdi(type, kode)

	// public <ELEMENT_TYPE extends Kodeverdier<ELEMENT_TYPE, VERDI_TYPE> Kodeverdier<ELEMENT_TYPE, VERDI_TYPE>
	// hentKodeverdier(Class<VERDI_TYPE> type Class<VERDI_TYPE> type,
	// Kodeverdier kodeverdier = kodeverkMap.get(klientkontekst);
	// Kodeverdityper klientkontekst) {
	// if (null == kodeverdier) {
	// throw new NoSuchElementException(klientkontekst.name());
	// }
	// return kodeverdier;
	// }

	public static KodeverkManagerBuilder builder() {
		return new KodeverkManagerBuilder();
	}

	public static class KodeverkManagerBuilder {
		KodeverkManager kodeverkManager;

		public KodeverkManagerBuilder() {
			kodeverkManager = new KodeverkManager();
		}

		public KodeverkManagerBuilder withStringKodeverdier(String kodetype, KodeverdierString kodeverdierString) {
			kodeverkManager.kodeverdiAttributes.getAttribute(KodeverdierMapString.class).map.put(kodetype,
					kodeverdierString);
			return this;
		}

		public KodeverkManager build() {
			return kodeverkManager;
		}

		public KodeverkManagerBuilder withIntegerKodeverdier(String kodetype, KodeverdierInteger kodeverdierInteger) {
			kodeverkManager.kodeverdiAttributes.getAttribute(KodeverdierMapInteger.class).map.put(kodetype,
					kodeverdierInteger);
			return this;
		}
	}

}