package com.anjana.Journal.Controller;

import com.anjana.Journal.Entity.JournalEntry;
import com.anjana.Journal.Services.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

//    private Map<Long, JournalEntry> journalEntries = new HashMap<>();
    @GetMapping
    public List<JournalEntry> getAll(){
//       return new ArrayList<>(journalEntries.values());
       return journalEntryService.getAll();
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
//        journalEntries.put(myEntry.getId(), myEntry);
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getEntryById(@PathVariable ObjectId myId){
        return journalEntryService.findById(myId);
       // return null;
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteEntry(@PathVariable ObjectId myId){
      journalEntryService.deleteEntry(myId);
      return true;
    }

    @PutMapping("id/{myId}")
    public JournalEntry updateEntry(@PathVariable ObjectId myId, @RequestBody JournalEntry myEntry){
       return journalEntryService.updateEntry(myId,myEntry);
       // return null;
    }
}
