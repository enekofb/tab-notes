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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (title != null ? !title.equals(note.title) : note.title != null) return false;
        return text != null ? text.equals(note.text) : note.text == null;

    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
