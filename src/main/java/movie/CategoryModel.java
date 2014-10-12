package movie;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CategoryModel {
	public final String name;
	@SuppressWarnings("unused")
	private CategoryModel() { this(null); }
	public CategoryModel(String name) {
		super();
		this.name = name;
	}
	public static CategoryModel fromMovie(Movie movie) {
		return new CategoryModel(movie.getCategory());
	}
	public static Set<CategoryModel> fromMovies(List<Movie> movies) {
		Set<CategoryModel> categories = new HashSet<>();
		for (Movie movie : movies) {
			categories.add(fromMovie(movie));
		}
		return categories;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryModel other = (CategoryModel) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
