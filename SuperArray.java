/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *****************************/

public class SuperArray {

		//~~~~~INSTANCE VARS~~~~~
		//underlying container, or "core" of this data structure:
    private int[] _data;

		//position of last meaningful value
    private int _lastPos;

		//size of this instance of SuperArray
	private int _size;

		
		//~~~~~METHODS~~~~~
    //default constructor â€“ initializes 10-item array
    public SuperArray() {
        _data = new int[10];
        _size = 0;
        _lastPos = 0;
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() { 
        String ret = "[";
        for(int x = 0; x<_size; x++) ret+=_data[x]+",";
        ret = ret.substring(0,ret.length()-1);
        return  ret + "]";
    }

		
    //double capacity of this SuperArray
    private void expand() {
        int[] temp = new int[_size*2];
        for (int x = 0; x<_size ; x++) temp[x] = get(x);
        _data = temp;
        _size*=2;
    }

		
    //accessor -- return value at specified index
    public int get( int index ) { 
        return _data[index];
    }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public int set( int index, int newVal ) { 
        int temp = _data[index];
        _data[index] = newVal;
        return temp;
    }


		//main method for testing
	public static void main( String[] args ) {
		SuperArray test = new SuperArray();
		test.set(3,5);
		System.out.println(test.get(3));
		test.expand();
		test.expand();
		test.expand();
		System.out.println(""+test);
	}//end main
		
}//end class