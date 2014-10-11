package movie;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MovieModel {
	public final String title, author;
	public final int rates;
	@SuppressWarnings("unused")
	private MovieModel() { this(null, null, 0); }
	public MovieModel(String title, String author, int rates) {
		super();
		this.title = title;
		this.author = author;
		this.rates = rates;
	}
	public static MovieModel fromMovie(Movie movie) {
		return new MovieModel(movie.getTitle(), movie.getAuthor(), movie.getReviews().size() * 100);
	}
	public static List<MovieModel> fromMovies(List<Movie> movies) {
		List<MovieModel> models = new ArrayList<>();
		for (Movie movie : movies) {
			models.add(fromMovie(movie));
		}
		return models;
	}
}
