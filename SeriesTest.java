package tvseriesapp.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import tvseriesapp.Series;

public class SeriesTest {

    @Test
    public void testGetSeriesInfo_Success() {
        Series series = new Series(201, "The Crown", 40, 16, "Historical Drama");
        String info = series.getSeriesInfo();
        assertTrue(info.contains("The Crown"));
        assertTrue(info.contains("40"));
        assertTrue(info.contains("16"));
        assertTrue(info.contains("Historical Drama"));
    }

    @Test
    public void testGetSeriesInfo_Failure() {
        Series series = new Series(202, "Brooklyn Nine-Nine", 153, 13, "Comedy");
        String info = series.getSeriesInfo();
        assertFalse(info.contains("The Crown"));     // wrong title
        assertFalse(info.contains("Historical Drama")); // wrong genre
    }

    @Test
    public void testIsSuitableForAge_Success() {
        Series series = new Series(203, "Paw Patrol", 120, 2, "Kids");
        assertTrue(series.isSuitableForAge(5));  // suitable for kids
    }

    @Test
    public void testIsSuitableForAge_Failure() {
        Series series = new Series(204, "Peaky Blinders", 36, 18, "Crime Drama");
        assertFalse(series.isSuitableForAge(15)); // too young
    }

    @Test
    public void testUpdateEpisodes_Success() {
        Series series = new Series(205, "The Mandalorian", 16, 13, "Sci-Fi");
        Series updated = series.updateEpisodes(20);
        assertEquals(20, updated.getEpisodes());  // updated episodes
        assertEquals(series.getTitle(), updated.getTitle()); // title unchanged
    }

    @Test
    public void testUpdateEpisodes_Failure() {
        Series series = new Series(206, "Sherlock", 13, 16, "Mystery");
        Series updated = series.updateEpisodes(14);
        assertNotEquals(13, updated.getEpisodes());  // should have changed
    }
}