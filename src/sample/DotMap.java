package sample;

class DotMap {

    private static final String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
            "l", "m", "n", "o", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static final int[] masCrutch = {7, 8, 9, 4, 5, 6, 1, 2, 3};

    private static final int bigSqua=400;
    private static final int smalSqua=40;

    private int coorWord;
    private int coorWord1;
    private int[] secondOrdinate = {0, 0};
    private Point lastsquare;


    DotMap(String strPos, Point pos) {
        this.lastsquare =pos;
        String[] allOrdinat = strPos.split("-");
        if (allOrdinat.length < 2) throw new NumberFormatException();

        for (int i = 0; i < abc.length; i++) {
            if (abc[i].equals(allOrdinat[0].substring(0, 1))) {
                this.coorWord = i;
                break;
            }
        }

        this.coorWord1 = Integer.parseInt(strPos.substring(1, 2));
        if (coorWord1 > 0) coorWord1 -= 1;

        String[] temp;
        if (allOrdinat[1].contains(",")) temp = allOrdinat[1].split(",");
        else if (allOrdinat[1].contains(".")) temp = allOrdinat[1].split("[.]");
        else throw new NumberFormatException();
        this.secondOrdinate[0] = Integer.parseInt(temp[0]);
        this.secondOrdinate[1] = Integer.parseInt(temp[1]);
//        this.secondOrdinate[0] = masCrutch[Integer.parseInt(allOrdinat[1]) - 1];

    }

    private int[] cubetoOrdinate(int[] inputMas) {
        if (inputMas[0] % 3 == 0) return new int[]{3, inputMas[0] / 3};
        else return new int[]{inputMas[0] % 3, inputMas[0] / 3 + 1};
    }

    // -1 нужен для того чтобы при квадрантыых координатах не переборщить ровно на половну
    Point getDot() {

        int y = (coorWord1) * bigSqua
                + (secondOrdinate[1] - 1) * smalSqua
                + lastsquare.getY();

        int x = (coorWord) * bigSqua
                + (secondOrdinate[0] - 1) * smalSqua
                + lastsquare.getX();

        return new Point(x, y);
    }


}
