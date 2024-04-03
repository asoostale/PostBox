package com.postbox.domain.post.reply;

import com.postbox.domain.post.Post;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ReplyForm {

    private String contents;



    public ReplyForm() {
    }

    public ReplyForm(String contents) {
        this.contents = contents;

    }
}
