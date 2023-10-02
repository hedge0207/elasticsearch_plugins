package org.example;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.plugin.analysis.TokenFilterFactory;
import org.elasticsearch.plugin.NamedComponent;

@NamedComponent(value = "foo_bar")
public class FooBarTokenFilterFactory implements TokenFilterFactory {

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new FooBarTokenFilter(tokenStream);
    }

}