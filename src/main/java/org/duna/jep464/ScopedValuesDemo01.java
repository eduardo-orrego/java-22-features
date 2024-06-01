package org.duna.jep464;

public class ScopedValuesDemo01 {
  private static final ScopedValue<String> scopedValue = ScopedValue.newInstance();

  public static void main(String[] args) {
    ScopedValue
      .where(scopedValue, "one")
      .run(() -> System.out.println(scopedValue.get()));

    ScopedValue
      .where(scopedValue, "two")
      .run(() -> System.out.println(scopedValue.get()));
  }
}
