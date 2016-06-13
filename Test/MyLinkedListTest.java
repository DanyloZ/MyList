
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.danylo.myList.myLinkedList.MyLinkedList;
public class MyLinkedListTest {
    @Test
    public void testSize() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("A");
        list.add("B");
        list.remove(1);
        assertEquals(1, list.size());
    }

    @Test
    public void testAdd() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("c", list.get(2));
        assertEquals("g", list.get(6));
    }


    @Test
    public void testAdd0() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("b");
        list.add("a", 0);
        list.add("c");
        list.add("d");
        assertEquals("a", list.get(0));
    }

    @Test
    public void testAddN() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
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
        MyLinkedList<String> list = new MyLinkedList<>();
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
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.remove("d");
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("c", list.get(2));
        assertEquals("e", list.get(3));
        assertEquals(4, list.size());
        list.remove("a");
        assertEquals("b", list.get(0));
        assertEquals("c", list.get(1));
        assertEquals("e", list.get(2));
        assertEquals(3, list.size());

    }

    @Test
    public void testRemoveN() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.remove(1);
        assertEquals("a", list.get(0));
        assertEquals("c", list.get(1));
        list.remove(3);
        assertEquals("d", list.get(2));
        assertEquals(3, list.size());
        list.remove(0);
        assertEquals("c", list.get(0));
        list.remove(0);
        assertEquals("d", list.get(0));
        list.remove(0);
        assertEquals(0, list.size());
        MyLinkedList<String> list2 = new MyLinkedList<>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.remove(2);
        assertEquals("b", list2.get(1));
        assertEquals(2, list2.size());

    }

    @Test
    public void testIsEmpty() {
        MyLinkedList<String> list = new MyLinkedList<>();
        assertTrue(list.isEmpty());
        list.add("a");
        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testSet() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.set("1", 1);
        assertEquals("a", list.get(0));
        assertEquals("1", list.get(1));
        assertEquals("c", list.get(2));
        list.set("2", 2);
        assertEquals("2", list.get(2));
        assertEquals(3, list.size());
        list.set("0", 0);
        assertEquals("0", list.get(0));
    }

    @Test
    public void testContains() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        assertTrue(list.contains("a"));
        assertTrue(list.contains("b"));
        assertTrue(list.contains("c"));
        assertTrue(list.contains("d"));
        assertTrue(!list.contains("e"));
    }

    @Test
    public void testClear() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testIndexOf() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("b");
        assertEquals(0, list.indexOf("a"));
        assertEquals(1, list.indexOf("b"));
        MyLinkedList<String> list2 = new MyLinkedList<>();
        list2.add("a");
        assertEquals(0, list2.indexOf("a"));
        assertEquals(-1, list2.indexOf("b"));
        MyLinkedList<String> list3 = new MyLinkedList<>();
        assertEquals(-1, list3.indexOf("b"));
    }

    @Test
    public void testLastIndexOf() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("c");
        list.add("b");
        assertEquals(4, list.lastIndexOf("b"));
        assertEquals(2, list.lastIndexOf("a"));
    }

    @Test
    public void testEnlarge() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 110; i++) {
            list.add(i);
        }
        assertEquals(110, list.size());
        assertEquals(109, (int)list.get(109));
    }
}
