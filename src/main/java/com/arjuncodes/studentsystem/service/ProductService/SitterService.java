package com.arjuncodes.studentsystem.service.ProductService;

import com.arjuncodes.studentsystem.model.ProductModel.Sitter;

import java.util.List;

public interface SitterService {
    public Sitter saveSitter(Sitter sitter);
    public List<Sitter> getAllSitter();

   public Sitter fetchSitterById(Long sitterId);

    public void deleteSitterById(Long sitterId);

    public Sitter updateSitter(Sitter sitter);

    public List<Sitter> filerSitter(String cat, String fitler1, String filter2, String filter3,
                                      String filter4, String filter5, String filter6);
    public Sitter updateSitterCalendar(Sitter sitter);
}
