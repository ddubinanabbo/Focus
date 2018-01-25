package com.focus.common.service;

import java.util.Map;

import com.focus.util.PageNavigation;

public interface CommonService {

	PageNavigation makePageNavigation(Map<String, String> map);

	int getNextSeq();

}
