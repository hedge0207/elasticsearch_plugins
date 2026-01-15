package com.example.similarity;

import org.apache.lucene.search.similarities.Similarity;
import org.apache.lucene.index.FieldInvertState;
import org.apache.lucene.search.CollectionStatistics;
import org.apache.lucene.search.TermStatistics;


public class MyCustomSimilarity extends Similarity {

  @Override
  public long computeNorm(FieldInvertState state) {
    // 필드 길이 등에 따른 정규화 값 (간단히 1 리턴)
    return 1L;
  }

  @Override
  public SimScorer scorer(float boost, CollectionStatistics collectionStats, TermStatistics... termStats) {
    return new SimScorer() {
      @Override
      public float score(float freq, long norm) {
        // 커스텀 로직: 여기에서 점수를 계산합니다.
        // 예: 빈도수(freq)에 부스트 값을 곱함
        return freq * boost;
      }
    };
  }
}