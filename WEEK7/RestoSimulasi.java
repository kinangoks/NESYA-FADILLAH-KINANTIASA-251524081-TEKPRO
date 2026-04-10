class Resto {
    private int chickenStock = 100; // Variabel stok ayam yang akan diakses oleh banyak thread

    public synchronized void serveCustomer(String cashierName) {
        // Method diberi keyword synchronized agar hanya satu thread yang bisa mengeksekusi
        // method ini dalam satu waktu (mutual exclusion)

        if (chickenStock > 0) { // Mengecek apakah stok masih tersedia
            try { 
                Thread.sleep(10); // Simulasi delay untuk memperbesar peluang konkurensi
            } catch (InterruptedException e) {} // Penanganan exception wajib karena sleep melempar InterruptedException
            
            chickenStock--; // Mengurangi stok sebanyak 1
                              // Operasi ini sekarang aman karena berada dalam blok synchronized
                              
            System.out.println(cashierName + " berhasil menjual 1 ayam. Sisa stok: " + chickenStock);
            // Menampilkan informasi kasir yang berhasil menjual ayam beserta sisa stok terbaru
        } else {
            System.out.println(cashierName + " gagal: Stok Habis!");
            // Menampilkan pesan jika stok sudah habis
        }
    }

    public synchronized int getRemainingStock() {
        // Method ini juga disinkronisasi agar pembacaan nilai stok konsisten
        return chickenStock; // Mengembalikan sisa stok ayam
    }
}

public class RestoSimulasi {
    public static void main(String[] args) throws InterruptedException {
        
        Resto ayamJuicyLuicyGallagher = new Resto(); 
        // Membuat satu objek Resto yang akan diakses oleh semua thread (shared resource)

        Runnable task = () -> {
            // Mendefinisikan tugas yang akan dijalankan oleh setiap thread (kasir)
            
            for (int i = 0; i < 40; i++) { 
                // Setiap kasir akan mencoba melayani 40 pelanggan
                
                ayamJuicyLuicyGallagher.serveCustomer(Thread.currentThread().getName());
                // Memanggil method serveCustomer dengan nama thread sebagai identitas kasir
            }
        };

        Thread kasir1 = new Thread(task, "Kasir-A"); // Membuat thread pertama sebagai kasir A
        Thread kasir2 = new Thread(task, "Kasir-B"); // Membuat thread kedua sebagai kasir B
        Thread kasir3 = new Thread(task, "Kasir-C"); // Membuat thread ketiga sebagai kasir C

        kasir1.start(); // Menjalankan thread kasir A
        kasir2.start(); // Menjalankan thread kasir B
        kasir3.start(); // Menjalankan thread kasir C

        kasir1.join(); // Menunggu kasir A selesai
        kasir2.join(); // Menunggu kasir B selesai
        kasir3.join(); // Menunggu kasir C selesai
        
        // join digunakan agar hasil akhir ditampilkan setelah semua thread selesai bekerja

        System.out.println("--- HASIL AKHIR STOK: " + ayamJuicyLuicyGallagher.getRemainingStock() + " ---");
        // Menampilkan sisa stok akhir setelah semua proses selesai
    }
}