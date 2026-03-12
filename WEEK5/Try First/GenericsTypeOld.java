public class GenericsTypeOld {

    private Object t; // menggunakan Object sehingga bisa menyimpan semua tipe data

    public Object get() { 
        return t; // mengembalikan nilai t
    }

    public void set(Object t) { 
        this.t = t; // menyimpan nilai ke variabel t
    }

    public static void main(String args[]) {

        GenericsTypeOld type = new GenericsTypeOld(); // membuat objek

        type.set("Java"); // menyimpan String ke Object

        String str = (String) type.get(); 
        // perlu type casting karena tipe asli Object
        // berisiko menyebabkan ClassCastException

        System.out.println(type.get());
    }
}