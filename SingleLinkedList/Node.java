/**
 * Class - Node
 * 
 * @author Kevin Hubbard
 * 
 * This Node class is a data structure that contains a data item and 
 * one or more links. A link is a reference to a node and the data item
 * is of type E
 **/

public class Node<E> {
	// Data Fields
	/** Data is the object to be stored*/
	public E data;
	/** Next is the link to the next data item in the list*/
	public Node<E> next;

	// Constructors
	/** Creates a new Node with null next field
	 * @param dataItem The data stored
	 **/
	public Node(E dataItem) {
		data = dataItem;
		next = null;
	}

	/** Creates a new node that references another node
	 * @param dataItem The data stored
	 * @param nodeRef The node referenced by the new node
	 **/
	public Node(E dataItem, Node<E> nodeRef) {
		data = dataItem;
		next = nodeRef;
	}
}