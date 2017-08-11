
public class ListeL<I extends Comparable<I>> {

	static class ElementL<K> { // innere Klasse
		private K inhalt; // Inhalt des Listenelements
		private ElementL<K> nach; // Verweis auf den Nachfolger

		public ElementL(K o) {
			inhalt = o;
		}
	}

	private ElementL<I> kopf; // Referenz auf den Anfang der Liste

	public void selectionsSort() { // Methode für den Selectionssort
		if (kopf == null || kopf.nach == null) {
			return;
		}
		ElementL<I> pos = kopf; // aktuell zu Untersuchendes Element.
		ElementL<I> postausch = kopf; // tauschposition
		ElementL<I> min = pos; // derzeitiges Minimum;

		while (postausch != null) {
			System.out.println("Tauschobjekt: " + postausch.inhalt.toString());
			pos = postausch;
			while (pos != null) {
				if (pos.inhalt.compareTo(min.inhalt) < 0) {
					min = pos;
				}
				System.out
						.println("Minimum: " + min.inhalt.toString() + " Momentane Position: " + pos.inhalt.toString());
				pos = pos.nach;
			}
			pos = postausch;
			postausch = postausch.nach;
		}
	}

	public void insert(I o) {
		ElementL<I> neuElement = new ElementL<I>(o);
		if (kopf == null) {
			kopf = neuElement;
		} else {
			neuElement.nach = kopf;
			kopf = neuElement;
		}
	}

	public String toString() {
		String ausgabe = "";
		ElementL<I> temp1 = kopf;
		while (temp1 != null) {
			ausgabe = ausgabe + " " + temp1.inhalt.toString();
			temp1 = temp1.nach;
		}

		return ausgabe;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListeL<Integer> liste = new ListeL<Integer>();
		liste.insert(1);
		liste.insert(1993);
		liste.insert(1997);
		liste.insert(2005);
		liste.insert(1998);
		liste.insert(2000);
		liste.insert(8);
		liste.insert(18);
		liste.insert(10);

		liste.selectionsSort();

		System.out.println(liste);
	}

}