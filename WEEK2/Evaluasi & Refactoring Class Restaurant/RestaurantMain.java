import java.util.Scanner;

public class RestaurantMain {

    public static void main(String[] args) {

        Restaurant menu = new Restaurant();

        menu.tambahMenuMakanan("Pizza", 250000, 20);
        menu.tambahMenuMakanan("Spaghetti", 80000, 20);
        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30);
        menu.tambahMenuMakanan("Chicken Steak", 45000, 30);
        System.out.println("=== DAFTAR MENU ===");
        menu.tampilMenuMakanan();

        Scanner input = new Scanner(System.in);
        String lagi;

        do {

            System.out.println("\n=== PEMESANAN ===");
            System.out.print("Masukkan nama menu: ");
            String nama = input.nextLine();

            System.out.print("Jumlah: ");
            int jumlah = input.nextInt();
            input.nextLine();
            if (jumlah <= 0) {
                System.out.println("Jumlah tidak boleh nol maupun negatif!");
            } else {
                menu.pesanMenu(nama, jumlah);
            }

            System.out.print("\nApakah tambah pesanan (y/n)? ");
            lagi = input.nextLine();

        } while (lagi.equalsIgnoreCase("y"));

        System.out.println("\nStok akhir:");
        menu.tampilMenuMakanan();

        input.close();
    }
}
