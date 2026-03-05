public class Commission extends Hourly {
    private double totalSales; //menyimpan total penjualan karyawan
    private double commissionRate; //menyimpan persentase komisi

    public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate, double commissionRate)
    {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.commissionRate = commissionRate; //this berarti variabel milik class. parameter dimasukkan ke variabel instance
        totalSales = 0;
    }

    public void addSales(double sales)
    {
        totalSales += sales;
    }

    public double pay()
    {
        double payment = super.pay();
        payment += totalSales * commissionRate;
        totalSales = 0;
        return payment;
    }
    
    public String toString() 
    {
        String result = super.toString();
        result +="\ntotal Sales: " + totalSales;
        return result;
    }
}
