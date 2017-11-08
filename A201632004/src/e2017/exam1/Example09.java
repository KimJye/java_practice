package e2017.exam1;

public class Example09 {

	class Data{
		Object obj;
		public Data(int[] obj){
			this.obj=obj;
		}
		public Data(Integer[] obj){
			this.obj=obj;
		}
		public Data(String[] obj){
			this.obj=obj;
		}
		public Data(int i, int j, int k) {
			// TODO Auto-generated constructor stub
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data[]a=new Data[3];
		a[2]=new Data[]{(new String[]{"hello")};
	}

}
