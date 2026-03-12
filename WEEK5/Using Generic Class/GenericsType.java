public class GenericsType<T> { // T adalah parameter tipe generic

    private T t; // variabel menggunakan tipe generic
    
    public T get() {
        return this.t;  // mengembalikan nilai dengan tipe T
    }

    public void set(T t1) {
        this.t = t1; // menyimpan nilai bertipe T
    }

    public static void main (String args[]) {

        GenericsType<String> type = new GenericsType<>(); // menentukan tipe String

        type.set("Java"); //valid karena string

        GenericsType<Object> type1 = new GenericsType<>(); //raw type (tanpa tipe generic)

        type1.set("Java"); //valid
        type1.set(10); //valid and autoboxing support
        
        System.out.println(type.get());
        System.out.println(type1.get());
    }
}