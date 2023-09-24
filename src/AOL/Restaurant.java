package AOL;

abstract class Restaurant {
	
	private String name;
	private String menu_name;
	private int queue;
	private int price;
	private int total;
	private String meja;
	// meja_kecin = 0, meja_besar = 1

	// getter and setter
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQueue() {
		return queue;
	}
	
	public void setQueue(int queue) {
		this.queue = queue;
	}
	
	public String getMenu_name() {
		return menu_name;
	}
	
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	public String getMeja() {
		return meja;
	}

	public void setMeja(String meja) {
		this.meja = meja;
	}

	public abstract void showAlldata();
	
	
	
}
