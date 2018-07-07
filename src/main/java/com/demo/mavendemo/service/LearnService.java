package com.demo.mavendemo.service;


import com.demo.mavendemo.domain.LearnResouce;
import com.demo.mavendemo.tools.Page;

import java.util.Map;

/**
 * Created by tengj on 2017/4/7.
 */
public interface LearnService {
    int add(LearnResouce learnResouce);
    int update(LearnResouce learnResouce);
    int deleteByIds(String ids);
    LearnResouce queryLearnResouceById(Long learnResouce);
    Page queryLearnResouceList(Map<String,Object> params);
}
