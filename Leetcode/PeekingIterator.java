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
