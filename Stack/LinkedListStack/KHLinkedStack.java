/** 
 * Class - KHLinkedStack
 * @author Kevin Hubbard
 * 
 * Class to implement interface KHStackInt<E> as a linked list
 **/
import java.util.*;

public class KHLinkedStack<E> implements KHStackInt<E> {
	//node inner class
	private static class Node<E> {
		//the data
		private E data;
		// next pointer
		private Node<E> next;

		// Constructors
		private Node(E dataItem) {
			data = dataItem;
			next = null;
		}

		private Node(E dataItem, Node<E> nodeRef) {
			data = dataItem;
			next = nodeRef;
		}
	}

	// Data fields
	// reference to first stack node
	private Node<E> topOfStackRef = null;

	/** push
	 * Insert a new item on top of the stack
	 * @post The new item is the top item on the stack
	 * @param obj The item to be inserted
	 * @return THe item that was inserted
	 **/
	@Override
	public E push(E obj) {
		topOfStackRef = new Node<>(obj, topOfStackRef);
		return obj;
	}

	/** pop
	 * Remove and return the top item on the stack
	 * @pre the stack is not empty
	 * @post the top item on the stack has been removed
	 * 		 and the stack is one item smaller
	 * @return The top item on the stack
	 * @throws NoSuchElementException if the stack is emptpy
	 **/
	@Override
	public E pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			E result = topOfStackRef.data;
			topOfStackRef = topOfStackRef.next;
			return result;
		}
	}

	/** peek
	 * Return the top item on the stack
	 * @pre The stack is not empty
	 * @post The stack remains unchanged
	 * @return The top item on the stack
	 * @throws NoSuchElementException if the stack is empty
	 **/
	@Override
	public E peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return topOfStackRef.data;
		}
	}

	/** isEmpty
	 * See whether the stack is empty
	 * @return true if the stack is empty
	 **/
	@Override
	public boolean isEmpty() {
		return topOfStackRef == null;
	}
}