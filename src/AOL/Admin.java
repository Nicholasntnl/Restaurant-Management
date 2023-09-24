package AOL;

public class Admin extends Restaurant{

		public Admin(String name) {
			super.setName(name);
		}

		@Override
		public void showAlldata() {
			System.out.println(super.getName());
		}
		
//		public int calculate() {
//			
//		}
		
		
		public void Total_harga(int total) {
			System.out.println("Bill: " + total);
		}
	
}
