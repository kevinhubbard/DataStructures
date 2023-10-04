/** 
 * Class - KHStackInt
 * A Stack is a data structure in which objects are inserted into
 * and reomoved from the same end (i.e., Last0IN, First-Out).
 * @param <E> The element type 
 * @author Kevin Hubbard
 **/

public interface KHStackInt<E> {
	/** push
	 * Pushes an item onto the top of the stack and returns
	 * the item pushed.
	 * @param obj The object to be inserted
	 * @return The object inserted
	 **/
	E push(E obj);

	/** peek
	 * Returns the object at the top of the stack 
	 * without removing it.
	 * @post The stack remains unchanged
	 * @return The object at the top of the stack
	 * @throws NoSuchElementException
	 **/
	E peek();

	/** pop
	 * Returns the object at the top of the stack
	 * and removes it.
	 * @post the stack is one item smaller
	 * @return The object at the top of the stack
	 * @throws NoSuchElementException if stack is empty
	 **/
	E pop();

	/** isEmpty
	 * Returns true if the stack is empty; otherwise, returns false
	 * @return true if the stack is empty, false if its not empty
	 **/
	boolean isEmpty();
}