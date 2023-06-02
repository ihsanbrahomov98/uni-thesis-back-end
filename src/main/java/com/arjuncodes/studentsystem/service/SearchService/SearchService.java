package com.arjuncodes.studentsystem.service.SearchService;

import com.arjuncodes.studentsystem.model.ProductModel.Sitter;
import com.arjuncodes.studentsystem.model.SearchModel.Search;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

public interface SearchService {
    public Set<Sitter> searchSitters(String fitler1, String filter2, String filter3, String filter4) throws ParseException;
    public void bookSitterById (Search search, Long id);
    public Search saveSearch(Search search);
    public void acceptJobById(Search search,Long id);
    public void declineJobById(Search search,Long id);
    public void historyJobById(Search search,Long id);
}
