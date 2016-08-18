package controllers;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;
import models.Ciudad;
import models.Product;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;


public class ProductoController extends Controller {

    @BodyParser.Of(BodyParser.Json.class)
    public Result create() {
        JsonNode j = Controller.request().body().asJson();
        Product product = Product.bind(j);
        product.save();
        return ok(Json.toJson(product));
    }

    public Result read() {
        List<Product> productos = new Model.Finder(String.class, Product.class).all();
        return ok(Json.toJson(productos));
    }
}
