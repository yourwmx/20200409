package com.xzsd.pc.dictionary.dao;

import com.xzsd.pc.dictionary.entity.DictionaryInfo;

/**
 * DictionaryDao
 * wumaoxing
 * 2020-04-05 16:28
 */
public interface DictionaryDao {
    /**
     * 查询k对应的v
     * wumaoxing
     * 2020-04-05 16:32
     */
    DictionaryInfo queryVById(String dictionaryId);
}
