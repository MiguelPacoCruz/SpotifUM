public class DataManager {

    // pra ja tou a por em arrays mas se calhar usamos os ids em uso!

    // TODO escolher o banco de dados (ver pptx 5) e alterar isso as instancias.

    // variaveis de instancia

    private static Music[] musicas;
    private static int numMusicas;
    private static Playlist[] playlists;
    private static int numPlaylists;
    private static User[] users;
    private static int numUsers;

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

    public static Music[] getMusicas() {
        return musicas;
    }
    public static Playlist[] getPlaylists() {
        return playlists;
    }
    public static User[] getUsers() {
        return users;
    }

    //ainda nao sei como querem fazer isto...
    public static void addMusic(Music m){
        Music[] newMusicas = new Music[musicas.length + 1];
        System.arraycopy(musicas, 0, newMusicas, 0, musicas.length);
        newMusicas[musicas.length] = m.clone();
        musicas = newMusicas;
        numMusicas ++;
    }

    public static void addPlaylist(Playlist p){
        Playlist[] newPlaylists = new Playlist[playlists.length + 1];
        System.arraycopy(playlists, 0, newPlaylists, 0, playlists.length);
        newPlaylists[playlists.length] = p.clone();
        playlists = newPlaylists;
        numPlaylists ++;
    }

    public static void addUser(User u){
        if (numUsers > 0) {
            User[] newUsers = new User[users.length + 1];
            System.arraycopy(users, 0, newUsers, 0, users.length);
            newUsers[users.length] = u.clone();
            users = newUsers;
            numUsers ++;
        }
        else {
            User[] newUsers= new User[1];
            newUsers[0] = u.clone();
            users = newUsers;
            numUsers ++;
        }
    }

    public static void removeMusic(int id){
        Music[] newMusicas = new Music[musicas.length - 1];
        int i;
        for (i = 0; i < musicas.length; i++){
            if (musicas[i].getId() == id) break;
        }
        System.arraycopy(musicas, 0, newMusicas, 0, i);
        System.arraycopy(musicas, i+1, newMusicas, i, musicas.length - i - 1);
        musicas = newMusicas;
        numMusicas --;
    }

    public static void removePlaylist(int id){
        Playlist[] newPlaylists = new Playlist[playlists.length - 1];
        int i;
        for (i = 0; i < playlists.length; i++){
            if (playlists[i].getId() == id) break;
        }
        System.arraycopy(playlists, 0, newPlaylists, 0, i);
        System.arraycopy(playlists, i+1, newPlaylists, i, playlists.length - i - 1);
        playlists = newPlaylists;
        numPlaylists --;
    }

    public static void removeUser(int id){
        User[] newUsers = new User[users.length - 1];
        int i;
        for (i = 0; i < users.length; i++){
            if (users[i].getId() == id) break;
        }
        System.arraycopy(users, 0, newUsers, 0, i);
        System.arraycopy(users, i+1, newUsers, i, users.length - i - 1);
        users = newUsers;
        numUsers--;
    }

    public static int getUserId(String email){
        if (email == null || numUsers < 1) return -1;
        for (User user : users) {
            if (user.getEmail().equals(email)) return user.getId();
        }
        return -1;
    }
}