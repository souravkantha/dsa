package misc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeFormat {

  public static void main(String[] argv) {
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    System.out.println(f.format(new Date()));
  }
}

