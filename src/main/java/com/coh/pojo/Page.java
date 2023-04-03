package com.coh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    private Integer pageNum;//当前页
    private Integer pageSize=5;
    private Integer countPage;//总页数
    private Integer countRow;//总行数
}
