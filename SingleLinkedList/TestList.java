public class TestList {
	public static void main(String[] args) {
		Node<String> kevin = new Node("kevin");
		Node<String> brian = new Node("Brian");
		Node<String> eric = new Node("Eric");
		Node<String> fuck = new Node("fuck");
		SingleLinkedList sll = new SingleLinkedList();
		sll.add(kevin);
		sll.add(brian);
		sll.add(eric);
		sll.add(fuck);
		System.out.println(sll.toString());
		System.out.println(sll.indexOf(kevin));
		//System.out.println(sll.indexOf(eric));
		System.out.println(sll.size());
		System.out.println(sll.indexOf(eric));
		System.out.println(sll.indexOf(fuck));
	}
}