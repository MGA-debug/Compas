package ru.appline.controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.appline.logic.Model;
import ru.appline.utils.JsonHelper;

import java.util.Map;

@RestController
public class Controller {
    private static Model model = Model.getInstance();

    @PostMapping(value = "/setCoordinates", consumes = "application/json", produces = "application/json")
    public String setCoordinates(@RequestBody Map<String, String> coordinates) {
        String result;
        if (model.fillIn(coordinates)) {
            result = "All right";
        } else {
            result = "Invalid data";
        }
        return result;
    }

    @GetMapping(value = "/searchResult", consumes = "application/json", produces = "application/json")
    public JSONObject searchResult(@RequestBody Map<String, Integer> coordinates) {
        return JsonHelper.getHelper().getResult(Model.searchSide(coordinates.get("Degree")));
    }
}
