import java.util.ArrayList;

public class Playlist {
    public static void main(String[] args) {
        ArrayList<String> desertIslandPlaylist = new ArrayList<String>();
        desertIslandPlaylist.add("hum tum");
        desertIslandPlaylist.add("rockOn");
        desertIslandPlaylist.add("heartbreak");
        desertIslandPlaylist.add("Sadda haq");
        desertIslandPlaylist.add("hymn");
        desertIslandPlaylist.add("the weekend");
        
        System.out.println(desertIslandPlaylist);
        
        System.out.println(desertIslandPlaylist.size());
        desertIslandPlaylist.remove("hum tum");
        System.out.println(desertIslandPlaylist.size());
        
        int rockOn = desertIslandPlaylist.indexOf("rockOn");
        int hymn = desertIslandPlaylist.indexOf("hymn");
        System.out.println(rockOn+ " " +hymn);
        
        String tempA = "rockOn";
        desertIslandPlaylist.set(rockOn,"hymn");
        
        desertIslandPlaylist.set(hymn,"rockOn");
        


    }
}
