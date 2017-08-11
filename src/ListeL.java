
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

		ElementL<I> temp = null;

		if (kopf == null || kopf.nach == null) {
			return;
		}
		ElementL<I> pos = kopf; // aktuell zu Untersuchendes Element.
		ElementL<I> postausch = kopf; // tauschposition
		ElementL<I> min = pos; // derzeitiges Minimum;

		while (postausch != null) {
			pos = postausch;
			while (pos != null) {
				if (pos.inhalt.compareTo(min.inhalt) < 0) {
					min = pos;
				}
				pos = pos.nach;
			}
			//System.out.println("Zu Tauschen: " + postausch.inhalt + " Minimum: " + min.inhalt);
			temp = postausch.nach;
			tauschen(postausch, min); // Hier muss postausch mit minimum getausch werden!
			min = temp;
			postausch = temp;
		}
	}

	public void tauschen(ElementL<I> tausch, ElementL<I> minimum) {
		ElementL<I> temp1 = new ElementL<I>(tausch.inhalt);
		ElementL<I> temp2 = new ElementL<I>(minimum.inhalt);

		minimum.inhalt = temp1.inhalt;
		tausch.inhalt = temp2.inhalt;

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
		liste.insert(70);
		liste.insert(85);
		liste.insert(1997);
		liste.insert(88);
		liste.insert(0);
		liste.insert(1);
		liste.insert(19);
		liste.insert(5);
		liste.insert(10);

		System.out.println(liste);

		liste.selectionsSort();

		System.out.println(liste);
	}

}
