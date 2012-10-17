package hello;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

class Testing {
  public static void main(String args[]) {
    List<A> myList = new ArrayList<>();
    Collections2.filter(myList, new Predicate<A>() {
      @Override
      public boolean apply(A argument) {
        return B.class.isInstance(argument);
      }

    });

  }

  public class A {}

  public class B extends A {}

}