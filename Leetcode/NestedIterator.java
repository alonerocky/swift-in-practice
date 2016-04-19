**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        if (nestedList != null && nestedList.size() > 0) {
            for (int i = nestedList.size() - 1; i>= 0; i--) {
               NestedInteger one = nestedList.get(i);
                stack.push(one); 
            }
        }
    }

    @Override
    public Integer next() {
         
        //top is either one integer, or non-empty list
        NestedInteger top = stack.pop();
        return top.getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty() && !stack.peek().isInteger()) {
               NestedInteger top = stack.pop();
               List<NestedInteger> list = top.getList();
               if (list.size() > 0) {
                for (int i = list.size() - 1; i>= 0; i--) {
                    stack.push(list.get(i));
                }
            }
        }
        return !stack.isEmpty();
    }
}
