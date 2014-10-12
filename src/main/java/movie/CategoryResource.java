package movie;

import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/categories")
public class CategoryResource {
	@Inject
	private MovieRepository model;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Set<CategoryModel> findAll() {
		return CategoryModel.fromMovies(model.findAll());
	}

	@GET @Path("search/{query}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public CategoryModel findByName(@PathParam("query") String query) {
		return CategoryModel.fromMovie(model.findByTitle(query));
	}
}
