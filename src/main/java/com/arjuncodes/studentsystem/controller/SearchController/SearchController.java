package com.arjuncodes.studentsystem.controller.SearchController;

import com.arjuncodes.studentsystem.model.ProductModel.Sitter;
import com.arjuncodes.studentsystem.model.SearchModel.Search;
import com.arjuncodes.studentsystem.service.ProductService.SitterService;
import com.arjuncodes.studentsystem.service.SearchService.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/search")
@CrossOrigin
public class SearchController {
    @Autowired
    private SearchService searchService;

    @PostMapping("/all")
    public Set<Sitter> listByCategoryAndFilter(@RequestBody Search search){
        try {
            return searchService.searchSitters(search.getCity(), search.getStartingDate(),
                    search.getEndingDate(), search.getOfferedServices());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/book/{id}")
    public void bookSitterById(@RequestBody Search search, @PathVariable("id") Long sitterId){
    searchService.bookSitterById(search, sitterId);
    }
    @PostMapping("accept/{id}")
    public void acceptJob(@RequestBody Search search, @PathVariable("id") Long sitterId){
        searchService.acceptJobById(search, sitterId);
    }
    @PostMapping("decline/{id}")
    public void declineJob(@RequestBody Search search, @PathVariable("id") Long sitterId){
        searchService.declineJobById(search, sitterId);
    }
    @PostMapping("history/{id}")
    public void finishJob(@RequestBody Search search, @PathVariable("id") Long sitterId){
        searchService.historyJobById(search, sitterId);
    }
}