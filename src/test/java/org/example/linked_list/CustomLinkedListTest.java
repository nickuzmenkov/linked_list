package org.example.linked_list;

import junit.framework.TestCase;

import java.util.UUID;

import static org.junit.Assert.assertThrows;

public class CustomLinkedListTest extends TestCase {

    public void testSize() {
        CustomList<String> customLinkedList = new CustomLinkedList<>();

        assertEquals(0, customLinkedList.size());

        customLinkedList.add(UUID.randomUUID().toString());
        assertEquals(1, customLinkedList.size());
    }

    public void testIsEmpty() {
        CustomList<String> customLinkedList = new CustomLinkedList<>();

        assertTrue(customLinkedList.isEmpty());

        customLinkedList.add(UUID.randomUUID().toString());
        assertFalse(customLinkedList.isEmpty());
    }

    public void testContains() {
        CustomList<String> customLinkedList = new CustomLinkedList<>();
        String value = UUID.randomUUID().toString();

        assertFalse(customLinkedList.contains(value));

        customLinkedList.add(UUID.randomUUID().toString());
        assertFalse(customLinkedList.contains(value));

        customLinkedList.add(value);
        assertTrue(customLinkedList.contains(value));
    }

    public void testAddToHead() {
        CustomList<String> customLinkedList = new CustomLinkedList<>();
        String value = UUID.randomUUID().toString();
        String newValue = UUID.randomUUID().toString();

        customLinkedList.add(value);
        customLinkedList.add(0, newValue);

        assertEquals(customLinkedList.get(0), newValue);
        assertEquals(customLinkedList.get(1), value);
    }

    public void testAddToTail() {
        CustomList<String> customLinkedList = new CustomLinkedList<>();
        String value = UUID.randomUUID().toString();
        String newValue = UUID.randomUUID().toString();

        customLinkedList.add(value);
        customLinkedList.add(1, newValue);

        assertEquals(customLinkedList.get(0), value);
        assertEquals(customLinkedList.get(1), newValue);
    }

    public void testAddWithIndexIndexOutOfBounds() {
        CustomList<String> customLinkedList = new CustomLinkedList<>();
        String value = UUID.randomUUID().toString();

        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.add(-1, value));
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.add(1, value));
    }

    public void testRemoveFromHead() {
        CustomList<String> customLinkedList = new CustomLinkedList<>();
        String valueHead = UUID.randomUUID().toString();
        String valueTail = UUID.randomUUID().toString();

        customLinkedList.add(valueHead);
        customLinkedList.add(valueTail);
        assertEquals(valueHead, customLinkedList.remove(0));
        assertFalse(customLinkedList.contains(valueHead));
    }

    public void testRemoveFromTail() {
        CustomList<String> customLinkedList = new CustomLinkedList<>();
        String valueHead = UUID.randomUUID().toString();
        String valueTail = UUID.randomUUID().toString();

        customLinkedList.add(valueHead);
        customLinkedList.add(valueTail);
        assertEquals(valueTail, customLinkedList.remove(1));
        assertFalse(customLinkedList.contains(valueTail));
    }

    public void testRemoveByIndexOutOfBounds() {
        CustomList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(UUID.randomUUID().toString());

        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.remove(1));
    }

    public void testRemoveByValue() {
        CustomList<String> customLinkedList = new CustomLinkedList<>();
        String value = UUID.randomUUID().toString();

        assertFalse(customLinkedList.remove(value));

        customLinkedList.add(UUID.randomUUID().toString());
        assertFalse(customLinkedList.remove(value));

        customLinkedList.add(value);
        assertTrue(customLinkedList.remove(value));
        assertFalse(customLinkedList.contains(value));
    }

    public void testGet() {
        String value = UUID.randomUUID().toString();
        CustomList<String> customLinkedList = new CustomLinkedList<>();

        customLinkedList.add(value);
        assertEquals(value, customLinkedList.get(0));
    }

    public void testGetIndexOutOfBounds() {
        CustomList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(UUID.randomUUID().toString());

        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.get(1));
    }

    public void testSet() {
        CustomList<String> customLinkedList = new CustomLinkedList<>();
        String value = UUID.randomUUID().toString();
        String newValue = UUID.randomUUID().toString();

        customLinkedList.add(value);
        assertEquals(value, customLinkedList.set(0, newValue));
        assertEquals(newValue, customLinkedList.get(0));
    }

    public void testSetIndexOutOfBounds() {
        CustomList<String> customLinkedList = new CustomLinkedList<>();
        String value = UUID.randomUUID().toString();

        customLinkedList.add(value);
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.set(-1, value));
        assertThrows(IndexOutOfBoundsException.class, () -> customLinkedList.set(1, value));
    }

    public void testClear() {
        CustomList<String> customLinkedList = new CustomLinkedList<>();

        customLinkedList.add(UUID.randomUUID().toString());
        customLinkedList.clear();
        assertTrue(customLinkedList.isEmpty());
    }
}