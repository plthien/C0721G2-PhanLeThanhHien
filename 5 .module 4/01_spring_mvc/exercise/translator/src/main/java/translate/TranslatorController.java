package translate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class TranslatorController {
    @GetMapping("")
    public String showHome(){
        return "home";
    }
    @GetMapping("/translate")
    public String translate(@RequestParam("english") String english, Model model){
        Map<String,String> dictonary = new HashMap<>();
        dictonary.put("book","Quyển Sách");
        dictonary.put("table","Cái Bàn");
        dictonary.put("student","Học sinh");
        dictonary.put("teacher","Giáo viên");

        Set<String> keySet = dictonary.keySet();
        for (String key: keySet) {
            if (key.contains(english)){
                model.addAttribute("vietnamese",dictonary.get(key));
                model.addAttribute("english",key);
                break;
            }
        }

        return "home";
    }
}
