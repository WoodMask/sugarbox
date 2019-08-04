package com.sugarbox.jellyframeworktools.poi.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SampleBean {

    @JSONField(name = "A")
    private String A;

    @JSONField(name = "B")
    private String B;

    @JSONField(name = "C")
    private String C;
}
