package com.shoxxie.eegcontroller.Controller;

import com.shoxxie.eegcontroller.model.ModelEeg;
import com.shoxxie.eegcontroller.repository.EegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Optional;

@RestController
@RequestMapping("/eeg")
public class EegController {

    private final EegRepository eegRepository;

    @Autowired
    public EegController(EegRepository eegRepository) {
        this.eegRepository = eegRepository;
    }

    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @GetMapping("/{username}/{electrodeNumber}")
    public String showEegChart(
            @RequestParam("username") String username,
            @RequestParam("electrodeNumber") Integer electrodeNumber,
            Model model
            ){

        Optional<ModelEeg> modelEegOptional = Optional.ofNullable(eegRepository.findByUsernameAndElectrodeNumber(username, electrodeNumber));

        if(modelEegOptional.isEmpty()){
            return "error";
        }

        ModelEeg record = modelEegOptional.get();
        String base64Image = record.getImage();
        byte[] imageData = Base64.getDecoder().decode(base64Image);
        model.addAttribute("imageData", imageData);

        return "index";
    }
}
