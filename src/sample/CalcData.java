package sample;

class CalcData {


    //пример координат A1-4,5 или a1-4,5
    //return double mas with 2 element. 0 is distance for target in meter, 1 asimut on target
    double[] map(String position1, Point dot1, String position2, Point dot2) {
        try {
            DotMap start = new DotMap(position1,dot1);
            DotMap finish = new DotMap(position2,dot2);

            double resultAsimut = roundTwo(asimut(start.getDot(), finish.getDot()));
            double resultDistance = roundTwo(distans(start.getDot(), finish.getDot()));

            return new double[]{resultDistance, resultAsimut};
        } catch (NumberFormatException e) {
            System.out.println("not valuable data");
            return null;
        }
    }


    /**
     * calc distance to mill with error +-4.2 or 4.34 m
     */
    private static final int[] meterMil = {978, 954, 930, 907, 883, 859, 836, 812,
            788, 764, 741, 717, 693, 670, 646, 622};
    private static final int[] mil = {24, 24, 23, 24, 24, 23, 24, 24, 24, 23, 24, 24, 23, 24, 24};

    float distanceToMIl(double dis) {
        if (dis > 1600 || dis < 100) throw new NumberFormatException();
        double ratio = 4.2; //if 24
        if (mil[(int) dis / 100 - 1] == 23) ratio = 4.35;
        if (dis % 100 == 0) return meterMil[(int) dis / 100 - 1];
        return meterMil[(int) dis / 100 - 1] - Math.round(roundTwo(dis % 100 / ratio));
//        int meter=100; //start meter
//        int milStart = 978;
//        for(int i=0;dis>meter;i++,meter+=100){
//            milStart-=mil[i];
//        }
//        if (dis%100==0) return milStart;
//        milStart+=mil[(int)dis/100-1];//back on 100 meter in Mil
    }

    //calc distance vector
    private static double distans(Point position1, Point position2) {
        return Math.sqrt(Math.pow((position2.getX() - position1.getX()), 2)
                + Math.pow((position2.getY() - position1.getY()), 2));
    }


    private static double asimut(Point dot1, Point dot2) {
        Point dot3 = new Point(dot1.getX(), dot2.getY()); //third dot in triangle
        double angle = Math.toDegrees(Math.atan(distans(dot2, dot3) / distans(dot1, dot3))); //theorem cos
        //finding the plane(нахождение плоскости)
        if (dot1.getX() - dot2.getX() > 0 && dot1.getY() - dot2.getY() > 0) {
            return 360 - angle;
        } else if (dot1.getX() - dot2.getX() <= 0 && dot1.getY() - dot2.getY() > 0) {
            return 0 + angle;
        } else if (dot1.getX() - dot2.getX() <= 0 && dot1.getY() - dot2.getY() <= 0) {
            return 180 - angle;
        }
        return 180 + angle;
    }

    private static double roundTwo(double a) {
        return (double) Math.round(a * 10) / 10;
    }
}
