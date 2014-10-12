package movie;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MovieModel {
	public final String title, author;
	public final int stars, year;
	@SuppressWarnings("unused")
	private MovieModel() { this(null, null, 0, 0); }
	public MovieModel(String title, String author, int stars, int year) {
		super();
		this.title = title;
		this.author = author;
		this.stars = stars;
		this.year = year;
	}
	public static MovieModel fromMovie(Movie movie) {
		return new MovieModel(movie.getTitle(), movie.getAuthor(), sumOfStars(movie), movie.getYear());
	}
	private static int sumOfStars(Movie movie) {
		int stars = 0;
		for (Review review : movie.getReviews()) {
			stars += review.getStars();
		}
		return stars;
	}
	public static List<MovieModel> fromMovies(List<Movie> movies) {
		List<MovieModel> models = new ArrayList<>();
		for (Movie movie : movies) {
			models.add(fromMovie(movie));
		}
		return models;
	}
}
