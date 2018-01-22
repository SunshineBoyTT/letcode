/**
 * 
 */
package cn.failfast;

import java.io.Serializable;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @Description:
 * @author zhengjuntao@hjtechcn.cn
 * @Since:2017年9月6日
 * @Version:1.1.0
 */
public class Stack implements Serializable{
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	private Object[] elements;
	private int size = 0;
	private String name;
	public Stack(String name) {
		this.name=name;
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

//	public static void main(String[] args) {
//		
//	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		return elements[--size];
	}

	/**
	 * Ensure space for at least one more element, roughly doubling the capacity
	 * each time the array needs to grow.
	 */
	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
