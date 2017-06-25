package org.eneko.tab.notes.note;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by eneko on 25/06/17.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateNoteDAO {
    private String title;
    private String text;
    private String password;
}
