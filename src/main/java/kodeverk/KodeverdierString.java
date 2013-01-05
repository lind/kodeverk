package kodeverk;


public class KodeverdierString extends Kodeverdier<KodeverdierString, String> {

	public static KodeverdierStringBuilder builder() {
		return new KodeverdierStringBuilder();
	}

	public static class KodeverdierStringBuilder {
		private final KodeverdierString kodeverdierString;

		public KodeverdierStringBuilder() {
			kodeverdierString = new KodeverdierString();
		}

		public KodeverdierStringBuilder withKodeverdi(String kode, String verdi) {
			kodeverdierString.leggTilKodeverdi(kode, new KodeverdiString(kode, verdi));
			return this;
		}

		public KodeverdierString build() {
			return kodeverdierString;
		}
	}

}
