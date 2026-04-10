import java.util.Scanner;

class PenjumlahanParalel {

    private static int totalSum = 0; // Variabel shared untuk menyimpan hasil akhir dari semua thread

    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah thread: ");
        int jumlahThread = input.nextInt(); // Input jumlah thread

        System.out.print("Masukkan angka akhir: ");
        int angkaAkhir = input.nextInt(); // Input batas akhir penjumlahan

        input.close(); // Close the scanner to prevent resource leak

        int range = angkaAkhir / jumlahThread; 
        // Menentukan besar pembagian tiap thread (dibagi rata)

        Thread[] threads = new Thread[jumlahThread]; 
        // Array untuk menyimpan semua thread

        for (int i = 0; i < jumlahThread; i++) {

            int start = i * range + 1; // Menentukan angka awal untuk thread ke-i
            int end;

            if (i == jumlahThread - 1) {
                end = angkaAkhir; 
                // Thread terakhir mengambil sisa range agar tidak ada angka yang terlewat
            } else {
                end = (i + 1) * range; 
                // Thread selain terakhir mendapatkan range sesuai pembagian
            }

            threads[i] = new Thread(() -> {

                int partialSum = 0; // Variabel lokal untuk menyimpan hasil parsial thread

                System.out.println(Thread.currentThread().getName() +
                        " menghitung dari " + start + " sampai " + end);
                // Menampilkan tugas thread

                for (int j = start; j <= end; j++) {
                    partialSum += j; // Menjumlahkan angka dalam range
                }

                System.out.println(Thread.currentThread().getName() +
                        " hasil parsial: " + partialSum);
                // Menampilkan hasil parsial

                // Menggabungkan hasil parsial ke totalSum secara aman
                synchronized (PenjumlahanParalel.class) {
                    totalSum += partialSum;
                    // synchronized memastikan hanya satu thread yang menambah totalSum dalam satu waktu
                }

            }, "Thread-" + (i + 1)); // Memberi nama thread

            threads[i].start(); // Menjalankan thread
        }

        // Menunggu semua thread selesai
        for (int i = 0; i < jumlahThread; i++) {
            threads[i].join();
        }

        System.out.println("\nHasil akhir: " + totalSum);
        // Menampilkan hasil akhir setelah semua thread selesai
    }
}