package nl.han.oose;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("items")
public class ItemResource {

    // don't do this at home. Use databases or other repositories instead
    private static Map<String, Item> itemMap = new HashMap<>();

    public ItemResource() {
        itemMap.put("123", new Item("Auto", "123"));
        itemMap.put("124", new Item("Kaas", "124"));
        itemMap.put("125", new Item("Frikandel", "125"));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addItem(Item item) {
        itemMap.put(item.getSku(), item);
        return Response.ok(item).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemList() {
        return Response.ok(itemMap.values()).build();
    }


    @GET
    @Path("/{sku}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonItem(@PathParam("sku") String sku) {
        Item item = itemMap.get(sku);
        if (item != null) {
            return Response.ok(item).build();
        } else {
            ItemResourceError itemResourceError = new ItemResourceError(Response.Status.NOT_FOUND.toString(),
                    "Entity not found: " + sku);
            return Response.status(Response.Status.NOT_FOUND).entity(itemResourceError).build();
        }
    }


}
