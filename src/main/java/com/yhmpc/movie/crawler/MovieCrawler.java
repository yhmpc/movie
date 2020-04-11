package com.yhmpc.movie.crawler;

import com.yhmpc.movie.domain.jpa.MovieDb;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @Author yhm
 * @Date 4/11/2020 16:35
 */
@Component
public class MovieCrawler {

    @Value("${douban.movie.url}")
    private String baseUrl;

    private static int count = 0;

    private LinkedHashSet<String> retryLinks = new LinkedHashSet<>();

    private List<MovieDb> movies = new ArrayList<>();

    public List<MovieDb> crawler() {
        for (int i = 0; i <= 250; i += 25) {
            retryLinks.add(baseUrl + i);
        }
        doRetry(retryLinks);
        return movies;
    }

    /**
     * 爬1次, 重试5次
     *
     * @param retryLinks
     */
    private void doRetry(LinkedHashSet<String> retryLinks) {
        if (CollectionUtils.isEmpty(retryLinks)) {
            return;
        }
        count++;
        if (count >= 5) {
            return;
        }
        List<String> urls = new ArrayList<>(retryLinks);
        retryLinks = new LinkedHashSet<>();
        for (String url : urls) {
            try {
                Document doc = Jsoup.connect(url).get();
                parsePage(doc);
            } catch (IOException e) {
                e.printStackTrace();
                retryLinks.add(url);
            }
        }
        doRetry(retryLinks);
    }

    // 解析页面
    private void parsePage(Document doc) {
        Elements elements = doc.body().select("ol").attr("class", "grid_view").select("li");
        if (CollectionUtils.isEmpty(elements)) {
            return;
        }
        for (Element element : elements) {
            parseSingleMovie(element);
        }
    }

    // 解析单部电影
    private void parseSingleMovie(Element li) {
        Elements titles = li.select("div[class=info] div[class=hd] span[class=title]");
        String firstTitle = titles.get(0).text();
        String secondTitle = "";
        if (titles.size() > 1) {
            secondTitle = titles.get(1).text().replaceAll(".*/ (.*)", "$1");
        }
        String rankString = li.select("div[class=pic]").select("em").text();
        Elements bd = li.select("div[class=info] div[class=bd]");
        String p = bd.select("p").get(0).html().split("<br> ")[1];
        String parse = Jsoup.parse(p).text();
        String yearString = parse.split(" / ")[0];
        String country = parse.split(" / ")[1];
        String type = parse.split(" / ")[2];
        Elements spans = bd.select("div[class=star] span");
        String scoreString = spans.get(1).text();
        String votesString = spans.get(3).text().replaceAll("(\\d+).*", "$1");
        String quote = "";
        if (bd.select("p").size() > 1) {
            quote = bd.select("p").get(1).text();
        }
        String image = li.select("div[class=pic] a img").attr("src");

        MovieDb movieDb = new MovieDb();
        movieDb.setRank(Integer.parseInt(rankString));
        movieDb.setFirstTitle(firstTitle);
        movieDb.setSecondTitle(secondTitle);
        movieDb.setYear(DateUtil.string2Date(yearString));
        movieDb.setCountry(country);
        movieDb.setType(type);
        movieDb.setScore(Double.parseDouble(scoreString));
        movieDb.setVotes(Long.parseLong(votesString));
        movieDb.setQuote(quote);
        movieDb.setImage(image);
        // 特殊处理 55
        if (movieDb.getRank() == 55) {
            movieDb.setCountry("中国大陆");
            movieDb.setYear(DateUtil.string2Date("1964"));
        }
        movies.add(movieDb);
    }

}
