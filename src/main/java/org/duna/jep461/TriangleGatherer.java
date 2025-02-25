package org.duna.jep461;

import java.util.function.Function;
import java.util.stream.Gatherer;

public class TriangleGatherer<T,M> implements Gatherer<T, T, M> {
  private final Function<T, M> mapper;

  public TriangleGatherer(Function<T, M> mapper) {
    this.mapper = mapper;
  }

  @Override
  public Integrator<T, T, M> integrator() {
    return Integrator.ofGreedy((_, item, downstream) -> {
      if(item != null) {
        downstream.push(mapper.apply(item));
      }
      return true;
    });
  }
}