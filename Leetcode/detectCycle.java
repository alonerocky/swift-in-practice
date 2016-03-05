public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode doubleSteps = head;
        ListNode singleStep = head;
        boolean hasCycle = false;
        /*
            before the start of the cycle we have L nodes
            the cycle has M nodes
            when the singleStep meet doubleSteps , we pass N nodes from the start of the cycle
            and doubleSteps pass K circles and N nodes
            so we have
            2 * (L + N) = L + K * M + N  -->
            L + N = K * M  -->
            L = (K - 1) * M + (M - N)
            this means when singleStep (starting from head) reach start of the cycle, and the other
            pointer (N nodes starting from start of cycle, and (M - N) nodes to reach the start again 
            
        */
        while (doubleSteps != null && doubleSteps.next != null) {
            doubleSteps = doubleSteps.next.next;
            singleStep = singleStep.next;
            if (singleStep == doubleSteps) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            singleStep = head;
            while (singleStep != doubleSteps) {
                singleStep = singleStep.next;
                doubleSteps = doubleSteps.next;
            }
            return singleStep;
        } else {
            return null;
        }
    }
