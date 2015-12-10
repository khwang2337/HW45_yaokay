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
    private Comparable[] _data;

		//position of last meaningful value
    private Comparable _lastPos;

		//size of this instance of SuperArray
	private Comparable _size;

		
		//~~~~~METHODS~~~~~
    //default constructor â€“ initializes 10-item array
    public SuperArray() {
        _data = new Comparable[10];
        _size = 0;
        _lastPos = -1;
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() { 
        String ret = "[";
        for(int x = 0; x<_size; x++) ret+=_data[x]+",";
        if(ret.length()>1) return ret.substring(0,ret.length()-1) + "]";
        else return ret + "]";
    }

		
    //double capacity of this SuperArray
    private void expand() {
        int[] temp = new Comparable[_size*2];
        for (int x = 0; x<_size ; x++) temp[x] = get(x);
        _data = temp;
    }

		
    //accessor -- return value at specified index
    public Comparable get( int index ) { 
        return _data[index];
    }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) { 
        int temp = _data[index];
        _data[index] = newVal;
        return temp;
    }
    
     // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add (Comparable newVal) {
        _lastPos+=1;
        _size+=1;
        if(_lastPos != _data.length) _data[_lastPos] = newVal;
        else { 
            expand();
            _data[_lastPos] = newVal; }
    }
    
    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) { 
        _size+=1;
        _lastPos+=1;
        if(_lastPos+1 == _data.length) expand();
        for (int x = _lastPos ; x>index ; x--) {
            _data[x] = _data[x-1]; }
        _data[index] = newVal;
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) { 
        _size -= 1;
        for (int i = index; i < _lastPos; i++) _data[i] = _data[i + 1];
        _data[_lastPos] = new Rational();
        _lastPos -= 1;
    }


    //return number of meaningful items in _data
    public int size() { 
        return _size;
    }
    
    public int linSearch(Comparable x) {
        for (int i = 0; i<_size ; i++) if(_data[i].equals(x)) return i;
        return -1;
    }
    
    public boolean isSorted() {
        for (int i = 0; i<_size-1 ; i++) {
            if(i!=0) {
                if(_data[i].compareTo(_data[i-1]) < 0) return false;
            }
        }
        return true;
    }
    

		//main method for testing
	public static void main( String[] args ) {
		SuperArray test = new SuperArray();

		System.out.println(test._size); // 0
		System.out.println(test._lastPos); // -1
		test.add(3);
		test.add(3);
		test.add(3);
		test.add(3,99);
		System.out.println(""+test); // [3,5,3,3]
		System.out.println(test._size); // 4
		System.out.println(test._lastPos); // 3
		test.remove(1);
		System.out.println(""+test); //[3,3,3]
		System.out.println(test._size); //3
		System.out.println(test._lastPos); //2

		
	}//end main
		
}//end class
