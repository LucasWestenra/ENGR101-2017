# include <stdio.h>
# include <time.h> 
# include "E101.h" 

int main (){  
  init (); 
  int adc_reading ; 
  while (true){         
    int readingTotal = 0;         
      for (int i = 0; i<5; i++){ 
      adc_reading = read_analog (0);                     
      readingTotal = readingTotal + adc_reading;                     
    }         
    largestReading = largestReading/5
    printf ("%d\n", largestReading);         
    sleep1 (1 ,0);     
  }
  if (largestReading > 150){
     set_motor(1, 100); //  FORWARD   1 = left
     set_motor(2, -100); // FORWARD   2 = right
  }
  else if(largestReading < 150 || largestReading > 100){
     set_motor(1, -50); //  TURN LEFT
     set_motor(2, -50); // TURN LEFT
  }
  else if(largestReading < 100 || largestReading > 50){
     set_motor(1, 50);  // TURN RIGHT
     set_motor(2, 50);  //TURN RIGHT
  }
  else{
     set_motor(1, -25); // REVERSE ~slowly~~~~~~~~~~~~~~~~>>>
     set_motor(2, 25); //  REVERSE ~slowly~~~~~~~~~~~~~~~~>>>
  }
  return 0; 
}
