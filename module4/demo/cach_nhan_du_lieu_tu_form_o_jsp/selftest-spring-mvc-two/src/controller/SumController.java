package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.SumService;

@Controller
public class SumController {

    @Autowired
    private SumService sumService;

    @GetMapping({"", "/sum2Num"})
    public String sum2Num(@RequestParam String number1,
                          @RequestParam(value = "number2") String num2,
                          Model model) {
        int resultFinal = sumService.sum2Number(Integer.parseInt(number1), Integer.parseInt(num2));
        model.addAttribute("resultSum", resultFinal);

        return "result";
    }
}
