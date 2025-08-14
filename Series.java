package tvseriesapp;

public class Series {

    //Private fields (for information hiding)
    private int seriesID;
    private String title;
    private int episodes;
    private int ageRestriction;
    private String genre;

    //Constructor to initialize all fields
    public Series(int seriesID, String title, int episodes, int ageRestriction, String genre) {
        this.seriesID = seriesID;
        this.title = title;
        this.episodes = episodes;
        this.ageRestriction = ageRestriction;
        this.genre = genre;
    }

    //Getters
    public int getSeriesID() {
        return seriesID;
    }
    public String getTitle() {
        return title;
    }

    public int getEpisodes() {
        return episodes;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public String getGenre() {
        return genre;
    }

    //Method to display series info
    public String getSeriesInfo() {
        return "ID: " + seriesID + "Title: " + title + " | Episodes: " + episodes + " | Age Restriction: " + ageRestriction + "+ | Genre: " + genre;
    }

    //Method to check if series is suitable for given age
    public boolean isSuitableForAge(int age) {
        return age >= ageRestriction;
    }

    //Method to create a new Series object with updated episodes
    public Series updateEpisodes(int newEpisodes) {
        return new Series(this.seriesID, this.title, newEpisodes, this.ageRestriction, this.genre);
    }

    //Method to create a new Series object with updated age restriction
    public Series updateAgeRestriction(int newAgeRestriction) {
        return new Series(this.seriesID, this.title, this.episodes, this.ageRestriction, this.genre);
    }
}