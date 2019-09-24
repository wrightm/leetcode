package stringAndArrays;

import java.util.Arrays;

public class ArraySizeAndSort {

    public static void main(String[] args){
        int[] a = new int[5];
        a[0] = 3;
        a[1] = 1;
        a[2] = 2;

        assert a.length == 5;

        Arrays.sort(a);

        assert a[0] == 0;
        assert a[1] == 0;
        assert a[2] == 1;
        assert a[3] == 2;
        assert a[4] == 3;

        System.out.println(String.format("Success: %s", Arrays.toString(a)));
    }
}
