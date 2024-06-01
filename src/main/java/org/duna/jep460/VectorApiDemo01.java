package org.duna.jep460;

import java.util.Arrays;
import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;

public class VectorApiDemo01 {
  static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

  static void vectorComputation(float[] a, float[] b, float[] c) {
    for (int i = 0; i < a.length; i += SPECIES.length()) {
      // VectorMask<Float>  m;
      var m = SPECIES.indexInRange(i, a.length);
      // FloatVector va, vb, vc;
      var va = FloatVector.fromArray(SPECIES, a, i, m);
      var vb = FloatVector.fromArray(SPECIES, b, i, m);
      var vc = va.mul(va)
        .add(vb.mul(vb))
        .neg();
      vc.intoArray(c, i, m);
    }
  }

  public static void main(String[] args) {
    float[] vector1 = {1, 2, 3, 4};
    float[] vector2 = {5, 6, 7, 8};
    float[] vector3 = {9, 10, 11, 12};

    vectorComputation(vector1, vector2, vector3);

    System.out.println(Arrays.toString(vector3));
  }

}
