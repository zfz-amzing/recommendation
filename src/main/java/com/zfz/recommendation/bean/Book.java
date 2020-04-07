package com.zfz.recommendation.bean;

import lombok.Data;

@Data
public class Book {
    private Integer bookId;
    private Integer bookTypeId;
    private String bookName;
    private String imgSrc;
    private String author;
    private Integer view;
    private String introduce;

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTypeId=" + bookTypeId +
                ", bookName='" + bookName + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", author='" + author + '\'' +
                ", view=" + view +
                '}';
    }
}
