package AOL;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static Scanner scan = new Scanner(System.in);
	public static int meja_besar = 8;
	public static int meja_kecil = 12;
	public static int queue_number = 1;
	public static ArrayList<Menu> menu_data = new ArrayList<Menu>();
	public static ArrayList<Reservation> Reservation_Data = new ArrayList<Reservation>();
	public static ArrayList<Dine_in> Dinein_data = new ArrayList<Dine_in>();
	public static Admin Admin_data = new Admin("Dimas");
//	Reservation_Data.add(new Reservation("Dimas", 3, queue_number, "MK"));
	
	
	
	// main method
	public static void main(String[] args) {
		input_menu();

		menu_main();
		
	}
	
	
	// main menu
	public static void menu_main() {

		System.out.println("1. Input Queue"); // done
		System.out.println("2. Next Queue");
		System.out.println("3. Finnish Eat");
		System.out.println("4. Show Reservation"); // done
		System.out.println("5. Show Menu");
		System.out.println("6. Show Table Data");
		System.out.println("7. Add New Menu");
		System.out.println("8. Close"); // done
		System.out.print(">");
		int opsi;
		opsi = scan.nextInt();
		scan.nextLine();
		option(opsi);
		
	}
	
	// option
	public static void option(int opsi) {
		
		switch (opsi) {
		case 1: 
			String Temp_name;
			System.out.print("Input Name: ");
			Temp_name = scan.nextLine();

			
			int Total_temp;
			System.out.print("Input Total: ");
			Total_temp = scan.nextInt();
			
			if(Total_temp >= 5) {
				Reservation_Data.add(new Reservation(Temp_name, Total_temp, queue_number, "MB"));
			}else {
				Reservation_Data.add(new Reservation(Temp_name, Total_temp, queue_number, "MK"));
			}
			
			queue_number++;
			System.out.println("Data Added");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			scan.nextLine();
			menu_main();
			break;
		
		case 2: 
			int temp_bill = 0;
			if(Reservation_Data.isEmpty()){
				System.out.println("There is no data");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				menu_main();
			}else{

				if (Reservation_Data.get(0).getMeja().equals("MK")) {
					if(meja_kecil <= 0) {
						System.out.println("There is no enough small table!");
						System.out.println("Press enter to continue...");
						scan.nextLine();
						menu_main();
					}else{
						
						System.out.println("How many menu you want to order?");
						System.out.print(">");
						int ord = scan.nextInt();
						scan.nextLine();
						show_menu();
						for(int i = 0 ; i < ord; i++){
							System.out.printf("Order [1...%d]: ", menu_data.size());
							int choose = scan.nextInt();
							scan.nextLine();
							temp_bill = temp_bill + menu_data.get(choose-1).getPrice();
						}
						
						Dinein_data.add(new Dine_in(Reservation_Data.get(0).getName(), temp_bill, Reservation_Data.get(0).getMeja()));
						

						meja_kecil--;
					}
				} else {
					if(meja_besar <= 0) {
						System.out.println("There is no enough big table!");
						System.out.println("Press enter to continue...");
						scan.nextLine();
						menu_main();
					}else{
						System.out.println("How many menu you want to order?");
						System.out.print(">");
						int ord = scan.nextInt();
						scan.nextLine();
						show_menu();
						for(int i = 0 ; i < ord; i++){
							System.out.printf("Order [1...%d]: ", menu_data.size());
							int choose = scan.nextInt();
							scan.nextLine();
							temp_bill += menu_data.get(choose-1).getPrice();
						}
						
						Dinein_data.add(new Dine_in(Reservation_Data.get(0).getName(), temp_bill, Reservation_Data.get(0).getMeja()));
						

						meja_besar--;
					}

				}
				System.out.println("Calling for queue number " + Reservation_Data.get(0).getQueue() + " with " + Reservation_Data.get(0).getTotal() + " person(s)");
				Reservation_Data.remove(0);
				

				System.out.println("Press enter to continue...");
				scan.nextLine();
				menu_main();

			}
			break;
	
		case 3: 
			
			if(Dinein_data.isEmpty()){
				System.out.println("No data");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				menu_main();
			}
			
			Admin_data.Total_harga(Dinein_data.get(0).getTotal());
			System.out.println("Thank you for eating on our restaurant!");
			if(Dinein_data.get(0).getMeja().equals("MK")) {
				meja_kecil++;
			} else {
				meja_besar++;
			}
			Dinein_data.remove(0);
			System.out.println("Press enter to continue...");
			scan.nextLine();
			menu_main();
			break;
		
		case 4: 
		if(Reservation_Data.isEmpty()){
			System.out.println("There is no data");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			menu_main();
		}else{

				show_Reservation();

			}
			break;
		case 5:
			show_menu();

			System.out.println("Press enter to continue...");
			scan.nextLine();
			menu_main();
			break;
		case 6:
			System.out.printf("MK (Meja Kecil): %d\n", meja_kecil);
			System.out.printf("MB (Meja Besar): %d\n", meja_besar);

			System.out.println("Press enter to continue...");
			scan.nextLine();
			menu_main();
			break;
		case 7:
			String name_temp;
			int price_temp;
			System.out.print("Input Menu Name: ");
			name_temp = scan.nextLine();

			System.out.print("Input Menu Price: ");
			price_temp = scan.nextInt();
			scan.nextLine();

			menu_data.add(new Menu(name_temp, price_temp));

			System.out.println("Menu added");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			menu_main();
			break;
		case 8: 
			System.out.println("Thanks For Coming");
			queue_number = 1;
			return;
			// break;
		
		default: 
			menu_main();
		}
	}
	
	

	
	
	// input data menu
	static void input_menu() {
		menu_data.add(new Menu("Steak", 500000));
		menu_data.add(new Menu("Indomie", 100000));
		menu_data.add(new Menu("Salad with peanut", 200000));
		menu_data.add(new Menu("Soto", 250000));
		menu_data.add(new Menu("Oriental Chicken", 150000));
		menu_data.add(new Menu("Black Sparkling Water", 50000));
		
	}
	
	// show data menu
	static void show_menu() {
		System.out.println("No|Name                  |Price");
		for(int i = 0; i < menu_data.size(); i++) {
			System.out.printf("%-2d|", i+1);
			menu_data.get(i).showAlldata();
		}
		System.out.println("");
	}
	// show reservation data
	static void show_Reservation() {
		System.out.println("|No.|Name           |Total                  |Queue    |Meja Type");
		System.out.print("====================================================================================");
		System.out.println();
		
		for(int i = 0; i < Reservation_Data.size(); i++) {
		 System.out.printf("|%-3s|%-15s|%-23s|%-9d|%-10s\n", i+1, Reservation_Data.get(i).getName(), Reservation_Data.get(i).getTotal(), Reservation_Data.get(i).getQueue(), Reservation_Data.get(i).getMeja());
	  
		}
		System.out.println("");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		menu_main();
	}
}
