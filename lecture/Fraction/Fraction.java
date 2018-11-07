
public class Fraction {

		private int numerator;//ºÐÀÚ
		private int denominator;//ºÐ¸ð
		
		Fraction(int numerator, int denominator){
			int gcd = greatestCommonDivisor(numerator, denominator);
			this.numerator = numerator /gcd;
			this.denominator =denominator /gcd;
		}
		
		
	@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			if(obj instanceof Fraction==false){
				return false;
			}
			Fraction f = (Fraction)obj;
			return this.numerator==f.numerator&&this.denominator==f.denominator;
	}


		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return numerator+"/"+denominator;
		}

		public static Fraction add(Fraction f1, Fraction f2){
			int numerator =(f1.numerator*f2.denominator)+(f2.numerator*f1.denominator);
			int denominator =f1.denominator*f2.denominator;
			return new Fraction(numerator,denominator);
		}//µ¡¼À
		
		
		public static int greatestCommonDivisor(int x, int y){
			return y==0? x: greatestCommonDivisor(y,x%y);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Fraction f1 = new Fraction(1, 2); 
        Fraction f2 = new Fraction(1, 3); 
        
        System.out.printf("%s £« %s = %s\n", f1, f2, Fraction.add(f1, f2));
        

        System.out.println(Fraction.add(f1,  f2).equals(new Fraction(5, 6))); 


	}

}
