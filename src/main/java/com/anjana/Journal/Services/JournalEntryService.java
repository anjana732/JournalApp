package com.anjana.Journal.Services;

import com.anjana.Journal.Entity.JournalEntry;
import com.anjana.Journal.Repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ClientInfoStatus;
import java.util.List;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

//    public JournalEntry updateEntry(JournalEntry journalEntry){
//
//    }

//    public JournalEntry findById(ObjectId id){
//        return journalEntryRepository.findBy(id);
//
//    }

}
