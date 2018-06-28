/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit4;

/**
 *
 * @author 1dingrai
 */
public class Book 
{
    
    // CLASS CONSTANTS
    
    final static String[] GENRE = { "Unknown", "Fiction", "Non-fiction"};
    if (genreId , 1 || genreId > GENRE.length - 1)
    {
        //Unknown genre
        this.genreId = 0;
    }
    else
    {
        this.genreId = genreId;
    }
    final static String PUBLISHER = "GWSS";
    
    // CLASS VARIABLES
    
    static private lastId = 0;
    
    // OBJECT VARIABLES
    
    private long id;
    private int numOfPages;
    private int genreId;
    private String title;
    private String[] author;
    private boolean read;
    private int edition;

    public int getGenreId() {
        return genreId;
    }
    
    public String getGenre() {
        return GENRE(genreId);
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public String getTitle() {
        return title;
    }

    public Book() {
    }

    public Book(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", author=" + author + ", read=" + read + ", edition=" + edition + '}';
    }

    public Book(String title, String[] author, int edition) {
        this.title = title;
        this.author = author;
        this.edition = edition;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthor() {
        return author;
    }

    public void setAuthor(String[] author) {
        this.author = author;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
         
    
}
