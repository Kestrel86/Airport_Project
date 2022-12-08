//
//  Name:   Valdez, Andrew
//  Project:   Project #5
//  Due:    12/9/22
//  Course: CS-2400-02-f22
//
//  Description:
//  Designed to define all methods in the Dictionary interface. 
//  Creates a hashmap that will be able to use the methods defined in this file by Map interface for the Dictionary interface. 
//

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class MapDictionary<K,V> implements DictionaryInterface<K, V>{

    Map<K,V> hm = new HashMap<>();
    
    public V add(K key, V value) {
        return hm.put(key, value);
    }

    public V remove(K key) {
        return hm.remove(key);
    }

    public V getValue(K key) {
        return hm.get(key);
    }

    public boolean contains(K key) {
        return hm.containsKey(key);
    }

    public Iterator<K> getKeyIterator() {
        return hm.keySet().iterator(); 
    }

    public Iterator<V> getValueIterator() {
        return hm.values().iterator(); 
    }

    public boolean isEmpty() {
        return hm.isEmpty();
    }

    public int getSize() {
        return hm.size();
    }

    public void clear() {
        hm.clear();   
    }
    
}
