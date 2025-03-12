public class DataManager {

    // pra ja tou a por em arrays mas se calhar usamos os ids em uso!

    // TODO escolher o banco de dados (ver pptx 5) e alterar isso as instancias.

    // variaveis de instancia

    private Music[] musicas;
    private int numMusicas;
    private Playlist[] playlists;
    private int numPlaylists;
    private User[] users;
    private int numUsers;

    // metodos de criaçao

    public DataManager() {  // criaçao inicial, depois ver como podemos criar isso com um ficheiro
        numMusicas = 0;
        numPlaylists = 0;
        numUsers = 0;
        musicas = new Music[10];
        playlists = new Playlist[10];
        users = new User[10];
    }

    // metodos get/set

    //ainda nao sei como querem fazer isto...



}
