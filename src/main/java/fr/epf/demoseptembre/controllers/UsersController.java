package fr.epf.demoseptembre.controllers;

import fr.epf.demoseptembre.models.Offer;
import fr.epf.demoseptembre.models.User;
import fr.epf.demoseptembre.persistence.OfferDao;
import fr.epf.demoseptembre.persistence.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 10/09/2018
 */
@Controller
public class UsersController {

    private final UserDao userDao;
    private final OfferDao offerDao;

    public UsersController(UserDao userDao, OfferDao offerDao) {
        this.userDao = userDao; this.offerDao = offerDao;
    }

    /**
     * Ceci sera mappé sur l'URL '/users'.
     * C'est le routeur de Spring MVC qui va détecter et appeler directement cette méthode.
     * Il lui fournira un "modèle", auquel on pourra rajouter des attributs.
     * Ce modèle sera ensuite forwardé à une page web (dans resources/templates).
     * Le nom de la template est retourné par la fonction. Ici, elle appelle donc le template "users".
     *
     * @param model le modèle
     * @return
     */
    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("data", userDao.findAll());
        return "users-list";
    }

    @GetMapping("/adduser")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add_member";
    }

    @PostMapping("/user")
    public String addUser(User user, Model model) {
        userDao.save(user);
        return "redirect:/users";
    }

    @GetMapping("/addoffer")
    public String addOfferForm(Model model) {
        model.addAttribute("offer", new Offer());
        return "add_offer";
    }

    @PostMapping("/offer")
    public String addOffer(Offer offer, Model model) {
        offerDao.save(offer);
        return "redirect:/offers";
    }

    @GetMapping("/offers")
    public String getOffers(Model model) {
        model.addAttribute("data", userDao.findAll());
        return "announce-list";
    }

    @GetMapping("/test")
    public String gettest(Model model) {
        model.addAttribute("data", userDao.findAll());
        return "test";
    }

}
