package jpabook.jpashop.repository;

import jpabook.jpashop.DTO.BookUpdateDTO;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item); //신규 등록
        }
    }

    public void updateItem(Long itemId, BookUpdateDTO bookUpdateDTO) {
        Item findItem = em.find(Item.class, itemId);
        findItem.setName(bookUpdateDTO.getBookName());
        findItem.setPrice(bookUpdateDTO.getBookPrice());
        findItem.setStockQuantity(bookUpdateDTO.getBookStockQuantity());
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
