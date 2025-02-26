package com.example.demo.service;

import com.example.demo.entity.JournalEntry;
import com.example.demo.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public boolean saveJournal(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
        return true;
    }

    public List<JournalEntry> getAllJournal(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getJournal(ObjectId reqid){
        return journalEntryRepository.findById(reqid);
    }

    public void deleteJournal(ObjectId reqid){
        journalEntryRepository.deleteById(reqid);
    }


}
