
public class ListeL <I extends Comparable<I>>{
	
	static class ElementL<K>{	// innere Klasse
		private K inhalt;	//  Inhalt des Listenelements
		private ElementL<K> nach;	// Verweis auf den Nachfolger
	}
	
	private ElementL<I> kopf;    // Referenz auf den Anfang der Liste
	
	public void selectionsSort() { // Methode für den Selectionssort
		if(kopf == null || kopf.nach == null) {
			return;
		}
		ElementL<I> pos = kopf; // aktuell zu Untersuchendes Element.
		
		while(pos != null) {
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
