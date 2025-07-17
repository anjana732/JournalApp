package com.anjana.Journal.Controller;

import com.anjana.Journal.Entity.JournalEntry;
import com.anjana.Journal.Entity.User;
import com.anjana.Journal.Services.JournalEntryService;
import com.anjana.Journal.Services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private UserService userService;

//    private Map<Long, JournalEntry> journalEntries = new HashMap<>();
    @GetMapping("{username}")
    public ResponseEntity<?> getAllJournalEntryOfUser(@PathVariable String username){
       User user =  userService.findByUsername(username);
       List<JournalEntry> all = user.getJournalEntries();
       if(all!=null && !all.isEmpty()){
           return new ResponseEntity<>(all, HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("{username}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry, @PathVariable String username){
//        journalEntries.put(myEntry.getId(), myEntry);

        try {
            myEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(myEntry,username);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getEntryById(@PathVariable ObjectId myId){
        JournalEntry entryById = journalEntryService.findById(myId);
        if(entryById != null){
            return new ResponseEntity<>(entryById, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteEntry(@PathVariable ObjectId myId){
      journalEntryService.deleteEntry(myId);
      return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("id/{myId}")
    public JournalEntry updateEntry(@PathVariable ObjectId myId, @RequestBody JournalEntry myEntry){
       return journalEntryService.updateEntry(myId,myEntry);
       // return null;
    }
}
