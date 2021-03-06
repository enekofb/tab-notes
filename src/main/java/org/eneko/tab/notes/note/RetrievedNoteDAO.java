package org.eneko.tab.notes.note;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by eneko on 25/06/17.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RetrievedNoteDAO {

    private String title;

    private String text;

}
