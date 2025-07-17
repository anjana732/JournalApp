package com.anjana.Journal.Services;

import com.anjana.Journal.Entity.JournalEntry;
import com.anjana.Journal.Entity.User;
import com.anjana.Journal.Repository.JournalEntryRepository;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;

    public void saveEntry(JournalEntry journalEntry, String username){
        User user = userService.findByUsername(username);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved = journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveEntry(user);
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
