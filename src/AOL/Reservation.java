package AOL;

public class Reservation{
	
	public String name;
	public int total;
	public int queue;
	public String meja;

	public Reservation(String name, int total, int queue, String meja) {
		this.name = name;
		this.total = total;
		this.queue = queue;
		this.meja = meja;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}

	public int getQueue() {
		return queue;
	}
	
	public void setQueue(int queue) {
		this.queue = queue;
	}


	public String getMeja() {
		return meja;
	}

	public void setMeja(String meja) {
		this.meja = meja;
	}
	
	
}
