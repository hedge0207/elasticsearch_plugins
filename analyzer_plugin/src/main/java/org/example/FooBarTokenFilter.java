package org.example;

import org.apache.lucene.analysis.FilteringTokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.util.Arrays;

public class FooBarTokenFilter extends FilteringTokenFilter {
    private final CharTermAttribute term = addAttribute(CharTermAttribute.class);

    public FooBarTokenFilter(TokenStream input) {
        super(input);
    }

    @Override
    public boolean accept() {
        if (term.length() != 3) return false;
        return Arrays.equals(term.buffer(), 0, 3, "foo".toCharArray(), 0, 3)
                || Arrays.equals(term.buffer(), 0, 3, "bar".toCharArray(), 0, 3);
    }

}