package com.sugarbox.jellyframeworktools.poi.dto;

import lombok.Data;

import java.util.List;

@Data
public class SampleTree {

    private String addressId;

    private String addressName;

    private String parentId;

    private List<SampleTree> children;
}
