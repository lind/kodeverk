package kodeverk;

/**
 * Spr�kkoder. ISO-639-1 <br>
 * http://no.wikipedia.org/wiki/Liste_over_ISO_639-1-koder
 */
public enum Spraakkode {

	NB("Bokm�l"), NN("Nynorsk"), SE("Nordsamisk"), SV("Svensk");

	private final String beskrivelse;

	Spraakkode(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}
}
