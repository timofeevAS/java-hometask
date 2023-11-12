import org.example.MyStack;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Unit test for simple App.
 */
public class MainTest
{
    @Test
    public void testBasicStackOperations() {
        MyStack<Integer> myStack = new MyStack<>();

        // Checking empty method
        assertTrue(myStack.empty());

        // Add elements
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        // Checking not empty method
        assertFalse(myStack.empty());

        // Check methods peek and pop
        assertEquals(3, (int) myStack.peek());
        assertEquals(3, (int) myStack.pop());

        assertEquals(2, (int) myStack.peek());
        assertEquals(2, (int) myStack.pop());

        assertEquals(1, (int) myStack.peek());
        assertEquals(1, (int) myStack.pop());

        // Check for stack is empty after deleting
        assertTrue(myStack.empty());
    }
    @Test
    public void testSize() {
        MyStack<String> myStack = new MyStack<>();

        assertEquals(0, myStack.size());

        myStack.push("A");
        myStack.push("B");

        assertEquals(2, myStack.size());

        myStack.pop();

        assertEquals(1, myStack.size());
    }

    @Test
    public void testContains() {
        MyStack<Character> myStack = new MyStack<>();

        assertFalse(myStack.contains('X'));

        myStack.push('A');
        myStack.push('B');

        assertTrue(myStack.contains('A'));
        assertTrue(myStack.contains('B'));
        assertFalse(myStack.contains('C'));
    }

    @Test
    public void testRemove() {
        MyStack<Double> myStack = new MyStack<>();

        myStack.push(1.0);
        myStack.push(2.0);
        myStack.push(3.0);

        assertTrue(myStack.remove(2.0));

        assertEquals(2, myStack.size());

        assertEquals(myStack.indexOf(1.0),0);
        assertEquals(myStack.indexOf(3.0),1);
        assertEquals(myStack.indexOf(2.0),-1);

        assertFalse(myStack.contains(2.0));
    }

    @Test
    public void testIterable() {
        MyStack<Integer> myStack = new MyStack<>();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        StringBuilder result = new StringBuilder();
        for (int element : myStack) {
            result.append(element).append(" ");
        }

        assertEquals("1 2 3 ", result.toString());
    }

    @Test
    public void testSearch() {
        MyStack<String> myStack = new MyStack<>();

        myStack.push("A");
        myStack.push("B");
        myStack.push("C");

        assertEquals(3, myStack.search("A")); // Активно ищем элемент, он находится на вершине
        assertEquals(2, myStack.search("B"));
        assertEquals(1, myStack.search("C"));

        assertEquals(-1, myStack.search("D")); // Элемента "D" нет в стеке
    }

    @Test
    public void testLastIndexOf() {
        MyStack<Character> myStack = new MyStack<>();

        myStack.push('A');
        myStack.push('B');
        myStack.push('A');
        myStack.push('C');
        myStack.push('A');

        assertEquals(4, myStack.lastIndexOf('A')); // Последний 'A' находится в верхней части стека
        assertEquals(3, myStack.lastIndexOf('C'));
        assertEquals(2, myStack.lastIndexOf('A', 3)); // Поиск с учетом ограничения индекса
        assertEquals(0, myStack.lastIndexOf('A', 1)); // Поиск с учетом ограничения индекса
        assertEquals(-1, myStack.lastIndexOf('D')); // Элемента 'D' нет в стеке
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testElementAt() {
        MyStack<Integer> myStack = new MyStack<>();

        myStack.push(10);
        myStack.push(20);
        myStack.push(30);

        assertEquals(30, (int) myStack.elementAt(2));
        assertEquals(20, (int) myStack.elementAt(1));
        assertEquals(10, (int) myStack.elementAt(0));
        myStack.elementAt(5); // Test for exception without of range
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGet(){
        MyStack<Integer> myStack = new MyStack<>();

        myStack.push(10);
        myStack.push(20);
        myStack.push(30);

        assertEquals(30, (int) myStack.get(2));
        assertEquals(20, (int) myStack.get(1));
        assertEquals(10, (int) myStack.get(0));
        myStack.get(5); // Test for exception without of range
    }
    @Test
    public void testClear(){
        MyStack<Integer> myStack = new MyStack<>();

        for(int i = 0; i < 10000;i++){
            myStack.push(i);
        }

        assertFalse(myStack.empty());
        assertEquals(myStack.size(),10000);

        myStack.removeAllElements();
        assertTrue(myStack.empty());

    }

}