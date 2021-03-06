package blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import blog.model.Article;
import blog.model.ArticleRepository;

@Controller
@RequestMapping(path="/api/article")
public class ApiArticleController {

    @Autowired // This means to get the bean called articleRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ArticleRepository articleRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addArticle (
              @RequestParam String title
            , @RequestParam String content
            , @RequestParam String author) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Article n = new Article();
        n.setTitle(title);
        n.setContent(content);
        n.setAuthor(author);
        articleRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Article> getAllArticle() {
        // This returns a JSON or XML with the articles
        return articleRepository.findAll();
    }
}