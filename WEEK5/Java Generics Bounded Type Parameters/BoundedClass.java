class Bound<T extends A> {
    // T hanya boleh class A atau turunannya
    private T objRef; // referensi objek generic

    public Bound(T obj) {
        this.objRef = obj; // menyimpan objek
    }

    public void doRunTest() {
        this.objRef.displayClass(); // memanggil method dari class A
    }
}

class A {
    public void displayClass(){
        System.out.println("Inside super class A"); // method pada superclass
    }
}

class B extends A {
    public void displayClass() {
        System.out.println("Inside sub class B"); // override method
    }
}

class C extends A {
    public void displayClass() {
        System.out.println("Inside sub class C"); // override method
    }
} 

public class BoundedClass {
    public static void main(String a[]) {
        //Creating object of sub class C and
        //passing it to Boun das a type parameter.
        Bound<C> bec = new Bound<C>(new C());
        bec.doRunTest();

        // Creating object of sub class B and
        // passing it to Bound as a type parameter.
        Bound<B> beb = new Bound<B>(new B());
        beb.doRunTest();

        // similarly passing super class A
        Bound<A> bea = new Bound<A>(new A());
        bea.doRunTest();
    }
}