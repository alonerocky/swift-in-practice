public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        String[] nodes = preorder.split(",");
        ArrayList<String> stack = new ArrayList<String>();
        for (int i = 0; i < nodes.length; i++) {
            String node = nodes[i];
            if (node.equals("#")) {
                
                stack.add(node);
                //like   number, #,#, that means it is one valid node, both children are leaves, 
                //we replace it with #
                while(stack.size() >= 3 && 
                stack.get(stack.size()-1).equals("#") &&
                stack.get(stack.size()-2).equals("#") &&
                !stack.get(stack.size()-3).equals("#")) {
                    stack.remove(stack.size()-1); //keep removing last one
                    stack.remove(stack.size()-1); //keep removing last one
                    stack.remove(stack.size()-1); //keep removing last one
                    stack.add("#");
                }
                
            } else if (node.length() > 0) { //not white space,  if there is white space, means input are invalid,  like , 1,,3
                stack.add(node);
            }
            
        }
        return stack.size() == 1 && stack.get(0).equals("#");
    }
