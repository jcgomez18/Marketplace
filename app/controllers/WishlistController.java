package controllers;
 
import dispatchers.AkkaDispatcher;
import java.util.concurrent.CompletableFuture;
import static play.libs.Json.toJson;
import models.WishlistEntity;
import akka.dispatch.MessageDispatcher;
import play.mvc.*;
import java.util.concurrent.CompletionStage;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
 
public class WishlistController  extends Controller  
{
	
	
	public CompletionStage<Result> getWishlists() {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;
 
        return CompletableFuture.
                supplyAsync(
                        () -> {
                            return WishlistEntity.FINDER.all();
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        wishlistEntities -> {
                            return ok(toJson(wishlistEntities));
                        }
                );
    }
	
	public CompletionStage<Result> getWishlist(Long id) {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;
 
        return CompletableFuture.
                supplyAsync(
                        () -> {
                            return WishlistEntity.FINDER.byId(id);
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        wishlistEntities -> {
                            return ok(toJson(wishlistEntities));
                        }
                );
    }
	
	public CompletionStage<Result> createWishlist(){
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;
        JsonNode nWishlist = request().body().asJson();
        WishlistEntity wishlist = Json.fromJson( nWishlist , WishlistEntity.class ) ;
        return CompletableFuture.supplyAsync(
                ()->{
                    wishlist.save();
                    return wishlist;
                }
        ).thenApply(
        		wishlistEntity -> {
                    return ok(Json.toJson(wishlistEntity));
                }
        );
    }
}
