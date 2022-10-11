public enum PixelType {
    N0(new char[]{'.'}), N1(new char[]{'.','B'}), N2(new char[]{'.','G'}), N3(new char[]{'.','G','B'}),
    N4(new char[]{'.','R'}), N5(new char[]{'.','R','B'}), N6(new char[]{'.','R','G'}),
    N7(new char[]{'.','R','G','B'});

    private char[] colours;

    PixelType(char[] colours) {
        this.colours = colours;
    }

    public boolean checkColour(char colour){
        for (char iColour:colours) {
            if (iColour==colour) return true;
        }
        return false;
    }
}
