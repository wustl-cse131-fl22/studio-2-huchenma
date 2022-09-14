package studio2;

public class Pi {

	public static void main(String[] args) {
		  // TODO Auto-generated method stub
		  
		  int i = 0;
		  int count = 0;
		  while(i<10000000) {
		   double x_cor = Math.random();
		   double y_cor = Math.random();
		   double distance = Math.sqrt(Math.pow(y_cor, 2) + Math.pow(x_cor,2));
		   if(distance <= 1) {
		    count++;
		   }
		   i++;
		   
		  }
		  double rate = (double)count/10000000;
		  System.out.print(4.0*rate);
	}
}