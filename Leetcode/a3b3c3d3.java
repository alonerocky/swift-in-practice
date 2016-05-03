public List<List<Integer>> ramanujan(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 0) {
            return result;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int sum = i*i*i + j*j*j;
                if (map.containsKey(sum)) {
                    ArrayList<Integer> left = map.get(sum);
                    ArrayList<Integer> oneResult = new ArrayList<>();
                    oneResult.add(left.get(0));
                    oneResult.add(left.get(1));
                    oneResult.add(i);
                    oneResult.add(j);
                    result.add(oneResult);
                } else {
                    ArrayList<Integer> sumValue = new ArrayList<Integer>();
                    sumValue.add(i);
                    sumValue.add(j);
                    map.put(sum, sumValue);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> ramanujanII(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 0) {
            return result;
        }

        for (int a = 1; a < n; a++) {
            long a3 = a * a * a;
            for (int b = a + 1; b < n; b++) {
                long b3 = b * b * b;
                for (int c = a+1; c < n; c++) {
                    long c3 = c * c * c;
                    for (int d = c + 1; d < n; d++) {
                        long d3 = d * d * d;
                        if (a3 + b3 == c3 + d3) {
                            ArrayList<Integer> oneResult = new ArrayList<>();
                            oneResult.add(a);
                            oneResult.add(b);
                            oneResult.add(c);
                            oneResult.add(d);
                            result.add(oneResult);
                        }
                    }
                }
            }
        }
        return result;
    }
