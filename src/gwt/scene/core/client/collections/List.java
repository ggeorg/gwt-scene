package gwt.scene.core.client.collections;

public interface List<E> {

	E get(int index);
	
	<T extends List<E>> T push(E element);
	
	E update(int index, E element);
	
	E remove(int index);
	
	int getLength();
}
