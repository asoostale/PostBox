package com.postbox.domain.post;

import java.util.List;

public interface PostRepositoryCustom {

    List<Post> searchByTitle(String title);

    List<Post> searchByContent(String contents);

    List<Post> searchByTitleAndContent(String title, String contents);
}
