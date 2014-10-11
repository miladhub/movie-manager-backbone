package movie;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/movies")
public class MovieResource {
	@Inject
	private MovieRepository model;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<MovieModel> findAll() {
		System.out.println("findAll");
		return MovieModel.fromMovies(model.findAll());
	}

	@GET @Path("search/{query}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public MovieModel findByName(@PathParam("query") String query) {
		System.out.println("findByName: " + query);
		return MovieModel.fromMovie(model.findByTitle(query));
	}
}
