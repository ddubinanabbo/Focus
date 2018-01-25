package com.focus.common.dao;

import java.util.Map;

public interface CommonDao {

	int getNextSeq();

	int getNewArticleCount(int parseInt);

	int getTotalArticleCount(Map<String, String> map);

	void updateHit(int seq);

}
