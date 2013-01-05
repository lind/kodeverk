package kodeverk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class Kodeverdier<ELEMENT_TYPE extends Kodeverdier<ELEMENT_TYPE, VERDI_TYPE>, VERDI_TYPE> {

	protected final Map<String, Kodeverdi<VERDI_TYPE>> kodeverdierMap = new HashMap<String, Kodeverdi<VERDI_TYPE>>();

	// @SuppressWarnings("unchecked")
	// protected final VERDI_TYPE self() {
	// return (VERDI_TYPE) this;
	// }

	public void leggTilKodeverdi(String kode, Kodeverdi<VERDI_TYPE> kodeverdi) {
		kodeverdierMap.put(kode, kodeverdi);
	}

	public Kodeverdi<VERDI_TYPE> kodeverdi(String kode) {
		Kodeverdi<VERDI_TYPE> kodeverdi = kodeverdierMap.get(kode);
		if (null == kodeverdi) {
			throw new NoSuchElementException("Ingen kodeverdi for kode:" + kode);
		}
		return kodeverdi;
	}

	public boolean innholderKode(String kode) {
		return kodeverdierMap.containsKey(kode);
	}

	public List<Kodeverdi<VERDI_TYPE>> sorterteKodeverdier() {
		// TODO Auto-generated method stub
		return null;
	}

}
