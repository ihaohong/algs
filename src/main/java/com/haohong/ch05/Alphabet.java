package com.haohong.ch05;

public class Alphabet {
    private char[] alphabet;
    private int R;
    private int[] inverse;

    public Alphabet(String s) {
        alphabet = s.toCharArray();
        R = s.length();

        inverse = new int[Character.MAX_VALUE];
        for (int i = 0; i < inverse.length; i++)
            inverse[i] = -1;

        for (int c = 0; c < R; c++)
            inverse[alphabet[c]] = c;
    }

    public char toChar(int index) {
        return alphabet[index];
    }

    public int toIndex(char c) {
        return inverse[c];
    }

    public boolean contains(char c) {
        return inverse[c] != -1;
    }

    public int R() {
        return R;
    }

    public int lgR() {
        int lgR = 0;

        for (int t = R-1; t >= 1; t /= 2)
            lgR++;

        return lgR;
    }

    public int[] toIndices(String s) {
        char[] source = s.toCharArray();
        int[] target  = new int[s.length()];

        for (int i = 0; i < source.length; i++)
            target[i] = toIndex(source[i]);

        return target;
    }

    public String toChars(int[] indices) {
        StringBuilder s = new StringBuilder(indices.length);

        for (int i = 0; i < indices.length; i++)
            s.append(toChar(indices[i]));

        return s.toString();
    }
}
