package main.Parser;

import java.util.ArrayList;

// write also point
public class AutomatSpaceNormalizer implements ISpaceNormolizer {
    @Override
    public String normalize(String str) {

        final int WORD_SEARCH = 0;
        final int WORD_RECORDER = 1;
        final int INSERT_COMMA = 2;
        final int INSERT_POINT = 3;
        final int ERROR = -1;

        char[] symbols = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            if (symbols[i] == ',' || symbols[i] == '.')
            {
                throw new IllegalArgumentException();
            }
            if (Character.isAlphabetic(symbols[i]))
            {
                break;
            }
        }

        ArrayList<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        int state = 0;
        int nextstate;

        for (char symbol : symbols) {
            if (state == WORD_SEARCH) {
                if (symbol == ' ') {
                    nextstate = WORD_SEARCH;
                } else if (Character.isAlphabetic(symbol)) {
                    if (!word.isEmpty())
                    {
                        words.add(word.toString());
                    }
                    word.setLength(0);
                    word.append(symbol);
                    nextstate = WORD_RECORDER;
                } else if (symbol == ',') {
                    word.append(symbol);
                    words.add(word.toString());
                    word.setLength(0);
                    nextstate = INSERT_COMMA;

                } else if (symbol == '.') {
                    word.append(symbol);
                    words.add(word.toString());
                    word.setLength(0);
                    nextstate = INSERT_POINT;

                } else {
                    nextstate = ERROR;
                }
            } else if (state == WORD_RECORDER) {
                if (symbol == ' ') {
                    nextstate = WORD_SEARCH;
                } else if (Character.isAlphabetic(symbol)) {
                    word.append(symbol);
                    nextstate = WORD_RECORDER;
                } else if (symbol == ',') {
                    word.append(symbol);
                    words.add(word.toString());
                    word.setLength(0);
                    nextstate = INSERT_COMMA;
                } else if (symbol == '.') {
                    word.append(symbol);
                    words.add(word.toString());
                    word.setLength(0);
                    nextstate = INSERT_POINT;

                } else {
                    nextstate = ERROR;
                }

            } else if (state == INSERT_COMMA) {
                if (symbol == ' ') {
                    nextstate = INSERT_COMMA;
                } else if (Character.isAlphabetic(symbol)) {
                    word.append(symbol);
                    nextstate = WORD_RECORDER;
                } else if (symbol == ',') {
                    nextstate = ERROR;

                } else if (symbol == '.') {
                    nextstate = ERROR;
                } else {
                    nextstate = ERROR;
                }

            } else if (state == INSERT_POINT) {
                if (symbol == ' ') {
                    nextstate = INSERT_POINT;
                } else if (Character.isAlphabetic(symbol)) {
                    word.append(Character.toUpperCase(symbol));
                    nextstate = WORD_RECORDER;
                } else if (symbol == ',') {
                    nextstate = ERROR;

                } else if (symbol == '.') {
                    nextstate = ERROR;
                } else {
                    nextstate = ERROR;
                }


            } else {
                nextstate = ERROR;
                System.out.println("Error parser");
                throw new IllegalArgumentException();
            }
            state = nextstate;
        }
        if (!word.isEmpty())
        {
            words.add(word.toString());
        }
        return String.join(" ", words);
    }



}
