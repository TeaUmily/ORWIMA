package hr.ferit.tumiljanovic.osnoverwima_lv1;

import android.view.View;

public class Person  {

    private String name;
    private String surname;
    private int birthYear;
    private int deathYear;
    private String description;
    private int image;
    private String quote;

    public Person(String name, String surname, int birthYear, int deathYear, String description, int image, String quote) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.description = description;
        this.image = image;
        this.quote = quote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }


    public String getYears() {
        return String.valueOf(birthYear) + "-" + String.valueOf(deathYear);
    }

    public String getFullName() {
        return name + " " + surname;
    }
}
