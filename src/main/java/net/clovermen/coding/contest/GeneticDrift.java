package net.clovermen.coding.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class GeneticDrift {

    public static void main(String[] args) {

        List<Integer> permutation = new java.util.ArrayList<>(Arrays.stream("8 0 -5 -6 -1 -3 -2 4 7".split(" ")).map(Integer::valueOf).toList());
        Integer permutationsLength = permutation.remove(0);

        List<Integer> negativePermutation = permutation.stream().filter(i -> i < 0).toList();
        List<Integer> positivePermutation = permutation.stream().filter(i -> i > 0).toList();

        List<Pair> interim = new ArrayList<>();

        for (Integer perm: negativePermutation) {
            positivePermutation.forEach(i -> {

                int orientation = Math.abs(i) - Math.abs(perm);

                if(Math.abs(orientation) == 1) {
                    interim.add(new Pair(i, perm));
                }
            });
        }

        List<Pair> opList = interim.stream().sorted(Comparator.comparing(Pair::getX)).toList();

        System.out.print(opList.size());
        opList.forEach(pair -> System.out.print(" " + pair.getX() + " " + pair.getY()));
    }

    private  static  class Pair {

        private Integer x;
        private Integer y;

        public Pair(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public Integer getX() {
            return x;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        public Integer getY() {
            return y;
        }

        public void setY(Integer y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
