package models;
 
import javax.persistence.*;
import com.avaje.ebean.Model;
 
@Entity
@Table(name = "wishlistentity")
public class WishlistEntity extends Model{
 
    public static Finder<Long,WishlistEntity> FINDER = new Finder<>(WishlistEntity.class);
 
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "Wishlist")
    private Long id;
    private String username;
  
 
    public WishlistEntity() {
        this.id=null;
        this.username ="NO NAME";
       
    }
 
    public WishlistEntity(Long id) {
        this();
        this.id = id;
    }
 
    public WishlistEntity(Long id, String username) {
        this.id = id;
        this.username = username;
 
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
   
    @Override
    public String toString() {
        return "WhishlistEntity{" +
                "id=" + id +
                ", username='" + username +
                '}';
    }
}