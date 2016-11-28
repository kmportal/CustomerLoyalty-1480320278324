import java.util.Random;
import java.util.UUID;



public class udid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   UUID myuuid = UUID.randomUUID();
   long highbits = myuuid.getMostSignificantBits();
   long lowbits = myuuid.getLeastSignificantBits();
   System.out.println("My UUID is: " + highbits + " " + lowbits);
   //My UUID is: 427554230970303331 -8501350340874798635
     
   
   Random rand = new Random();
   long accumulator = rand.nextLong(); // ensures that the 16th digit isn't 0
 /*  for(int i = 0; i < 15; i++) {
       accumulator *= 10L;
       accumulator += rand.nextInt();
   }*/
   System.out.println("***************************************"+accumulator);

	}

}
