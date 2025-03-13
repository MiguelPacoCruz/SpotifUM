/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author miguel
 */

// constantes

enum Genre{  //coloquei mais generos
    Pop,
    Rock,
    Classic,
    Jazz,
    Electronic,
    Rap,
    Country,
    Funk
}




public class Music {

    //variaveis

    private static int lastId;
    private final int id;
    private String name;
    private String interpreter;
    private String editor;
    private String[] lyrics;
    private String[] music;
    private Genre genre;
    private int duration;
    private int listens;
    private boolean explicit;

    // metodos de criaçao

    public Music(){
        this.id = ++lastId;
        this.name = "";
        this.interpreter = "";
        this.editor = "";
        this.lyrics = new String[0];
        this.music = new String[0];
        this.genre = null;
        this.duration = -1;
        this.listens = -1;
        this.explicit = false;
    }

    public Music(Music m) {
        this.id = ++lastId;
        this.name = m.name;
        this.interpreter = m.interpreter;
        this.editor = m.editor;
        this.lyrics = m.lyrics;
        this.music = m.lyrics;
        this.genre = m.genre;
        this.duration = m.duration;
        this.listens = m.listens;
        this.explicit = isExplicit();
    }

    public Music(String name, String interpreter, String editor, String[] lyrics, String[] music, Genre genre, int duration, int listens) {
        this.id = ++lastId;
        this.name = name;
        this.interpreter = interpreter;
        this.editor = editor;
        this.lyrics = lyrics;
        this.music = music;
        this.genre = genre;
        this.duration = duration;
        this.listens = listens;
        this.explicit = isExplicit();
    }

    // metodos set/get

    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setinterpreter(String interpreter){
        this.interpreter = interpreter;
    }

    public String getinterpreter(){
        return this.interpreter;
    }

    public void setEditor(String editor){
        this.editor = editor;
    }

    public String getEditor(){
        return this.editor;
    }

    public void setLyrics(String[] lyrics){
        this.lyrics = lyrics;
    }

    public String[] getLyrics(){
        return this.lyrics;
    }

    public void setMusic(String[] music){
        this.music = music;
    }

    public String[] getMusic(){
        return this.music;
    }

    public void setGenre(Genre genre){
        this.genre = genre;
    }

    public Genre getGenre(){
        return this.genre;
    }

    public void setDuration(int duration){
        this.duration = duration;
    }

    public int getDuration(){
        return this.duration;
    }

    public void setListens(int listens){
        this.listens = listens;
    }

    public int getListens(){
        return this.listens;
    }

    // metodos obrigatorios

    public String toString(){
        return "Music[id=" + this.id + ", name=" + this.name + ", interpreter="+ this.interpreter + ", editor="+ this.editor + ", lyrics=" + java.util.Arrays.toString(this.lyrics) + ", music=" + java.util.Arrays.toString(this.music) + ", genre=" + this.genre + ", duration=" + this.duration + ", listens=" +this.listens + "]";
    }

    public Music clone(){
        return new Music(this);
    }

    public boolean equals(Object o){
        if (this == o) return true;

        if (o == null || this.getClass() != o.getClass()) return false;

        Music m = (Music) o;
        return this.name.equals(m.name) && this.interpreter.equals(m.interpreter) && this.editor.equals(m.editor) && java.util.Arrays.equals(this.lyrics, m.lyrics) && java.util.Arrays.equals(this.music, m.music) && this.genre.equals(m.genre) && this.duration == m.duration && this.listens == m.listens;
    }

    // metodos

    public void play(){
        this.listens += 1;
        System.out.println(Arrays.toString(lyrics));
    }
    private List<String> loadExplicitWords(String filePath) {
        List<String> explicitWords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Add each word from the file to the list
                explicitWords.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            System.err.println("Error reading explicit words file: " + e.getMessage());
        }
        return explicitWords;
    }

    private boolean isExplicit(){
        List<String> explicitWords = loadExplicitWords("src/main/resources/explicit.txt");
        for (String lyric : lyrics) {
            for (String keyword : explicitWords) {
                if (lyric.toLowerCase().contains(keyword.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

}