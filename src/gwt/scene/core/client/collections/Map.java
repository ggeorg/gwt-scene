package gwt.scene.core.client.collections;

public interface Map<K, V> {

	V get(K key) throws IllegalArgumentException;

	V get(K key, V defaultValue);
	
	<T extends Map<K, V>> T set(K key, V value);
	
	V remove(K key);
	
	boolean has(K key);

}
