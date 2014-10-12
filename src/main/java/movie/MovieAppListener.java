package movie;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.annotation.WebListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.io.FileUtils;

@WebListener
public class MovieAppListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {

        Movie bladeRunner = new Movie();
        bladeRunner.setAuthor("Ridley Scott");
        bladeRunner.setYear(1982);
        bladeRunner.setLanguage("English");
        bladeRunner.setTitle("Blade Runner");
        bladeRunner.setCategory("Sci Fi");
        bladeRunner.setReviews(Arrays.asList(new Review("Foo", "Awesome", 200)));

        createFile(bladeRunner);

        Movie darkly = new Movie();
        darkly.setAuthor("Richard Linklater");
        darkly.setYear(2006);
        darkly.setLanguage("English");
        darkly.setTitle("A Scanner Darkly");
        darkly.setCategory("Sci Fi");
        darkly.setReviews(Arrays.asList(new Review("Foo", "Gorgeous", 100)));

        createFile(darkly);

        Movie shining = new Movie();
        shining.setAuthor("Stanley Kubrick");
        shining.setYear(1975);
        shining.setLanguage("English");
        shining.setTitle("The Shining");
        shining.setCategory("Thriller");
        shining.setReviews(Arrays.asList(new Review("Foo", "Great", 100), new Review("Bar", "Good", 50)));

        createFile(shining);
    }

    private void createFile(Movie bladeRunner) {
        File folder = new File(System.getProperty("user.home"), ".movies");
        File file = new File(folder, bladeRunner.getTitle() + ".xml");
        if (!file.exists()) {
            try {
                FileUtils.touch(file);
                JAXBContext context = JAXBContext.newInstance(Movie.class);
                Marshaller m = context.createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                m.marshal(bladeRunner, file);
            } catch (JAXBException | IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }
}