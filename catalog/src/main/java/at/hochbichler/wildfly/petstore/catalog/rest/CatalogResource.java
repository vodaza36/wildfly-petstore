package at.hochbichler.wildfly.petstore.catalog.rest;


import at.hochbichler.wildfly.petstore.catalog.rest.model.Item;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.HashMap;
import java.util.Map;


@Path("/")
public class CatalogResource {

	@Inject
	private CatalogService catalogService;

	@GET
	@Path("item/{itemId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchById(@PathParam("itemId") String itemId) {
		try {
			Item item = catalogService.searchById(itemId);
			return Response.ok(item).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
}
