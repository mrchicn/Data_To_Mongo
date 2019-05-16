package Utils;

import java.util.Random;

public class test {

    public static void main(String [] args){
        Random random = new Random();

        String year[] = {"2018", "2019"};
        String month[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String s_hour;
        String s_day;


        int index ;
       String s_year= year[random.nextInt(year.length)];
       if(s_year==("2019")){
           index=random.nextInt(4);
       }else {
           index=random.nextInt(month.length);
       }

       String s_month=month[index];


        int i_day = random.nextInt(30);
        if (i_day<9){
            s_day="0"+String.valueOf(i_day);
        }else{
            s_day=String.valueOf(i_day) ;
        }

        int i_hour = random.nextInt(24);
        if (i_hour<9){
            s_hour="0"+String.valueOf(i_hour);
        }else{
            s_hour=String.valueOf(i_hour) ;
        }

        int minute = random.nextInt(60)+10;
        int second = random.nextInt(60)+10;

        String aggregate=s_year+"-"+s_month+"-"+s_day+"T"+s_hour+":"+String.valueOf(minute)+":"+String.valueOf(second)+"+08:00";

        System.out.println(aggregate);
    }
}
