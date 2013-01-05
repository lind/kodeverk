package kodeverk;

public class KodeverdierInteger extends Kodeverdier<KodeverdierInteger, Integer> {

	public static KodeverdierIntegerBuilder builder() {
		return new KodeverdierIntegerBuilder();
	}

	public static class KodeverdierIntegerBuilder {
		private final KodeverdierInteger kodeverdierInteger;

		public KodeverdierIntegerBuilder() {
			kodeverdierInteger = new KodeverdierInteger();
		}

		public KodeverdierIntegerBuilder withKodeverdi(String kode, Integer verdi) {
			kodeverdierInteger.leggTilKodeverdi(kode, new KodeverdiInteger(kode, verdi));
			return this;
		}

		public KodeverdierInteger build() {
			return kodeverdierInteger;
		}

	}

}
