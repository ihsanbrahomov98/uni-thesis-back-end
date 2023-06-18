package com.arjuncodes.studentsystem.controller.SitterController;

import com.arjuncodes.studentsystem.model.SitterModel.Sitter;
import com.arjuncodes.studentsystem.service.SitterService.SitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sitters")
@CrossOrigin
public class SitterController {
    @Autowired
    private SitterService sitterService;

    @GetMapping("/all")
    public List<Sitter> getAllSitters(){
        return sitterService.getAllSitter();
    }

    @GetMapping("/category/filter/all/filter/{cat}/{filter1}/{filter2}/{filter3}/{filter4}/{filter5}/{filter6}")
    public List<Sitter>  listByCategoryAndFilter(@PathVariable("filter1")  String  fitler1, @PathVariable("filter2")
    String  filter2, @PathVariable("filter3")  String  filter3, @PathVariable("filter4")
    String  filter4, @PathVariable("filter5")  String  filter5, @PathVariable("filter6")  String  filter6 ){
        return  sitterService.filerSitter("all",fitler1,filter2,filter3,filter4,filter5,filter6);
    }
//    @GetMapping("/category/{cat}")
//    public List<Sitter> listByCategory(@PathVariable("cat") String  cat){
////    return  sitterService.getAllSitter().stream().filter(e -> e.getCategory().equals(cat)).collect(Collectors.toList());
//        return null;
//    }
//
//    @GetMapping("/category/filter/{cat}/{filter1}/{filter2}/{filter3}/{filter4}/{filter5}/{filter6}")
//    public List<Sitter>  listByCategoryAndFilter(@PathVariable("cat") String  cat, @PathVariable("filter1")  String  fitler1, @PathVariable("filter2")  String  filter2, @PathVariable("filter3")  String  filter3,
//                                                 @PathVariable("filter4")  String  filter4, @PathVariable("filter5")  String  filter5, @PathVariable("filter6")  String  filter6 ){
//     return  sitterService.filerSitter(cat,fitler1,filter2,filter3,filter4,filter5,filter6);
//
//    }
    @GetMapping("/findone/{id}")
    public Sitter getSitterById(@PathVariable("id") Long  sitterId){
        return sitterService.fetchSitterById(sitterId);
    }

    @PostMapping("/create")
    public Sitter createSitter(@RequestBody Sitter sitter){
    return sitterService.saveSitter(sitter);
    }

    @DeleteMapping("/delete")
    public String deleteSitterById(@RequestBody Sitter sitter){
        sitterService.deleteSitterById(sitter.getId());
        return "Sitter deleted";
    }
    @CrossOrigin
    @PutMapping("/update")
    public Sitter updateSitter(@RequestBody Sitter sitter){

        return sitterService.updateSitter(sitter);
    }
    @CrossOrigin
    @PutMapping("/update/calendar")
    public Sitter updateSitterCalendar(@RequestBody Sitter sitter){

        return sitterService.updateSitterCalendar(sitter);
    }
}
