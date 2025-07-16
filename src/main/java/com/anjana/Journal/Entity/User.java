package com.anjana.Journal.Entity;

import jakarta.annotation.Nonnull;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
public class User {

    @Id
    private ObjectId id;
    @Nonnull
    private String username;
    @Nonnull
    private String password;
    @DBRef
    private List<JournalEntry> journalEntries = new ArrayList<>();
}
