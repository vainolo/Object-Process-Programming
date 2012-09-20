/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package hello;

public class Testing {
  public static class A {
    public void accept(Caller1 caller) {
      caller.call(this);
    }
  }

  public static class B extends A {
    // public void accept(Caller1 caller) {
    // caller.call(this);
    // }
  }

  public static class Caller1 {
    public void call(A a) {
      System.out.println("Calling with A");
    }

    public void call(B b) {
      System.out.println("Calling with B");
    }
  }

  public static void main(String args[]) {
    A a = new A();
    B b = new B();
    A bAsA = b;
    Caller1 c = new Caller1();

    System.out.println("Static dispatch.");
    c.call(a);
    c.call(b);
    c.call(bAsA);

    System.out.println("Double dispatch.");
    a.accept(c);
    b.accept(c);
    bAsA.accept(c);
  }
}
