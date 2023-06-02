package com.arjuncodes.studentsystem.service.SearchService;

import com.arjuncodes.studentsystem.Enums.JobEnums.JobEnums;
import com.arjuncodes.studentsystem.model.AdminModel.Admin;
import com.arjuncodes.studentsystem.model.ProductModel.Sitter;
import com.arjuncodes.studentsystem.model.SearchModel.Search;
import com.arjuncodes.studentsystem.repository.SearchRepository.SearchRepository;
import com.arjuncodes.studentsystem.repository.SitterRepository.SitterRepository;
import com.arjuncodes.studentsystem.service.ProductService.SitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SitterRepository sitterRepository;
    @Autowired
    private SearchRepository searchRepository;
    @Autowired
    private SitterService sitterService;

    public Search saveSearch(Search search) {
        return searchRepository.save(search);
    }

    public void acceptJobById(Search search,Long id){
        Sitter sitterDB =  sitterService.fetchSitterById(id);
        if (sitterDB != null) {
            for (Search item : sitterDB.getJobs()) {
                if(item.getId().equals(search.getId())){
                    System.out.println(item.getJobStatus());
                    item.setJobStatus("accepted");
                    System.out.println(item.getId());
                    searchRepository.save(item);
                }
            }
        }
    }
    public void declineJobById(Search search,Long id){
        Sitter sitterDB =  sitterService.fetchSitterById(id);
        System.out.println(id);
        if (sitterDB != null) {
            for (Search item : sitterDB.getJobs()) {
                if(item.getId().equals(search.getId())){
                    System.out.println(item.getJobStatus());
                    item.setJobStatus("decline");
                    System.out.println(item.getId());
                    searchRepository.save(item);
                }
            }
        }
    }
    public void historyJobById(Search search,Long id){
        Sitter sitterDB =  sitterService.fetchSitterById(id);
        if (sitterDB != null) {
            for (Search item : sitterDB.getJobs()) {
                if(item.getId().equals(search.getId())){
                    System.out.println(item.getJobStatus());
                    item.setJobStatus("history");
                    System.out.println(item.getId());
                    searchRepository.save(item);
                }
            }
        }
    }
    public void bookSitterById (Search search, Long id){
        Sitter sitterDB =  sitterService.fetchSitterById(id);;
        if (sitterDB != null) {
            search.setJobStatus("pending");
            search.setSitter(sitterDB);
            searchRepository.save(search);
            sitterDB.getJobs().add(search);
            sitterRepository.save(sitterDB);
        }
        System.out.println(sitterDB.getJobs().size());
    }
    public Set<Sitter> searchSitters(String city, String startingDate, String endingDate, String offeredServices) throws ParseException {
        Set<Sitter>  filteredSitters = new HashSet<>();
        List<Sitter> listOfSitters = new ArrayList<>();
        List<Sitter> FilterSittersByCity = new ArrayList<>();

        listOfSitters = sitterRepository.findAll();
        for (Sitter item: listOfSitters) {
            if(item.getCity() !=null){
            if(item.getCity().equals(city)){
                FilterSittersByCity.add(item);
            }
        }
        }
        for (Sitter item : FilterSittersByCity) {
            if(item.getTakenDates() != null && !item.getTakenDates().equals("")){
            String[] firstIndex = item.getTakenDates().split("\\|");
            if(firstIndex.length > 1){
                boolean match = false;
                for (int index = 1; index < firstIndex.length; index++) {
                    LinkedList  rangeStartingAndEndingDate = new LinkedList();
                    LinkedList  rangeOfSittersTakenDates = new LinkedList();
                    String [] takenDates = firstIndex[index].split(";");

                    String firstTakenDate = takenDates[0];
                    String secondTakenDate = takenDates[1];

                    Date firstTakenDateConverted = convertDate(firstTakenDate);
                    Date secondTakenDateConverted = convertDate(secondTakenDate);
                    Date startingDateConverted = convertDate(startingDate);
                    Date endingDateConverted = convertDate(endingDate);

                    rangeOfSittersTakenDates = searchBetweenDates(firstTakenDateConverted,secondTakenDateConverted);
                    rangeStartingAndEndingDate =  searchBetweenDates(startingDateConverted,endingDateConverted);
                    match = !Collections.disjoint(rangeOfSittersTakenDates, rangeStartingAndEndingDate);

                    if(match){
                        break;
                    }

                }
                System.out.println(match);
                if(!match){
                    System.out.println("in");
                    filteredSitters.add(item);

                }
            }
            }
        }
        return filteredSitters;

    };
    public Date convertDate(String dateToBeConverted){
        TemporalAccessor ta2 = DateTimeFormatter.ISO_INSTANT.parse(dateToBeConverted);
        Instant i2 = Instant.from(ta2);
        Date d2 = Date.from(i2);
        return  d2;
    }
    public LinkedList searchBetweenDates(Date startDate, Date endDate)
    {
        Date begin = new Date(startDate.getTime());
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();

        while(begin.compareTo(endDate)<0)
        {
            begin = new Date(begin.getTime() + 86400000);
            list.add(new Date(begin.getTime()));
        }

        return list;
    }
//    boolean isWithinRange(Date testDate,Date firstTakenDate, Date secondTakenDate ) {
//        return testDate.getTime() >= firstTakenDate.getTime() &&
//                testDate.getTime() <= secondTakenDate.getTime();
//    }
    //                    Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(firstTakenDate);
//                    System.out.println(date1+"\t"+date1);
}

// const calculateTakenDates = (takenDates) => {
//         let arrayOfTakenDate = [];
//         let firstTakenDate;
//         let lastTakenDate;
//
//         let endDatCasted;
//         let dateCasted;
//         let firstIndex = takenDates && takenDates.split("|");
//         if (firstIndex) {
//         for (let index = 1; index < firstIndex.length; index++) {
//        firstTakenDate = firstIndex[index].split(";")[0];
//        lastTakenDate = firstIndex[index].split(";")[1];
//        arrayOfTakenDate.push(addDays(new Date(firstTakenDate), 0));
//        arrayOfTakenDate.push(addDays(new Date(lastTakenDate), 0));
//
//        dateCasted = new Date(firstTakenDate);
//        endDatCasted = new Date(lastTakenDate);
//        while (dateCasted <= endDatCasted) {
//        console.log("date:", dateCasted);
//        arrayOfTakenDate.push(new Date(dateCasted));
//        dateCasted.setDate(dateCasted.getDate() + 1);
//        }
//        }
//        }
//
//        return arrayOfTakenDate;
//        };
//    public List<Sitter> filerSitter(String cat, String fitler1, String filter2, String filter3, String filter4, String filter5, String filter6){
//        List<Sitter> ListByCat;
//        List<Sitter> filteredSitters = new ArrayList<>();
//        if(cat.equals("all")){
//
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
//        return filteredSitters;
//    }