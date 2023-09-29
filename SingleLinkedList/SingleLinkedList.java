/**
 * Class - Single Linked List
 * 
 * @author Kevin Hubbard
 * 
 * The Single Linked class is the basis for the linked list data structure 
 * by forming a link from each node to the next node.
 **/

public class SingleLinkedList<E> {
	/** Reference to the list head*/
	private Node<E> head = null;
	/** The number of items in the list*/
	private int size = 0;

	/** addFirst
	 * Add an object to the beginning of the list
	 * @param item The object to be inserted
	 **/
	public void addFirst(E item) {
		head = new Node<>(item, head);
		size++;
	}

	/** addAfter
	 * Add a node after a given node
	 * @param node The node before the node to be inserted
	 * @param item The item to insert
	 **/
	public void addAfter(Node<E> node, E item) {
		node.next = new Node<>(item, node.next);
		size++;
	}

	/** removeAfter
	 * Remove the node after a given node.
	 * @param node The node before the one to be removed
	 * @return The data from the removed node or null
	 * 			if there is no node to remove
	 **/
	private E removeAfter(Node<E> node) {
		Node<E> removed = node.next;
		if (removed != null) {
			node.next = removed.next;
			size--;
			return removed.data;
		} else {
			return null;
		}
	}

	/** removeFirst
	 * Remove the first node from the list
	 * @return The removed nodes data or null if 
	 * 			the list was empty
	 **/
	private E removeFirst() {
		Node<E> removed = head;
		if (head != null) {
			head = head.next;
		}
		// Return data at old head or null if list is empty
		if (removed != null) {
			size--;
			return removed.data;
		} else {
			return null;
		}
	}

	/** getNode
	 * Helper method used to return the node at a specified position
	 * @param index The position of the node we want
	 * @return The node at the index or null if it does not exist
	 **/
	private Node<E> getNode(int index) {
		Node<E> node = head;
		for (int i = 0; i < index && node != null; i++) {
			node = node.next;
		}
		return node;
	}

	/** get
	 * Get the data at an index
	 * @param index The position of the data to return
	 * @return The data at index
	 * @throws IndexOutOfBoundsException if index is out of range
	 **/
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> node = getNode(index);
		return node.data;
	}

	/** set
	 * Update a reference to an entry in the list at a certain position
	 * @param index The position of the item to change
	 * @param newValue The new data to be inserted
	 * @return The data previously at the index
	 * @throws IndexOutOfBoundsException if index is out of range
	 **/
	public E set(int index, E newValue) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> node = getNode(index);
		E result = node.data;
		node.data = newValue;
		return result;
	}

	/** add
	 * Insert the specified item at index
	 * @param index The position where item is to be inserted
	 * @param item The item to be inserted
	 * @throws IndexOutOfBoundsException if index is out of range
	 **/
	public void add(int index, E item) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if (index == 0) {
			addFirst(item);
		} else {
			Node<E> node = getNode(index-1);
			addAfter(node, item);
		}
	}

	/** add
	 * Append an item to the end of the list
	 * @param item The item to be appended
	 * @return true (as specified by the collection interface)
	 **/
	public boolean add(E item) {
		add(size, item);
		return true;
	}

	/** size
	 * Returns the size of the list 
	 * @return Current size
	 **/
	public int size() {
		return size;
	}

	/** indexOf
	 * Searches for target and returns the position of 
	 * the first occurrence, or -1 if it is not in the List
	 * @param target The object we are looking for
	 * @return The index of specified target
	 **/
	public int indexOf(E target) {
		for(int i = 0; i < size; i++) {
			if (get(i).equals(target)) {
				return i;
			}
		}
		return -1;
	}

	/** remove
	 * Removes the item at ehe specified position in the list
	 * @param index The index of the item to be removed
	 * @return The item the that was at the index
	 * @throws IndexOutOfBoundsException if the index is out of range
	 **/
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if (index == 0) {
			return removeFirst();
		} else {
			Node<E> node = getNode(index-1);
			return removeAfter(node);
		}
	}

	/** toString
	 * @return A string representation of the list
	 **/
	public String toString() {
		Node<E> nodeRef = head;
		StringBuilder result = new StringBuilder();
		while (nodeRef != null) {
			result.append(nodeRef.data);
			if (nodeRef.next != null) {
				result.append("==>");
			}
			nodeRef = nodeRef.next;
		}
		return result.toString();
	}
}