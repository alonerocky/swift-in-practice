public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return result;
        }
        trySplit(s, 0, new ArrayList<String>(), result);
        return result;
        
    }
    
    private void trySplit(String s, int index, ArrayList<String> ips, List<String> result) {
        if (index == s.length() && ips.size() == 4) {
            //got one valid split
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < ips.size(); i++) {
                sb.append(ips.get(i));
                if (i != ips.size() - 1) {
                    sb.append(".");
                }
            }
            result.add(sb.toString());
            return;
        } else if (index < s.length() && ips.size() < 4) {
            int len = Math.min(3, s.length() - index);
            for (int i = 1; i <= len; i++) {
                String ip = s.substring(index, index+i);
                if (isValidIp(ip)) {
                    ips.add(ip);
                    trySplit(s, index+i, ips, result);
                    ips.remove(ips.size()-1);
                }
            }
        }
    }
    
    public boolean isValidIp(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() == 1 ) {
            return s.charAt(0) >= '0' && s.charAt(0) <= '9';
        } else if (s.charAt(0) != '0') {
            try {
                int ip = Integer.parseInt(s);
                return ip >= 10 && ip <= 255;
            } catch(Exception e) {
                
            }
            
        }
        return false;
    }
