package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
@Controller
public class AppController implements WebMvcConfigurer {
    @Autowired
    private UczenDAO uczenDao;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
    }

    @Controller
    public class DashboardController {
        @RequestMapping
                ("/main"
                )
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/main_admin";
            } else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/main_user";
            } else {
                return "redirect:/index";
            }
        }
    }

    @RequestMapping(value = {"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }

    @RequestMapping(value = {"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }

    @RequestMapping("/uczen_list")
    public String adminViewUczniowie(HttpServletRequest r, Model m) {
        m.addAttribute("admin", r.isUserInRole("ADMIN"));
        List<Uczen> u = uczenDao.list();
        m.addAttribute("uczenList", u);
        return "uczen_list";
    }

    @PostMapping("/dodaj_ucznia")
    public String dodajUcznia(  @RequestParam(name="imie") String imie,
                                @RequestParam(name="nazwisko") String nazwisko,
                                @RequestParam(name="pesel") String pesel,
                                @RequestParam(name="plec") String plec,
                                @RequestParam(name="dataurodzenia") String data){

        Uczen u = new Uczen();
        u.setImie(imie);
        u.setNazwisko(nazwisko);
        u.setDataUrodzenia(data);
        u.setPESEL(pesel);
        u.setPlec(plec);
        uczenDao.save(u);
        return "redirect:/uczen_list";
    }
}