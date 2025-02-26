package com.example.demo.controller;

import com.example.demo.entity.JournalEntry;
import com.example.demo.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journalp")
public class JournalEntryControllerPersistant {
//    private Map<String, JournalEntry> journalEntry = new HashMap<>();

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping("/get-journals")
    public List<JournalEntry> getAll(){
        try {
            return journalEntryService.getAllJournal();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

//        return new ArrayList<>(journalEntry.values());
    }

    @PostMapping("/create-journal")
    public boolean createJournal(@RequestBody JournalEntry myentry){
        myentry.setDate(LocalDateTime.now());
        return journalEntryService.saveJournal(myentry);
//        journalEntry.put(myentry.getId(), myentry);
//        return true;
    }

    @GetMapping("/id/{reqid}")
    public Optional<JournalEntry> getJournal(@PathVariable ObjectId reqid){
        System.out.println(reqid);
        return journalEntryService.getJournal(reqid);
//        return journalEntry.get(reqid);
    }
//
    @DeleteMapping("/id/{reqid}")
    public boolean deleteJournal(@PathVariable ObjectId reqid){
        journalEntryService.deleteJournal(reqid);
        return true;
    }
//
    @PutMapping("/id/{reqid}")
    public JournalEntry updateJournal(@PathVariable ObjectId reqid, @RequestBody JournalEntry upjournal){
        JournalEntry old = journalEntryService.getJournal(reqid).orElse(null);
        System.out.println("old");
        System.out.println(old);
        System.out.println(old.getTitle());

        if(old != null){
            old.setTitle((upjournal.getTitle() != null && upjournal.getTitle().isEmpty()) ? upjournal.getTitle() : old.getTitle() );
            old.setContent((upjournal.getContent() != null && upjournal.getContent().isEmpty()) ? upjournal.getContent() : old.getContent() );
        }
        upjournal.setDate(LocalDateTime.now());
        journalEntryService.saveJournal(upjournal);
        return old;
//        return journalEntry.put(reqid, upjournal);
    }
}
