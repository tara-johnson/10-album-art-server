import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class AlbumScraper {
    public static void main(String[] args) {
        getAlbumArtUrl("spice girls");
    }

    public static String getAlbumArtUrl(String query) {
        try {
            String url = "https://www.discogs.com/search/?q=" + query + "&type=all";
            Document doc = Jsoup.connect(url).get();
            Elements albumCovers = doc.select(".thumbnail_center");
            Element span = albumCovers.get(0);
            Element img = span.child(0);
            String src = img.attr("data-src");
            System.out.println("String src: " + src);
            return src;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "C:\\Users\\tbeth\\iCloudDrive\\Desktop\\code-fellows\\java-401d1\\labs\\10-SearchDiscogs\\src\\main\\resources\\static\\images\\no_image.png";
    }
}