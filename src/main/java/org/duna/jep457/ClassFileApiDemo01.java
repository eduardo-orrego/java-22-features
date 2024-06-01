package org.duna.jep457;

import java.io.IOException;
import java.lang.classfile.ClassFile;
import java.lang.constant.ClassDesc;
import java.lang.constant.ConstantDescs;
import java.lang.constant.MethodTypeDesc;
import java.nio.file.Path;

import static java.lang.classfile.ClassFile.ACC_PUBLIC;
import static java.lang.classfile.ClassFile.ACC_STATIC;
import static java.lang.classfile.ClassFile.JAVA_22_VERSION;
import static java.lang.constant.MethodTypeDesc.ofDescriptor;

public class ClassFileApiDemo01 {
  public static void main(String[] args) throws IOException {

    String directory = System.getProperty("user.dir") + "\\src\\main\\java\\org\\duna\\jep457\\";

    ClassFile.of().buildTo(Path.of(directory+"HelloWorld.class"), ClassDesc.of("org.duna.jep457.HelloWorld"), classBuilder -> classBuilder
      .withVersion(JAVA_22_VERSION, 0)
      .withMethodBody("main", ofDescriptor("([Ljava/lang/String;)V"), ACC_PUBLIC | ACC_STATIC, codeBuilder -> codeBuilder
        .getstatic(ClassDesc.of("java.lang.System"), "out", ClassDesc.of("java.io.PrintStream"))
        .ldc("Hello World")
        .invokevirtual(ClassDesc.of("java.io.PrintStream"), "println",
          MethodTypeDesc.of(ConstantDescs.CD_void, ClassDesc.of("java.lang.Object")))
        .return_()));

  }
}
