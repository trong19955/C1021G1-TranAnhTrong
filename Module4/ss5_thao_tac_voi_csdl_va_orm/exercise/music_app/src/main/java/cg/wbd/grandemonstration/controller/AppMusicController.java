package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.AppMusic;
import cg.wbd.grandemonstration.service.IAppMusicService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("appMusics")
public class AppMusicController {
    @Autowired
    private IAppMusicService iAppMusicService;

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("appMusics/list");
        List<AppMusic> appMusics = iAppMusicService.findAll();
        modelAndView.addObject("appMusics", appMusics);
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("appMusics/info");
        AppMusic appMusic = iAppMusicService.findOne(id);
        modelAndView.addObject("appMusic", appMusic);
        return modelAndView;
    }

    @PostMapping
    public String updateAppMusic(AppMusic appMusic) {
        iAppMusicService.save(appMusic);
        return "redirect:/appMusics";
    }
}
