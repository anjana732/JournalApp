package com.anjana.Journal.Services;

import com.anjana.Journal.Entity.JournalEntry;
import com.anjana.Journal.Repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public JournalEntry findById(ObjectId id){
        return journalEntryRepository.findById(id).orElse(null);
    }

    public JournalEntry updateEntry(ObjectId id, JournalEntry updatedEntry) {
        return journalEntryRepository.findById(id).map(existingEntry -> {
            existingEntry.setTitle(updatedEntry.getTitle()); // Example field
            existingEntry.setContent(updatedEntry.getContent()); // Example field
            return journalEntryRepository.save(existingEntry);
        }).orElse(null);
    }

    public void deleteEntry(ObjectId id){
          journalEntryRepository.deleteById(id);
    }
}
