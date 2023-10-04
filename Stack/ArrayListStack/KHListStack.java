/** 
 * Class KHListStack
 * @author Kevin Hubbard
 * 
 * Class KHListStack<E> implements the interface KHStackInt<E> as 
 * an adapter to the list.
 * @param <E> The type of elements in the stack
 **/
import java.util.*;

public class KHListStack<E> implements KHStackInt<E> {
	// The list containing the data
	private List<E> theData;

	// COnstruct an empty stack using an arraylist as the container
	public KHListStack() {
		theData = new ArrayList<>();
	}

	/** push
	 * push an object onto the stack
	 * @post The object is at the top of the stack
	 * @param obj The object to be pushed
	 * @return the object pushed
	 **/
	@Override
	public E push(E obj) {
		theData.add(obj);
		return obj;
	}

	/** peek
	 * peek at the top object on the stack
	 * @return The top object on the stack
	 * @throws NoSuchElementException if the stack is empty
	 **/
	@Override
	public E peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return theData.get(theData.size() - 1);
	}

	/** pop
	 * pop the top object off the stack
	 * @post The object at the top of the stack is removed
	 * @return The top object, which is removed
	 * @throws NoSuchElementException if the stack is empty
	 **/
	@Override
	public E pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return theData.remove(theData.size() - 1);
	}

	/** isEmpty
	 * see whether the stack is empty
	 * @return true if stack is empty
	 **/
	@Override
	public boolean isEmpty() {
		return theData.isEmpty();
	}
}