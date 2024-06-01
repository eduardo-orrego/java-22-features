package org.duna.jep461;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Gatherer;

public class StreamGatherersDemo01 {
  public void main(String[] args) {
    List<Triangle> triangleList= Arrays.asList(
      new Triangle(10, 20),
      null,
      new Triangle(30,40),
      null,
      null
    );

    System.out.println("\nTriangle List: " + triangleList);
    System.out.println("\nEliminate null records and calculate the area...");
    System.out.println("\nGatherer Interface Implementation in TriangleGatherer Class:");
    triangleList.stream()
      .gather(notNullVer1(Triangle::area))
      .forEach(System.out::println);

    System.out.println("\nUsing the Gatherer.of method:");
    triangleList.stream()
      .gather(notNullVer2(Triangle::area))
      .forEach(System.out::println);
  }

  static <T, M> TriangleGatherer<T, M> notNullVer1(Function<T, M> mapper) {
    return new TriangleGatherer<>(mapper);
  }

  static <T, R> Gatherer<T, ?, R> notNullVer2(Function<T, R> mapper) {
    return Gatherer.of(
      (_, element, downstream) -> {
        if (element != null) {
          downstream.push(mapper.apply(element));
        }
        return true;
      });
  }

  record Triangle(Integer base, Integer height) {
    public Integer area(){
      return base*height;
    }
  }
}

