package Stack;

public class Stack implements List {

	private Integer arr[];
	private int currentCapacity;
	private int currentIndex;
	
	
	public Stack() {
		currentCapacity = default_capacity;
		arr = new Integer[currentCapacity];
		currentIndex = default_index;
	}

	@Override
	public synchronized boolean push(int i) {
		try {
			currentIndex++;
			if(currentIndex < currentCapacity-1) {
				arr[currentIndex] = i;
			}else {
				if(currentIndex == currentCapacity-1) {
					arr[currentIndex] = i;
					increaseArrayCapacity();
				}
			}

			
		} catch (Exception ae) {
			ae.printStackTrace();
			return false;
		}
		return true;

	}

	private void increaseArrayCapacity() {
		int newCapacity = (currentCapacity * load_factor)/2;
		currentCapacity = newCapacity;
		Integer[] arrNew = new Integer[newCapacity];
		
		for(int i = 0 ; i <= currentIndex ; i++) {
			arrNew[i] = arr[i];
		}
		arr = arrNew;	
	}

	@Override
	public synchronized int pop() {
		
		if(currentIndex < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		if(currentIndex >= currentCapacity) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		int result = peek();
		arr[currentIndex] = null;
		currentIndex -= 1;
		return result;
		
	}

	@Override
	public int peek() {
		return arr[currentIndex];
	}

	@Override
	public int size() {
		return currentIndex+1;
	}

	@Override
	public String toString() {
		String str = "[";
		int i = 0;
		for (; i < currentIndex; i++) {
			str += String.valueOf(arr[i])+" , ";
		}
		str +=String.valueOf(arr[i])+" ]";
		
		return str;
	}

	@Override
	public boolean isEmpty() {
		return (currentIndex == -1);
	}
	
	

}
