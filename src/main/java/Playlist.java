/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author miguel
 */
public class Playlist {
    private static int lastId;
    private final int id;
    private  int authorId;
    private Music[] musics;
    private Genre[] genre;
    private int duration;

    // Metodos construtores;

    public Playlist(){
        this.id = ++lastId;
        this.authorId = -1;
        this.musics = new Music[0];
        this.genre = null;
    }

    public Playlist(Playlist p){
        this.id = ++lastId;
        this.authorId = p.authorId;
        this.musics = p.musics;
        this.genre = p.genre;
    }

    public Playlist(String author, Music[] musics, Genre[] genre){
        this.id = ++lastId;
        this.authorId = authorId;
        this.musics = musics;
        this.genre = genre;
    }

    // Metodos obrigatorios

    public boolean equals(Object o){
        if (this == o) return true;

        if (o == null || this.getClass() != o.getClass()) return false;

        Playlist p = (Playlist) o;

        return this.id == p.id && this.authorId == p.authorId && java.util.Arrays.equals(this.musics, p.musics);
    }

    public Playlist clone(){
        return new Playlist(this);
    }

    public String toString(){
        return "Playlist[id=" + this.id + ", authorId=" + this.authorId + ", musics=" + java.util.Arrays.toString(this.musics) + ", genre=" + java.util.Arrays.toString(this.genre) + ", duration=" + this.duration + "]";
    }

    // Metodos Set/Get

    public int getId(){
        return this.id;
    }

    public void setAuthorId(int authorId){
        this.authorId = authorId;
    }

    public int getAuthor(){
        return this.authorId;
    }

    public void setMusics(Music[] musics){
        this.musics = musics;
    }

    public Music[] getMusics(){
        return this.musics;
    }

    public void setGenre(Genre[] genre){
        this.genre = genre;
    }

    public Genre[] getgenre(){
        return this.genre;
    }

    public void setDuration(int duration){
        this.duration = duration;
    }

    public int getDuration(){
        return this.duration;
    }

    // metodos

    public void addMusic(Music m){
        Music[] newMusics = new Music[this.musics.length + 1];
        int i;
        for (i = 0; i < this.musics.length; i++){
            newMusics[i] =  this.musics[i];
        }
        newMusics[this.musics.length] = m.clone();
        this.addGenre(m.getGenre());
        this.musics = newMusics;
        this.setDuration(this.getDuration() + m.getDuration());
    }

    private void addGenre(Genre genre){
        if (!this.hasGenre(genre)){
            int len = (this.genre != null) ? this.genre.length : 0;
            Genre[] newGenres = new Genre[len+1];
            for(int i = 0; i < len; i++){
                newGenres[i] = this.genre[i];
            }
            newGenres[len] = genre;
            this.genre = newGenres;
        }
    }

    public boolean hasGenre(Genre genre){
        int len = (this.genre != null) ? this.genre.length : 0;
        for(int i = 0; i < len; i++){
            if (this.genre[i] == genre) return true;
        }
        return false;
    }
}