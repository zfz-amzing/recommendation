package com.zfz.recommendation.bean;

import lombok.Data;

@Data
public class Rate {
    private Integer user_id;
    private Integer book_id;
    private Integer rate;
}
