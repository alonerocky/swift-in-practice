public String getHint(String secret, String guess) {
        if (secret == null || secret.length() == 0 || guess == null || guess.length() == 0) {
            return "";
        }
        int bulls = 0;
        int cows = 0;
        int[] map = new int[256];
        for (int i =0 ; i < secret.length() ;i++) {
            
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                if (map[secret.charAt(i)] < 0) {
                    cows++;
                }
                map[secret.charAt(i)]++;
                if (map[guess.charAt(i)] > 0) {
                    cows++;
                }
                map[guess.charAt(i)]--;
            }
        }
        return bulls+"A"+cows+"B";
    }
