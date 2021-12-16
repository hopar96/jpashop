package jpabook.jpashop.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookUpdateDTO {
    private String bookName;
    private int bookPrice;
    private int bookStockQuantity;
}
