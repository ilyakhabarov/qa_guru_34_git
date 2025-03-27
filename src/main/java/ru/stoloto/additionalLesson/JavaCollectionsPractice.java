package ru.stoloto.additionalLesson;

import java.util.*;

// Используем ArrayList и цикл for
class ArrayListExample {
    private List<Integer> list = new ArrayList<>();

    public void addElement(int element) {
        list.add(element);
    }

    public boolean findElement(int element) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == element) {
                return true;
            }
        }
        return false;
    }

    public void removeElement(int element) {
        list.remove(Integer.valueOf(element));
    }
}

// Используем LinkedList и цикл while
class LinkedListExample {
    private List<String> list = new LinkedList<>();

    public void addElement(String element) {
        list.add(element);
    }

    public boolean findElement(String element) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void removeElement(String element) {
        list.remove(element);
    }
}

// Используем HashSet и цикл do-while
class HashSetExample {
    private Set<Double> set = new HashSet<>();

    public void addElement(double element) {
        set.add(element);
    }

    public boolean findElement(double element) {
        Iterator<Double> iterator = set.iterator();
        if (!iterator.hasNext()) return false;
        do {
            if (iterator.next() == element) {
                return true;
            }
        } while (iterator.hasNext());
        return false;
    }

    public void removeElement(double element) {
        set.remove(element);
    }
}

// Используем HashMap и цикл for-each
class HashMapExample {
    private Map<Integer, String> map = new HashMap<>();

    public void addElement(int key, String value) {
        map.put(key, value);
    }

    public boolean findElement(int key) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() == key) {
                return true;
            }
        }
        return false;
    }

    public void removeElement(int key) {
        map.remove(key);
    }
}