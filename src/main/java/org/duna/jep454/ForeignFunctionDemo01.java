package org.duna.jep454;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.nio.file.Path;

public class ForeignFunctionDemo01 {

  public static void main(String[] args) {

    try (var arena = Arena.ofConfined()) {
      var lib = SymbolLookup.libraryLookup(Path.of(System.getProperty("user.dir")
        + "\\src\\main\\java\\org\\duna\\jep454\\sum_function.so"), arena);
      var linker = Linker.nativeLinker();
      var fd = FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT,
        ValueLayout.JAVA_INT);
      var addFunc = lib.find("sum_function").get();
      var methodHandle = linker.downcallHandle(addFunc, fd);
      int num1 = 10;
      int num2 = 20;
      var sum = methodHandle.invoke(num1, num2);
      System.out.printf("Sum: %d + %d = %d %n", num1, num2, sum);
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }

  }
}
