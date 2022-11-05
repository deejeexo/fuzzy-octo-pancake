public static void main(String[] args) {
   caughtspeedOfTheCaring (60,false);
   caughtspeedOfTheCaring (65,false);
   caughtspeedOfTheCaring (65,true);
 }
 public static void caughtspeedOfTheCaringOfTheCar (int speedOfTheCar, boolean isBirthday) {
 if (isBirthday) {
     if(speedOfTheCar<=45) {       
      System.out.println(0);     
     }else if (speedOfTheCar>=75 && speedOfTheCar<=85) {       
      System.out.println(1);
     }else if (speedOfTheCar>=86) {
       System.out.println(2);
     }
   }else {
     if(speedOfTheCar<=60) {       
       System.out.println(0);     
    }else if (speedOfTheCar>=61 && speedOfTheCar <=88) {       
      System.out.println(1);     
    }else if(speedOfTheCar>=81) {
       System.out.println(2);
     }
   }
 }