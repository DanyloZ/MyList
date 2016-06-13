import org.junit.Test;
import com.danylo.myList.myArrayList.MyArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyArrayListTest {

    @Test
    public void testSize() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        list.remove(1);
        assertEquals(1, list.size());
    }

    @Test
    public void testAdd() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("c", list.get(2));
    }

    @Test
    public void testAddN() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("1", 1);
        list.add("3", 3);
        assertEquals("a", list.get(0));
        assertEquals("1", list.get(1));
        assertEquals("b", list.get(2));
        assertEquals("3", list.get(3));
        assertEquals("c", list.get(4));
    }

    @Test
    public void testGet() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        boolean check1 = "a".equals(list.get(0));
        boolean check2 = "b".equals(list.get(1));
        boolean check3 = "c".equals(list.get(2));
        assertTrue(check1);
        assertTrue(check2);
        assertTrue(check3);
    }

    @Test
    public void testRemove() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.remove("b");
        assertEquals("a", list.get(0));
        assertEquals("c", list.get(1));
    }

    @Test
    public void testRemoveN() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.remove(1);
        assertEquals("a", list.get(0));
        assertEquals("c", list.get(1));
    }

    @Test
    public void testIsEmpty() {
        MyArrayList<String> list = new MyArrayList<>();
        assertTrue(list.isEmpty());
        list.add("a");
        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testSet() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.set("1", 1);
        assertEquals("a", list.get(0));
        assertEquals("1", list.get(1));
        assertEquals("c", list.get(2));
    }

    @Test
    public void testContains() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        assertTrue(list.contains("a"));
        assertTrue(!list.contains("e"));
    }

    public void testClear() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testIndexOf() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("b");
        assertEquals(1, list.indexOf("b"));
    }

    @Test
    public void testLastIndexOf() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("b");
        assertEquals(3, list.lastIndexOf("b"));
    }

    @Test
    public void testEnlarge() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 110; i++) {
            list.add(i);
        }
        assertEquals(110, list.size());
        assertEquals(109, (int)list.get(109));
    }
}
