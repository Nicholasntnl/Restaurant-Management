package AOL;

public class Menu extends Restaurant{
	
	public Menu(String name, int price) {
		super.setMenu_name(name);
		super.setPrice(price);
	}
	
	@Override
	public void showAlldata() {
		System.out.printf("%-21s |%d", super.getMenu_name(), super.getPrice());
		System.out.println("");
	}
	
}
