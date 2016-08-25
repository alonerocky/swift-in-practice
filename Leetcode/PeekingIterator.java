class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> internalIterator ;
    private boolean hasNext = false;
    private int top;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    internalIterator = iterator;
	    hasNext = iterator.hasNext();
	    if (hasNext) {
	        top = iterator.next();
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return top;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int result = top;
	    if (internalIterator.hasNext()) {
	        hasNext = true;
	        top = internalIterator.next();
	    } else {
	        hasNext = false;
	    }
	    return result;
	}

	@Override
	public boolean hasNext() {
	    return hasNext;
	}
}



class PeekingIterator implements Iterator<Integer> {
 
    private Integer peekElement;
    private Iterator<Integer> iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	     this.iterator = iterator;
	     peekElement = null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (peekElement == null) {
            peekElement = iterator.next();
        }
        return peekElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (peekElement == null) {
	        return iterator.next();
	    } else {
	        Integer temp = peekElement;
	        peekElement = null;
	        /*
	        if (iterator.hasNext()) {
	            peekElement = iterator.next();
	        }
	        */
	        return temp;
	    }
	}

	@Override
	public boolean hasNext() {
	     return peekElement != null || iterator.hasNext();
	}
}
