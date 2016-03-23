public static String simplifyPath(String path) {
        StringBuffer sb = new StringBuffer();
        if (path == null || path.length() == 0) {
            return "/";
        }
        String[] paths = path.split("/");
        ArrayList<String> stack = new ArrayList<String>();
        for (int i =0 ; i < paths.length; i++) {
            String one = paths[i];
            if (one.equals(".")) {
                //do nothing
            } else if (one.equals("..")) {
                if (stack.size() > 0) {
                    stack.remove(stack.size() - 1);
                }
            } else if (one.length() > 0){
                stack.add(one);
            }
        }
        sb.append("/");
        for (int i = 0; i < stack.size(); i++ ) {
            sb.append(stack.get(i));
            if (i != stack.size() - 1) {
                sb.append("/");
            }
        }
        return sb.toString();
    }
