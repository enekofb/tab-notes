package org.eneko.tab.notes.note;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by eneko on 25/06/17.
 */
public interface NoteRepository extends MongoRepository<Note, Long> {
}
