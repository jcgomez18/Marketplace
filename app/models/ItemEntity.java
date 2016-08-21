package models;
 
import javax.persistence.*;
import com.avaje.ebean.Model;
 
@Entity
@Table(name = "itementity")
public class ItemEntity extends Model{
 
    public static Finder<Long,ItemEntity> FINDER = new Finder<>(ItemEntity.class);
 
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "Item")
    private Long id;
    private Long product_id;
    private Long wishlist_id;
    private Integer quantity;
 
    public ItemEntity() {
        this.id=null;
        this.product_id=null;
        this.wishlist_id=null;
        this.quantity = -1;
    }
 
    public ItemEntity(Long id) {
        this();
        this.id = id;
    }
 
    public ItemEntity(Long id, Long product_id, Long wishlist_id, Integer quantity) {
        this.id = id;
        this.product_id = product_id;
        this.wishlist_id = wishlist_id;
        this.quantity = quantity;
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public Long getProductId() {
        return product_id;
    }
 
    public void setProductId(Long product_id) {
        this.product_id = product_id;
    }
    
    public Long getWishlistId() {
        return wishlist_id;
    }
 
    public void setWishlistId(Long wishlist_id) {
        this.wishlist_id = wishlist_id;
    }
 
    public Integer getQuantity() {
        return quantity;
    }
 
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
 
    @Override
    public String toString() {
        return "ItemEntity{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", wishlist_id=" + wishlist_id +
                ", quantity=" + quantity +
                '}';
    }
}