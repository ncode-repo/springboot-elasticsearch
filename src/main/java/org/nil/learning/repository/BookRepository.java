package org.nil.learning.repository;

import java.util.List;

import org.nil.learning.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<Book, String> {
	Page<Book> findByAuthor(String author, Pageable pageable);
	List<Book> findByTitle(String title);
}
