package com.anjana.Journal.Repository;

import com.anjana.Journal.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoAdminOperations;

public interface UserRepository extends MongoAdminOperations<User, ObjectId> {
}
