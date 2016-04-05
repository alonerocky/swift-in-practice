/*
    http://www.programcreek.com/2014/03/leetcode-gas-station-java/
    Analysis

To solve this problem, we need to understand and use the following 2 facts:
1) if the sum of gas >= the sum of cost, then the circle can be completed.
2) if A can not reach C in a the sequence of A-->B-->C, then B can not make it either.

Proof of fact 2:

If gas[A] < cost[A], then A can not even reach B. 
So to reach C from A, gas[A] must >= cost[A]. 
Given that A can not reach C, we have gas[A] + gas[B] < cost[A] + cost[B],
and gas[A] >= cost[A],
Therefore, gas[B] < cost[B], i.e., B can not reach C. 

    */
    public int canCompleteCircuitI(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < gas.length; ) {
            
            int remaining = 0;
            int j = 0;
            for (; j < gas.length; j++) {
                int current = (i + j ) % len;
                remaining += gas[current];
                if (remaining < cost[current]) {
                    break;
                } else {
                    remaining -= cost[current];
                }
            }
            if (j == len) {
                return i;
            } else {
                i += j + 1;
            }
        }
        return -1;
    }
    
    public int canCompleteCircuit(int[] gas, int[] cost)  {
        int remaining = 0;
        int total = 0;
        int len = gas.length;
        int start = 0;
        for (int i = 0; i < len; i++) {
            int refill = gas[i] - cost[i];
            if (remaining < 0) {
                remaining = refill;
                start = i;
            } else {
                remaining += refill;
            }
            total += refill;
        }
        if (total >= 0) {
            return start;
        } else {
            return -1;
        }
    }
