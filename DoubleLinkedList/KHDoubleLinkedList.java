/**
 * Class - KHDoubleLinkedList
 * 
 * @author Kevin Hubbard
 * 
 * This class is the main class for the Double Linked List Data Structure
 * The node class is a nested inner class
 **/

public class KHDoubleLinkedList<E> {
	/** A Node is the building block for a double-linked list. */
	private static class Node<E> {
		// The data that the node contains
		private E data;
		// Links to next and previous nodes respectively.
		private Node<E> next = null;
		private Node<E> prev = null;

		// Constructors
		/** Construct a node with the given data value.
		 * @param dataItem The data object we want to store
		 **/
		private Node(E dataItem) {
			data = dataItem;
		}
	}

	/** Inner class to implement the ListIterator interface */
	private class KHListIter implements ListIterator<E> {
		// A reference to the next item
		private Node<E> nextItem;
		// A referece to the last item returned
		private Node<E> lastItemReturned;
		// The index of the current item
		private int index = 0;

		/** Construct a KHListIter that will reference the ith item 
		 * @param i the index of the item to be referenced
		 **/
		public KHListIter(int i) {
			// Validate i parameter
			if (i < 0 || i > size) {
				throw new IndexOutOfBoundsException("Invalid index " + i);
			}
			lastItemReturned = null; // No item returned yet
			// Special case of last item
			if (i == size) {
				index = size;
				nextItem = null;
			} else { // Start at beginning
				nextItem = head;
				for (index = 0; index < i; index++) {
					nextItem = nextItem.next;
				}
			}
		}

		/** hasNext
		 * Indicate whether movement forward is defined
		 * @return true if call to next will not throw an exception
		 **/
		public boolean hasNext() {
			return nextItem != null;
		}

		/** next
		 * Move the iterator forward and return the next item
		 * @return The next item in the list
		 * @throws NoSuchElementException if there is no such object
		 **/
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			lastItemReturned = nextItem;
			nextItem = nextItem.next;
			index++;
			return lastItemReturned.data;
		}

		/** hasPrevious
		 * Indicate whether movement backward is defined
		 * @return true if call to previous will not throw an exception
		 **/
		public boolean hasPrevious() {
			return (nextItem == null && size != 0) || nextItem.prev != null;
		}

		/** previous
		 * Move the iterator backward and return the previous item
		 * @return the previous item in the list
		 * @throws NoSUchElementException if there is no such object
		 **/
		public E previous() {
			if (!hasPrevious()) {
				throw new SoSuchElementException();
			}
			if (nextItem == null) { // Iterator is past last element
				nextItem = tail;
			} else {
				nextItem = nextItem.prev;
			}
			lastItemReturned = nextItem;
			index--;
			return lastItemReturned.data;
		}

		/** add
		 * Add a new item between the item that will be returned
		 * by next and the item that will be returned by previous.
		 * If previous is called after add, the element add is returned
		 * @param obj The item to be inserted 
		 **/
		public void add(E obj) {
			if (head == null) { // Add to an empty list
				head = new Node<>(obj);
				tail = head;
			} else if (nextItem == head) { // Insert at head
				// Create a new node
				Node<E> newNode = new Node<>(obj);
				// Link to next item
				newNode.next = nextItem;
				// Link nextItem to the new node
				nextItem.prev = newNode;
				// The new node is now the head
				head = newNode;
			} else if (nextItem == null) { // Insert at tail
				// Create a new node
				Node<E> newNode = new Node<>(obj);
				// Link tail to new node
				tail.next = newNode;
				// Link the new node to the tail
				newNode.prev = tail;
				// The new node is the new tail
				tail = newNode;
			} else { // Insert into the middle
				// Create new node
				Node<E> newNode = new Node<>(obj);
				// Link it to nextItem.prev
				newNode.prev = nextItem.prev;
				nextItem.prev.next = newNode;
				// Link to the nextItem
				newNode.next = nextItem;
				nextItem.prev = newNode;
			}
			// Increase size and index and set lastItemReturned
			size++;
			index++;
			lastItemReturned = null;
		}
	}

	// Linked List data fields
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;

	/** add
	 * Inserts object obj into the list at position index
	 * @param index the position
	 * @param obj the object to be added to list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 **/
	public void add(int index, E obj) {
		listIterator(index).add(obj);
	}

	/** addFirst
	 * Inserts objectobj as the first element of the list
	 * @param obj the obj to be inserted
	 **/
	public void addFirst(E obj) {

	}

	/** addLast
	 * Adds object obj to the end of the list
	 * @param obj the object to be added
	 **/
	public void addLast(E obj) {

	}

	/** get
	 * Returns the item at position index
	 * @param index index of item you want
	 * @return the object
	 **/
	public E get(int index) {
		return listIterator(index).next();
	}

	/** getFirst
	 * Gets the first element in the list. Throws NoSuchElementException
	 * if the list is empty
	 * @return the first element
	 **/
	public E getFirst() {

	}

	/** getLast
	 * Gets the last element in the list. Throws NoSuchElementException
	 * if the list is empty
	 * @return the last element
	 **/
	public E getLast() {

	}

	/** remove
	 * Removes the first occurance of object obj from the list.
	 * @param obj The object to be removed
	 * @return true if the list contained object obj; otherwise return false
	 **/
	public boolean remove(E obj) {

	}

	/** size
	 * Returns the number of objects contained in the list
	 * @return integer
	 **/
	public int size() {
		return size;
	}
}