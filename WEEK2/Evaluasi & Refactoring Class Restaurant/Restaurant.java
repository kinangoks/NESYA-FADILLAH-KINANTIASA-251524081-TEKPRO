public class Restaurant {

    private String[] namaMakanan;
    private double[] hargaMakanan;
    private int[] stok;
    private int id = 0;

    public Restaurant() {
        this.namaMakanan = new String[10];
        this.hargaMakanan = new double[10];
        this.stok = new int[10];
    }

    // Getter
    public String getNamaMakanan(int index) {
        return this.namaMakanan[index];
    }

    public double getHargaMakanan(int index) {
        return this.hargaMakanan[index];
    }

    public int getStok(int index) {
        return this.stok[index];
    }

    // Setter dengan validasi
    public void setStok(int index, int stokBaru) {
        if (stokBaru >= 0) {
            this.stok[index] = stokBaru;
        } else {
            System.out.println("Stok tidak boleh negatif!");
        }
    }

    // Tambah menu
    public void tambahMenuMakanan(String nama, double harga, int stok) {
    if (id < namaMakanan.length) {
        this.namaMakanan[id] = nama;
        this.hargaMakanan[id] = harga;

        if (stok >= 0) {
            this.stok[id] = stok;
        } else {
            this.stok[id] = 0;
        }

        id++;
    } else {
        System.out.println("Menu penuh!");
    }
}


    // Tampil menu
    public void tampilMenuMakanan() {
        for (int i = 0; i < id; i++) {
            System.out.println(
                namaMakanan[i] +
                " [" + stok[i] + "] Rp." +
                hargaMakanan[i]
            );
        }
    }

    // Pesan menu
    public void pesanMenu(String namaMenu, int jumlah) {
        for (int i = 0; i < id; i++) {
            if (namaMakanan[i].equalsIgnoreCase(namaMenu)) {

                if (jumlah <= stok[i]) {
                    setStok(i, getStok(i) - jumlah);  
                    System.out.println(
                        "Pesanan berhasil: " +
                        namaMenu + " x" + jumlah
                    );
                    System.out.println("Total bayar : " + (getHargaMakanan(i) * jumlah));
                } else {
                    System.out.println(
                        "Pesanan ditolak! Stok " +
                        namaMenu + " tidak mencukupi."
                    );
                }
                return;
            }
        }
        System.out.println("Menu tidak ditemukan!");
    }
}
