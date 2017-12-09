package e.shaniadir.myapplication;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by shaniadir on 12/2/17.
 */

public class Functionality {
    public static String getFirstResult(String response){
        String title = "";
        Document htmlResponse = Jsoup.parse(response);
        Elements res = htmlResponse.select("a._Olt");
        if(res.size() == 0){
            title = "No results";
        }
        else{
            title = res.first().text();
        }
        return title;
    }
}
