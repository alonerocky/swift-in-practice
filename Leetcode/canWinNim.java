/*
    [1,2,3]  Nim win
    [4]  Nim lose
    [5,6,7] , Nim can take 1-3, become it to [4], Nim win
    [8], no matter Nim take home many, it will become [5,6,7]. so Nim lose
    */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
