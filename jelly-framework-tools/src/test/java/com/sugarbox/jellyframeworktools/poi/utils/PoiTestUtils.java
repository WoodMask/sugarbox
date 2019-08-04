package com.sugarbox.jellyframeworktools.poi.utils;

import com.alibaba.fastjson.JSONArray;
import com.sugarbox.jellyframeworktools.poi.dto.SampleTree;

import java.util.List;

public class PoiTestUtils {

    private PoiTestUtils(){}

    public static List<SampleTree> transformJsonArray(JSONArray jsonArray){

        List<SampleTree> list = jsonArray.toJavaList(SampleTree.class);
        return list;
    }
}
