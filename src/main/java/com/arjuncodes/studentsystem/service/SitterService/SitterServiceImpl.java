package com.arjuncodes.studentsystem.service.SitterService;

import com.arjuncodes.studentsystem.model.SitterModel.Sitter;
import com.arjuncodes.studentsystem.repository.SitterRepository.SitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SitterServiceImpl implements SitterService {

    @Autowired
    private SitterRepository sitterRepository;

    @Override
    public Sitter saveSitter(Sitter sitter) {
        return sitterRepository.save(sitter);
    }

    @Override
    public List<Sitter> getAllSitter() {
        return sitterRepository.findAll();
    }
    public List<Sitter> filerSitter(String cat, String fitler1, String filter2, String filter3, String filter4, String filter5, String filter6){
        List<Sitter> ListByCat;
        List<Sitter> filteredSitters = new ArrayList<>();
        if(cat.equals("all")){
           ListByCat = getAllSitter();
        }else {
//           ListByCat =  getAllProduct().stream().filter(e -> e.getCategory().equals(cat)).collect(Collectors.toList());
        }

//        if(fitler1.equals("true")) {
//            List<Sitter>  filteredProductsBlack   = ListByCat.stream().filter(e -> e.getColor().equals("black")).collect(Collectors.toList());
//            for (Sitter sitter : filteredProductsBlack)
//            {
//                filteredSitters.add(sitter);
//            }
//        }
//        if(filter2.equals("true")) {
//            List<Sitter>  filteredProductsWhite  = ListByCat.stream().filter(e -> e.getColor().equals("blue")).collect(Collectors.toList());
//            for (Sitter sitter : filteredProductsWhite)
//            {
//                filteredSitters.add(sitter);
//            }
//        }
//        if(filter3.equals("true")) {
//            List<Sitter>  filteredProductsBlue  = ListByCat.stream().filter(e -> e.getColor().equals("white")).collect(Collectors.toList());
//            for (Sitter sitter : filteredProductsBlue)
//            {
//                filteredSitters.add(sitter);
//            }
//        }
//        if(filter4.equals("true")) {
//            List<Sitter>  filteredProductsBlue  = ListByCat.stream().filter(e -> e.getSize().equals("xl")).collect(Collectors.toList());
//            for (Sitter sitter : filteredProductsBlue)
//            {
//                filteredSitters.add(sitter);
//            }
//        }
//        if(filter5.equals("true")) {
//            List<Sitter>  filteredProductsBlue  = ListByCat.stream().filter(e -> e.getSize().equals("m")).collect(Collectors.toList());
//            for (Sitter sitter : filteredProductsBlue)
//            {
//                filteredSitters.add(sitter);
//            }
//        }
//        if(filter6.equals("true")) {
//            List<Sitter>  filteredProductsBlue  = ListByCat.stream().filter(e -> e.getSize().equals("s")).collect(Collectors.toList());
//            for (Sitter sitter : filteredProductsBlue)
//            {
//                filteredSitters.add(sitter);
//            }
//        }
//        if(fitler1.equals("false") && filter2.equals("false") && filter3.equals("false") && filter4.equals("false") &&  filter5.equals("false") && filter6.equals("false")  ){
//            if(cat.equals("all")){
//                return getAllProduct();
//            }
//           else{ return  getAllProduct().stream().filter(e -> e.getCategory().equals(cat)).collect(Collectors.toList());}
//        }
        return filteredSitters;
    }

    @Override
    public Sitter fetchSitterById(Long sitterId) {
        return sitterRepository.findById(sitterId).get();
    }

    @Override
    public void deleteSitterById(Long sitterId) {
        sitterRepository.deleteById(sitterId);
    }

    @Override
    public Sitter updateSitter(Sitter sitter) {
        Sitter sitterDB = sitterRepository.findById(sitter.getId()).get();
        sitterDB.setName(sitter.getName());
        sitterDB.setImage(sitter.getImage());
        sitterDB.setSurName(sitter.getSurName());
        sitterDB.setDescription(sitter.getDescription());
        sitterDB.setEmail(sitter.getEmail());
        sitterDB.setTelephone(sitter.getTelephone());
        sitterDB.setAddress(sitter.getAddress());
        sitterDB.setStartingDate(sitter.getStartingDate());
        sitterDB.setEndingDate(sitter.getEndingDate());
        sitterDB.setPassword(sitter.getPassword());

        if(sitterDB.getTakenDates() == null || sitterDB.getTakenDates().equals("") ){
            return sitterRepository.save(sitterDB);
        }
        if(sitter.getStartingDate() == null || sitter.getStartingDate().equals("") ||
                sitter.getEndingDate() == null || sitter.getEndingDate().equals("")
        ){          return sitterRepository.save(sitterDB);
        }
        if(sitterDB.getTakenDates() != null){
            sitterDB.setTakenDates(sitterDB.getTakenDates() + "|" + sitter.getStartingDate() + ";" + sitter.getEndingDate());
        } else {
            sitterDB.setTakenDates("|" + sitter.getStartingDate() + ";" + sitter.getEndingDate());
        }

        return  sitterRepository.save(sitterDB);
    }
    @Override
    public Sitter updateSitterCalendar(Sitter sitter) {
        Sitter sitterDB = sitterRepository.findById(sitter.getId()).get();

        if( sitter.getStartingDate().length() < 6 ){

            return sitterDB;
        }
        if(sitter.getStartingDate().length() < 6 ){

            return sitterDB;
        }

        if(sitterDB.getTakenDates() != null){
            sitterDB.setTakenDates(sitterDB.getTakenDates() + "|" + sitter.getStartingDate() + ";" + sitter.getEndingDate());
        } else {
            sitterDB.setTakenDates("|" + sitter.getStartingDate() + ";" + sitter.getEndingDate());
        }
        System.out.println(sitterDB.getTakenDates());
        return  sitterRepository.save(sitterDB);
    }
}
