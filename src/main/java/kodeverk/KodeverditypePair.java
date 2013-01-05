package kodeverk;

//Brukes ikke.
public class KodeverditypePair<ELEMENT_TYPE> {
	public static final KodeverditypePair<KodeverdierString> KLIENTKONTEKST_KODEVERDITYPE_PAIR = new KodeverditypePair<KodeverdierString>(
			KodeverdierString.class, KodeverditypeIkkeIBruk.KLIENTKONTEKST);

	public KodeverditypePair(Class<ELEMENT_TYPE> type, KodeverditypeIkkeIBruk kodeverdityper) {
		this.kodeverdierType = type;
		this.kodeverdityper = kodeverdityper;
	}

	public KodeverditypeIkkeIBruk kodeverdityper;
	public Class<ELEMENT_TYPE> kodeverdierType;
}
