package lanqiao;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num=scanner.nextInt();
        String[][] people=new String[num][5];
        for (int i=0;i<num;i++){
            for (int a=0;a<5;a++){
                people[i][a]=scanner.next();
            }
        }
        condition(people);
    }
    public static void condition(String[][] people){
        int aNum=0;
        int bNum=0;
        for (int a=0;a<people.length;a++){
            if (!people[a][1].equals("G")){
                if (people[a][3].equals("N")&&Integer.parseInt(people[a][4])<3){
                    if (people[a][0].equals("L")){
                        if (people[a][2].equals("D")){
                            aNum++;
                        }else if (people[a][2].equals("E")){
                            bNum++;
                        }
                    }else {
                        if (people[a][2].equals("E")){
                            bNum++;
                        }
                    }
                }
            }else {
                if (people[a][0].equals("L")){
                    if (people[a][2].equals("D")){
                        aNum++;
                    }else if (people[a][2].equals("E")){
                        bNum++;
                    }
                }else {
                    if (people[a][2].equals("E")){
                        bNum++;
                    }
                }
            }

        }
        System.out.println(aNum+" "+bNum);
    }
}
