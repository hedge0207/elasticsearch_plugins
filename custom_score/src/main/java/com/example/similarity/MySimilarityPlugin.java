package com.example.similarity;

import org.elasticsearch.index.IndexModule;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.plugins.MapperPlugin;

public class MySimilarityPlugin extends Plugin implements MapperPlugin {

  @Override
  public void onIndexModule(IndexModule indexModule) {
    indexModule.addSimilarity("my_custom_similarity",
      (settings, version, scriptService) -> new MyCustomSimilarity());
  }
}