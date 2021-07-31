package Stack;

public interface List {

		static final int default_capacity = 5;
		static final int default_index = -1;
		static final int load_factor = 3;
		
		boolean push(int i);
		
		int pop();
		
		int peek();
		
		int size();
		
		boolean isEmpty();
		
}
