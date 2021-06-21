public enum DrawType {
    SCANDINAVIAN(35,7);

    private int playingNumbers;
    private int numberPool;

    DrawType(int playingNumbers, int numberPool) {
        this.playingNumbers = playingNumbers;
        this.numberPool = numberPool;
    }

    public int getPlayingNumbers() {
        return playingNumbers;
    }

    public int getNumberPool() {
        return numberPool;
    }
}
