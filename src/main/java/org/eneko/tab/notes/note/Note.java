package org.eneko.tab.notes.note;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by eneko on 25/06/17.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "note")
@Getter
public class Note {

    @Id
    private String id;

    private String title;

    private String text;

}
