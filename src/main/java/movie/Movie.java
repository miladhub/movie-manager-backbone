package movie;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

	private String title;
	private Integer year;
	private String language;
	private String author;
	private String category;
	private @XmlElement List<Review> reviews = new ArrayList<>();

	public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getLanguage() {
        return language;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public String toString() {
    	return "Title: " + title +
    			", year: " + year +
    			", category: " + category;
    }
}
