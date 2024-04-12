package com.postbox.domain.post;

import java.util.List;

public interface PostRepositoryCustom {

    List<Post> searchByTitle(String title);

    List<Post> searchByContents(String contents);

    List<Post> searchByTitleWithContents(String title, String contents);
}
