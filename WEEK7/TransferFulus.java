class Account{
    int balance = 150; // Setiap objek Account memiliki atribut balance dengan nilai awal 150 sebagai saldo awal
}

public class TransferFulus{
    public static void main(String[] args) throws InterruptedException {
        
        Account acc1 = new Account(); // Membuat objek akun pertama yang akan digunakan dalam proses transfer
        Account acc2 = new Account(); // Membuat objek akun kedua sebagai tujuan/asal transfer
        
        // Thread 1: Menjumlahkan/transfer fulus dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            
            synchronized (acc1) { // Mengunci objek acc1 agar hanya satu thread yang bisa mengaksesnya dalam satu waktu
                                   // Ketika thread ini masuk, thread lain tidak dapat menggunakan acc1 sampai blok selesai
                System.out.println("Thread 1 sedang mengunci acc1"); // Memberikan informasi bahwa thread 1 sedang memegang lock acc1
                
                try {
                    Thread.sleep(100); // Memberikan jeda untuk mensimulasikan proses yang memakan waktu
                                       // Selain itu, jeda ini memberi kesempatan thread lain berjalan sehingga kondisi konkurensi terlihat
                } catch (Exception e) {} // Penanganan exception karena sleep dapat melempar InterruptedException
                
                synchronized (acc2) { // Setelah acc1 berhasil dikunci, thread mencoba mengunci acc2
                                       // Penguncian berurutan ini aman karena urutan sama dengan thread lain
                    System.out.println("Thread 1 sedang mengunci acc2"); // Menandakan acc2 juga sudah berhasil dikunci
                    
                    acc2.balance += acc1.balance; // Proses transfer: saldo acc1 ditambahkan ke acc2
                                                  // Aman dilakukan karena kedua akun sedang dalam kondisi terkunci
                }
            }
        });

        // Thread 2 : Transfer dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            
            synchronized (acc1) { // Mengunci acc1 terlebih dahulu, sama seperti thread 1
                                   // Konsistensi urutan ini penting untuk mencegah deadlock
                System.out.println("Thread 2 sedang mengunci acc1"); // Informasi bahwa thread 2 sedang memegang lock acc1
                
                try {
                    Thread.sleep(100); // Simulasi proses agar eksekusi tidak instan dan memberi efek konkurensi
                } catch (Exception e) {} // Menangani kemungkinan exception dari sleep
                
                synchronized (acc2) { // Setelah acc1, thread mengunci acc2 dengan urutan yang sama
                                       // Karena urutan sama, tidak terjadi saling tunggu antar thread
                    System.out.println("Thread 2 sedang mengunci acc2"); // Menandakan acc2 telah dikunci
                    
                    acc1.balance += acc2.balance; // Proses transfer: saldo acc2 ditambahkan ke acc1
                                                  // Operasi ini aman karena kedua objek sudah dikunci oleh thread yang sama
                }
            }
        });

        t1.start(); // Menjalankan thread 1 sehingga mulai bersaing mendapatkan CPU
        t2.start(); // Menjalankan thread 2 secara paralel dengan thread 1
        
        t1.join(); // Menunggu thread 1 selesai sebelum melanjutkan eksekusi program utama
        t2.join(); // Menunggu thread 2 selesai agar hasil akhir sudah pasti final
        
        System.out.println("--- HASIL AKHIR ---"); // Menampilkan penanda hasil akhir setelah kedua thread selesai
        
        System.out.println("Saldo Akhir acc1: " + acc1.balance); // Menampilkan saldo akhir acc1 setelah proses transfer
        System.out.println("Saldo Akhir acc2: " + acc2.balance); // Menampilkan saldo akhir acc2 setelah proses transfer
    }
}