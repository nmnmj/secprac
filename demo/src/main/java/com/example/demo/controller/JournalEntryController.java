package com.example.demo.controller;

import com.example.demo.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<ObjectId, JournalEntry> journalEntry = new HashMap<>();

    @GetMapping("/get-journals")
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntry.values());
    }

//    @PostMapping("/create-journal")
//    public boolean createJournal(@RequestBody JournalEntry myentry){
//        journalEntry.put(myentry.getId(), myentry);
//        return true;
//    }

    @GetMapping("/id/{reqid}")
    public JournalEntry getJournal(@PathVariable ObjectId reqid){
        return journalEntry.get(reqid);
    }

    @DeleteMapping("/id/{reqid}")
    public JournalEntry deleteJournal(@PathVariable String reqid){
        return journalEntry.remove(reqid);
    }

    @PutMapping("/id/{reqid}")
    public JournalEntry updateJournal(@PathVariable ObjectId reqid, @RequestBody JournalEntry upjournal){
        return journalEntry.put(reqid, upjournal);
    }
}
