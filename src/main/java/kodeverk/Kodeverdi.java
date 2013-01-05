package kodeverk;

public class Kodeverdi<T> {

	private final String kode;
	private final T verdi;

	public Kodeverdi(String kode, T verdi) {
		this.kode = kode;
		this.verdi = verdi;
	}

	public String kode() {
		return kode;
	}

	public T verdi() {
		return verdi;
	}

}
