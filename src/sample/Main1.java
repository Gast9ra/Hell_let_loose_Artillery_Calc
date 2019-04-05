package sample;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) throws Exception {
        CalcData cal = new CalcData();
       // double[] temp = cal.map("g4-1.1",new Point(20,20), "g4-10.1",new Point(20,20));
      //  System.out.println(cal.distanceToMIl(900));
     //   System.out.println(temp[1]);
        Scanner read = new Scanner(System.in);
//        System.out.println("Пример: A1-3-5-1");
//       // map("a1-2-6-4","a1-2-1-5");
        while (true) {
            System.out.println("Введите дистанцию");
            String first = read.nextLine();
            System.out.println(cal.distanceToMIl(Integer.parseInt(first)));
////            System.out.println("Введите цель");
////            String second = read.nextLine();
////            map(first.toLowerCase() , second.toLowerCase());
        }
    }

//    private static void map(String position1,String posiion2) {
//        DotMap start = new DotMap(position1);
//        DotMap finish = new DotMap(posiion2);
//        System.out.println("Дистанция");
//        System.out.println(roundTwo(distans(start.getDot(), finish.getDot())));
//        System.out.println("Азимут");
//        System.out.println(roundTwo(asimut(start.getDot(), finish.getDot())));
//        System.out.println("_______________");
//    }
//
//    private static double distans(Point position1, Point position2) {
//        return Math.sqrt(Math.pow((position2.getX() - position1.getX()), 2)
//                + Math.pow((position2.getY() - position1.getY()), 2));
//    }
//
//    private static double asimut(Point dot1, Point dot2) {
//        Point dot3 = new Point(dot1.getX(), dot2.getY());
//        double deger = Math.toDegrees(Math.atan(distans(dot2, dot3) / distans(dot1, dot3)));
//        if (dot1.getX() - dot2.getX() > 0 && dot1.getY() - dot2.getY() > 0) {
//            return 360 - deger;
//        } else if (dot1.getX() - dot2.getX() <= 0 && dot1.getY() - dot2.getY() > 0) {
//            return 0 + deger;
//        } else if (dot1.getX() - dot2.getX() <= 0 && dot1.getY() - dot2.getY() <= 0){
//            return 180-deger;
//        } return 180 + deger;
//    }
//
//    private static double roundTwo(double a){ return (double) Math.round(a*10)/10; }


}
