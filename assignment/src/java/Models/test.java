/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author FPTSHOP
 */
public class test {
    public static void main(String[] args) {
//        ArrayList<Integer> d = new ArrayList<>();
//        ArrayList<Integer> c = new ArrayList<>();
//        d.add(1);
//        d.add(2);
//        d.add(2);
//        d.add(3);
//        d.add(2);
//        d.add(4);
//        d.add(1);
//        int count = 0;
//        int gan = 1;
//        for (int i = 0; i < d.size();) {
////            i = 0;
//            count = d.get(i);
//            System.out.println("count = d(i) tại i = "+i);
//            gan = 0;
//            System.out.println("count: "+count);
//            for (int j = 0; j < d.size(); j++) {
//                System.out.println(count + "==" +  d.get(j) + ", vị trí: "+j);
//                if(count == d.get(j)){
//                    System.out.println("sắp bị xóa: "+d.get(j)+", tại vị trí: "+j);
//                    d.remove(j);
//                    gan ++;
//                    j=j-1;
//                    System.out.println("gán: "+gan);
//                    System.out.println(d);
//                }
//            }
//            if(gan==0){
//                c.add(1);
//            }else{
//                c.add(gan);
//            }
//        }
//        System.out.println(c);
//        for (int i = 0; i < d.size(); i++) {
//            if(!c.contains(d)){
//                c.add(d.get(i));
//            }
//        }
//        System.out.println(c);
//        c.remove(2);
//        System.out.println(c);
//        System.out.println(d);
//        int g[]= null;
//        int count = 0;
//        for (int i = 0; i < 10; i++) {
//            g[i] = i;
//            count++;
//        }
//        for (int i = 0; i < g.length; i++) {
//            System.out.println(g[i]);
//        }
//        Date date = new Date(0);
//        String d = (String) date;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
//        date = simpleDateFormat.parse("03-19-2022");
            String a = "03848865161";
        System.out.println(a.matches("^\\d{10}$"));
    }
}
